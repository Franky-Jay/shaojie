package com.mashen.user.service;

import java.util.List;
import java.util.Map;

import com.mashen.common.domain.PageVO;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.organization.domain.OrganizationVO;
import com.mashen.role.domain.RoleVO;
import com.mashen.user.domain.UserVO;

public interface UserService {
	public void addUser(UserVO user) throws Throwable;
	
	public void deleteUser(String id) throws Throwable;
	
	public void updateUser(UserVO user) throws Throwable;
	
	public UserVO getUserByAccount(String account) throws Throwable;
	
	public UserVO getUserById(String id) throws Throwable;
	
	public UserVO checkLogin(String account,String pwd) throws Throwable;
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<UserVO> list(DataTablesRequest request) throws Throwable;
	
	/**
	 * 普通分页查询
	 * @param request
	 * @return
	 */
	public PageVO<UserVO> list(PageVO<UserVO> pagevo,Map<String,Object> request) throws Throwable;
	
	/**
	 * 给用户添加角色
	 * @param roles
	 */
	public void addRoles(List<RoleVO> roles, UserVO user) throws Throwable;
	
	/**
	 * 查询全部的部门名称
	 * @param pid
	 * @return
	 * @throws Throwable
	 */
	public List<OrganizationVO> listUser() throws Throwable;
}
