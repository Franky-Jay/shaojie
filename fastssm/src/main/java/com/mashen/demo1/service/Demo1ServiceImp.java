package com.mashen.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.common.util.SearchConditionUtils;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.demo1.dao.DemoVOMapper;
import com.mashen.demo1.domain.DemoVO;
import com.mashen.demo1.domain.DemoVOExample;
import com.mashen.privilege.aop.annotation.SearchCondition;
import com.mashen.privilege.aop.annotation.SearchConditionType;

@Service
public class Demo1ServiceImp implements Demo1Service {
	@Autowired
	private DemoVOMapper mapper ;
	@Override
	public int add(DemoVO entity) {
		return mapper.insertSelective(entity);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(DemoVO entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public DemoVO get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public DataTablesResponse<DemoVO> listByPage(@SearchCondition(SearchConditionType.DATATABLES) DataTablesRequest request) throws Throwable {
		DemoVOExample example = new DemoVOExample() ;
		DataTablesResponse<DemoVO> response = new DataTablesResponse<DemoVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
	}

}
