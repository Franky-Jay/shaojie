package com.mashen.permission.service;

import java.util.List;
import java.util.Set;

import com.mashen.permission.domain.PermissionVO;
import com.mashen.permission.domain.PermissionVOExt;

/**
 * 功能权限
 * @author Administrator
 *
 */
public interface PermissionService {
	/**
	 * 添加一级菜单
	 * @param permission
	 * @return
	 * @throws Throwable
	 */
	public Integer addPermission(PermissionVO permission) throws Throwable;
	
	/**
	 * 删除菜单
	 * @param permissionId 
	 * @return
	 * @throws Throwable
	 */
	public Integer deletePermission(String permissionId) throws Throwable;
	/**
	 * 更新菜单
	 * @param permission
	 * @return
	 * @throws Throwable
	 */
	public Integer updatePermission(PermissionVO permission) throws Throwable;
	/**
	 * 查询所有
	 * @return
	 * @throws Throwable
	 */
	public List<PermissionVO> selectAll() throws Throwable;
	
	/**
	 * 获取所有父级
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	public List<PermissionVO> getFirstPid(String id) throws Throwable;
	
	
	public PermissionVO getPermissionVO(String permissionId) throws Throwable;
	
	public int delPermissionVO(String permissionId) throws Throwable;
	
	public Set<PermissionVOExt> getPermissionByPid(String id);
	
	public Set<PermissionVOExt> getAllPermissonVOExt();
	
	public int getSize();
}
