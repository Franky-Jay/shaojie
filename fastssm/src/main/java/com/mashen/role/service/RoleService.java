package com.mashen.role.service;

import java.util.List;
import java.util.Map;

import com.mashen.common.domain.PageVO;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.role.domain.RoleVO;

public interface RoleService {
	public void addRole(RoleVO role) throws Throwable;
	
	public void deleteRole(String id) throws Throwable;
	
	public void deleteByExa(Map<String,Object> request) throws Throwable;
	
	public void updateRole(RoleVO role) throws Throwable;
	
	public void updateByExa(RoleVO role,Map<String,Object> request) throws Throwable;
	
	public RoleVO getRoleById(String role_id) throws Throwable;
	
	public List<RoleVO> getRoleByExa(Map<String,Object> request) throws Throwable;
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<RoleVO> list(DataTablesRequest request) throws Throwable;
	
	/**
	 * 普通分页查询
	 * @param request
	 * @return
	 */
	public PageVO<RoleVO> list(PageVO<RoleVO> pagevo,Map<String,Object> request) throws Throwable;
	
	public List<RoleVO> listRole() throws Throwable;
}
