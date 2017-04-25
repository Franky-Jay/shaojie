package com.mashen.organization.service;

import java.util.List;
import java.util.Map;

import com.mashen.common.domain.PageVO;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.organization.domain.OrganizationVO;

public interface OrganizationService {
	public Integer add(OrganizationVO organization) throws Throwable;

	public void delete(String id) throws Throwable;

	public void update(OrganizationVO organization) throws Throwable;

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public OrganizationVO get(String id);

	/**
	 * 根据pid查询，返回list。
	 * @param pid
	 * @return
	 */
	public List<OrganizationVO> getByPId(String pid);

	/**
	 * 使用datatables的分页查询
	 * 
	 * @param request
	 * @return
	 */
	public DataTablesResponse<OrganizationVO> list(DataTablesRequest request) throws Throwable;

	/**
	 * 普通分页查询
	 * 
	 * @param request
	 * @return
	 */
	public PageVO<OrganizationVO> list(PageVO<OrganizationVO> pagevo, Map<String, Object> request) throws Throwable;
}
