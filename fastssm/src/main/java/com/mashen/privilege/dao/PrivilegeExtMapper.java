package com.mashen.privilege.dao;

import java.util.LinkedHashSet;
import java.util.List;
import com.mashen.permission.domain.PermissionVOExt;

public interface PrivilegeExtMapper {
    
	/**
	 * 获取用户的所有角色
	 * @param userid
	 * @return
	 */
	public List<String> listRoleByUserId(String userid);
	/**
	 * 获取角色的所有功能权限(包括菜单和按钮)
	 * @param roleid
	 * @return
	 */
	public LinkedHashSet<PermissionVOExt> listMenuPermissionByRoleId(String roleid);
	
	/**
	 * 获取角色的所有按钮权限
	 * @param roleid
	 * @return
	 */
	public LinkedHashSet<PermissionVOExt> listButtonPermissionByRoleId(String roleid);
}
