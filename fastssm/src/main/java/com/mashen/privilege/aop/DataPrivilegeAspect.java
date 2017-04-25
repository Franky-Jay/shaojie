package com.mashen.privilege.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.mashen.common.domain.CurrentUser;
import com.mashen.common.util.SpringUtil;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.privilege.aop.annotation.DataPrivilege;
import com.mashen.privilege.aop.annotation.SearchCondition;
import com.mashen.privilege.aop.annotation.SearchConditionType;
import com.mashen.privilege.datarule.CustomRule;
import com.mashen.privilege.datarule.CustomRuleType;
import com.mashen.privilege.datarule.DataRules;
import com.mashen.privilege.exception.DataAccessDeniedException;

/**
 * 数据权限切面，拦截service
 * 
 * @author liushd
 *
 */
public class DataPrivilegeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Object validate(ProceedingJoinPoint point) throws Throwable {

		logger.debug("DataPrivilegeAspect validate invoke");
		Object target = point.getTarget();

		Signature signature = point.getSignature();
		MethodSignature msig = (MethodSignature) signature;

		Method currentMethod = target.getClass().getMethod(msig.getName(),
				msig.getParameterTypes());

		if (currentMethod != null
				&& currentMethod.isAnnotationPresent(DataPrivilege.class)) {

			// 得到方法上的注解
			DataPrivilege permission = currentMethod
					.getAnnotation(DataPrivilege.class);
			CurrentUser currentUser = SpringUtil.getBean(CurrentUser.class);
			// 获取数据访问权限
			String privilege = currentUser.getDataPrivilege(permission.value());
			if(StringUtils.isEmpty(privilege)){//无访问规则，则认为无权限访问
				throw new DataAccessDeniedException("对不起，你无权限查询此数据！");
			}else{// 有配置访问规则，则加上访问规则

				Parameter[] params = currentMethod.getParameters();
				Object[] args = point.getArgs();
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						Parameter param = params[i];
						SearchCondition scd = param
								.getAnnotation(SearchCondition.class);
						if (scd != null) {
							SearchConditionType st = scd.value();
							logger.debug("SearchConditionType:" + st.name());
							if (SearchConditionType.DATATABLES.equals(st)) {
								// 通过DataTablesRequest封装的查询条件
								if (args[i] instanceof DataTablesRequest) {
									DataTablesRequest dtbreq = (DataTablesRequest) args[i];
									setSearchCondition(
											dtbreq.getSearchColumns(),
											privilege, currentUser);
								}
							} else if (SearchConditionType.MAP.equals(st)) {
								// 通过Map<String,Object>封装的查询条件
								if (args[i] instanceof Map) {
									Map<String, Object> conditionMap = (Map<String, Object>) args[i];
									setSearchCondition(conditionMap, privilege,
											currentUser);
								}

							} else {
								logger.warn("SearchConditionType is null");
							}
						}
					}
				}

			}

		}
		return point.proceed();

	}

	private void setSearchCondition(Map<String, Object> conditionMap,
			String privilege, CurrentUser currentUser) {

		if (DataRules.ONESELF.equals(privilege)) {// 只能看本人创建的数据
			conditionMap.put(DataRules.ONESELF, currentUser.getUserId());
			logger.debug("只能看本人创建的数据");
			return;
		} else if (DataRules.DEPARTMENT.equals(privilege)) {// 只能看本部门创建的数据(不包括下级)
			conditionMap.put(DataRules.DEPARTMENT,
					currentUser.getDepartmentId());
			logger.debug("只能看本部门创建的数据(不包括下级)");
			return;
		} else if (DataRules.DEPARTMENT_AND_SUB.equals(privilege)) {// 只能看本部门及下级创建的数据
			conditionMap.put(DataRules.DEPARTMENT_AND_SUB,
					currentUser.getDepartmentId() + "%");
			logger.debug("只能看本部门及下级创建的数据");
			return;
		} else {// 自定义规则，用于查看跨部门数据
			//{"type":"currid","value":"111"}
			CustomRule customRule = JSONObject.parseObject(privilege,
					CustomRule.class);
			if (CustomRuleType.CurrentUserID.equals(customRule.getType())) {
				String userid = currentUser.getUserId();
				if (userid != null && userid.equals(customRule.getValue())) {
					return;
				}
			} else if (CustomRuleType.CurrentRoleID
					.equals(customRule.getType())) {
				List<String> roles = currentUser.getRoles();
				if (roles.contains(customRule.getValue())) {
					return;
				}
			} else if (CustomRuleType.CurrentDepartMentID.equals(customRule
					.getType())) {
				String departmentid = currentUser.getDepartmentId();
				if (departmentid != null
						&& departmentid.equals(customRule.getValue())) {
					logger.debug("数据权限符合自定义规则");
					return;
				}
			}
		}
		//没有设置任何查询规则，则认为无权限查询数据
		throw new DataAccessDeniedException("对不起，你无权限查询此数据！");
	}
	
}
