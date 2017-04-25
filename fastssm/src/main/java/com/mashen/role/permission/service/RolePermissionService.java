package com.mashen.role.permission.service;

import java.util.List;

import com.mashen.permission.domain.PermissionVO;
import com.mashen.role.permission.domain.RolePermissionVO;


/**
 * 用户授权service
 * @author wurui
 */
public interface RolePermissionService {
	
	public int addPermission(RolePermissionVO record ) throws Throwable;
	public int updatePermission(String roleid ,PermissionVO permissionVO) throws Throwable;
	public void deletePermission(String roleid) throws Throwable;
	public List<RolePermissionVO> getRolePermissionVOList(String roleid) throws Throwable;
}
