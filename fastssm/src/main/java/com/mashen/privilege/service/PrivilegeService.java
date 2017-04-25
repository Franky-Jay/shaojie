package com.mashen.privilege.service;

import java.util.List;
import java.util.Set;
import com.mashen.permission.domain.PermissionVOExt;

public interface PrivilegeService {
	/**
	 * 获取用户的所有角色
	 * @param userid
	 * @return
	 */
	public List<String> listUserRoles(String userid);
	/**
	 * 获取角色的所有功能菜单
	 * @param roleid
	 * @return
	 */
	public Set<PermissionVOExt> listUserMenuPermissions(List<String> roleList);
	/**
	 * 获取角色的所有功能菜单-树形结构
	 * @param allMenu
	 * @return
	 */
	public Set<PermissionVOExt> listUserMenuTreePermissions(Set<PermissionVOExt> allMenu);
	
	/**
	 * 获取角色的所有功能按钮
	 * @param roleid
	 * @return
	 */
	public Set<PermissionVOExt> listUserButtonPermissions(List<String> roleList);
	
}
