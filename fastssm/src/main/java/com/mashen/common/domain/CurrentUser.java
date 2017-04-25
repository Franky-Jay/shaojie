package com.mashen.common.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mashen.common.util.SpringUtil;
import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.user.domain.UserVO;

@Component
@Scope("session")
public class CurrentUser {
	
	@Autowired
	private HttpSession session;
	
	
	public static CurrentUser getInstance(){
		return SpringUtil.getBean(CurrentUser.class) ;
	}
	/**
	 * 获取当前用户对象，登录成功或设置到session
	 * @return
	 */
	public UserVO getCurrentUser(){
		UserVO user=(UserVO)session.getAttribute("s_user");
		return user;
	}
	/**
	 * 获取当前登录用户ID
	 * @return
	 */
	public String getUserId(){
		UserVO user=getCurrentUser();
		if(user!=null){
			return user.getUserId();
		}
		return null;
	}
	
	/**
	 * 获取当前登录用户name
	 * @return
	 */
	public String getUserName(){
		UserVO user=getCurrentUser();
		if(user!=null){
			return user.getName();
		}
		return null;
	}
	
	
	/**
	 * 获取当前用户的组织ID
	 * @return
	 */
	public String getDepartmentId(){
		UserVO user=getCurrentUser();
		if(user!=null){
			return user.getDepartmentId();
		}
		return null;
	}
	/**
	 * 获取当前登录账号
	 * @return
	 */
	public String getAccount(){
		UserVO user=getCurrentUser();
		if(user!=null){
			return user.getAccount();
		}
		return null;
	}
	
	/**
	 * 获取该用户所有的角色
	 * @return
	 */
	public List<String> getRoles(){
		return (List<String>)session.getAttribute("s_roles");
	}
	
	
	/**
	 * 获取该用户的所有功能权限，登录成功或设置到session
	 * @return
	 */
	public Set<PermissionVOExt> getFunctionPrivileges(){
		return (Set<PermissionVOExt>)session.getAttribute("s_functionPrivileges");
	}
	
	/**
	 * 获取该用户的所有按钮功能权限，登录成功或设置到session
	 * @return
	 */
	public Set<PermissionVOExt> getButtonPrivileges(){
		return (Set<PermissionVOExt>)session.getAttribute("s_buttonPrivileges");
	}
	
	
	/**
	 * 获取该用户的所有功能权限树，登录成功或设置到session
	 * @return
	 */
	public Set<PermissionVOExt> getFunctionPrivilegesTree(){
		return (Set<PermissionVOExt>)session.getAttribute("s_functionPrivilegesTree");
	}
	
	/**
	 * 通过业务编码获取数据访问规则，登录成功或设置到session
	 * @return
	 */
	public String getDataPrivilege(String serviceCode){
		Map<String,String> dataPrivileges=(Map<String,String>)session.getAttribute("s_dataPrivileges");
		return dataPrivileges.get(serviceCode);
	}
}
