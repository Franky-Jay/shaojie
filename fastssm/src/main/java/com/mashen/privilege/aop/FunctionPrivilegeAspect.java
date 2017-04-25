package com.mashen.privilege.aop;

import java.lang.reflect.Method;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashen.common.domain.CurrentUser;
import com.mashen.common.util.SpringUtil;
import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.privilege.aop.annotation.FunctionPrivilege;
import com.mashen.privilege.exception.FunctionAccessDeniedException;
/**
 * 功能权限切面，拦截controller
 * @author liushd
 *
 */
public class FunctionPrivilegeAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Object validate(ProceedingJoinPoint  point) throws Throwable{
		logger.debug("FunctionPrivilegeAspect validate invoke");
		Object target=point.getTarget();
        Signature signature=point.getSignature();
        MethodSignature  msig = (MethodSignature) signature;
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		if(target.getClass().isAnnotationPresent(FunctionPrivilege.class)||currentMethod!=null && currentMethod.isAnnotationPresent(FunctionPrivilege.class)){
			 String fullclasspath=target.getClass().getName()+":"+currentMethod.getName();
			 logger.debug("FunctionPrivilegeAspect class:"+fullclasspath);
			 CurrentUser currentUser=SpringUtil.getBean(CurrentUser.class);
			//判断是否有权限
			Set<PermissionVOExt> privileges=currentUser.getFunctionPrivileges();
			if(isCanAccess(privileges,fullclasspath)){
				 logger.debug("有菜单访问权限:"+fullclasspath);
				return point.proceed();
			}else{
				 logger.warn("对不起，你无权限访问该资源:"+fullclasspath);
				throw new FunctionAccessDeniedException("对不起，你无权限访问该资源！");
			}
		
		}
		return point.proceed();
		
	}
	private boolean isCanAccess(Set<PermissionVOExt> allpms,String fullclasspath){
		if(allpms!=null){
			for(PermissionVOExt pms : allpms){
				if(fullclasspath.equals(pms.getClasspath())){
					return true;
				}
			}
		}
		return false;
	}
}
