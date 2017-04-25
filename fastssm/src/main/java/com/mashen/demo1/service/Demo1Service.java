package com.mashen.demo1.service;

import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.demo1.domain.DemoVO;

public interface Demo1Service {
	public int add(DemoVO entity);
	public int delete(Integer id);
	public int update(DemoVO entity);
	public DemoVO get(Integer id);
	
	/**
	 * 使用datatables的分页查询
	 * @param request
	 * @return
	 */
	public DataTablesResponse<DemoVO> listByPage(DataTablesRequest request) throws Throwable;
}
