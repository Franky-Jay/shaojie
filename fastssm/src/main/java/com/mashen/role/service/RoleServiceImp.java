package com.mashen.role.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.common.domain.PageVO;
import com.mashen.common.util.IDUtil;
import com.mashen.common.util.SearchConditionUtils;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.privilege.aop.annotation.SearchCondition;
import com.mashen.privilege.aop.annotation.SearchConditionType;
import com.mashen.role.dao.RoleVOMapper;
import com.mashen.role.domain.RoleVO;
import com.mashen.role.domain.RoleVOExample;

@Service
public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleVOMapper mapper;

	@Override
	public void addRole(RoleVO role) throws Throwable {
		role.setRoleId(IDUtil.uuid());
		role.setOrders(IDUtil.sequence());
		mapper.insertSelective(role);
	}

	@Override
	public void deleteRole(String id) throws Throwable {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByExa(Map<String, Object> request) throws Throwable {
		RoleVOExample example = new RoleVOExample();
		Object object = request.get("name");
		if (object != null) {
			example.createCriteria().andNameLike(object + "%");
		}
	}

	@Override
	public void updateRole(RoleVO role) throws Throwable {
		mapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public RoleVO getRoleById(String role_id) throws Throwable {
		return mapper.selectByPrimaryKey(role_id);
	}

	@Override
	public DataTablesResponse<RoleVO> list(
			 DataTablesRequest request) throws Throwable {
		RoleVOExample example=new RoleVOExample();
		DataTablesResponse<RoleVO> response=new DataTablesResponse<RoleVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);
		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
	}

	@Override
	public PageVO<RoleVO> list(PageVO<RoleVO> pagevo,
			@SearchCondition(SearchConditionType.MAP) Map<String, Object> request) throws Throwable {
		RoleVOExample example = new RoleVOExample();
		SearchConditionUtils.wrapperAndCondition(example, pagevo, request);
		pagevo.setTotalRecord(mapper.countByExample(example));
		pagevo.setRecords(mapper.selectByExample(example));
		return pagevo;
	}

	@Override
	public void updateByExa(RoleVO role,Map<String, Object> request) throws Throwable {
		RoleVOExample example = new RoleVOExample();
		Object object = request.get("name");
		if (object != null) {
			example.createCriteria().andNameLike(object + "%");
		}
		mapper.updateByExampleSelective(role, example);
	}

	@Override
	public List<RoleVO> getRoleByExa(Map<String, Object> request) throws Throwable {
		RoleVOExample example = new RoleVOExample();
		Object object = request.get("name");
		if (object != null) {
			example.createCriteria().andNameLike(object + "%");
		}
		return mapper.selectByExample(example);
	}

	@Override
	public List<RoleVO> listRole() throws Throwable {
		RoleVOExample example = new RoleVOExample();
		example.createCriteria().andNameLike(""+"%");
		List<RoleVO> list = mapper.selectByExample(example);
		return list;
	}

}
