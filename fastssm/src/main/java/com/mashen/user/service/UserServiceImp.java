package com.mashen.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.common.dao.CommonMapper;
import com.mashen.common.domain.PageVO;
import com.mashen.common.domain.Sequence;
import com.mashen.common.util.IDUtil;
import com.mashen.common.util.MD5Util;
import com.mashen.common.util.SearchConditionUtils;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.organization.dao.OrganizationVOMapper;
import com.mashen.organization.domain.OrganizationVO;
import com.mashen.organization.domain.OrganizationVOExample;
import com.mashen.privilege.aop.annotation.SearchCondition;
import com.mashen.privilege.aop.annotation.SearchConditionType;
import com.mashen.role.domain.RoleVO;
import com.mashen.user.dao.UserVOExtMapper;
import com.mashen.user.dao.UserVOMapper;
import com.mashen.user.domain.UserVO;
import com.mashen.user.domain.UserVOExample;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserVOMapper mapper;
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private UserVOExtMapper extMapper;
	@Autowired
	private OrganizationVOMapper ormapper;
	@Override
//	@DataPrivilege("user")
	public DataTablesResponse<UserVO> list(
			@SearchCondition(SearchConditionType.DATATABLES) DataTablesRequest request)
			throws Throwable {
		UserVOExample example = new UserVOExample();
		DataTablesResponse<UserVO> response = new DataTablesResponse<UserVO>();
		SearchConditionUtils.wrapperAndCondition(example, request);// 封装查询条件

		response.setDraw(request.getDraw());
		response.setRecordsTotal(mapper.countByExample(example));
		response.setData(mapper.selectByExample(example));
		return response;
	}

	@Override
//	@DataPrivilege("user")
	public PageVO<UserVO> list(
			PageVO<UserVO> pagevo,
			@SearchCondition(SearchConditionType.MAP) Map<String, Object> conditionMap)
			throws Throwable {
		UserVOExample example = new UserVOExample();
		SearchConditionUtils.wrapperAndCondition(example, pagevo, conditionMap);// 封装查询条件
		pagevo.setTotalRecord(mapper.countByExample(example));
		pagevo.setRecords(mapper.selectByExample(example));
		return pagevo;
	}
	
	@Override
	public void addUser(UserVO user) throws Throwable {
		user.setUserId(IDUtil.uuid());
		String salt=IDUtil.uuid();
		user.setSalt(salt);
		user.setPassword(MD5Util.md5(user.getPassword()+salt));
		System.out.println("---------------------------->" + user.getOrgName());
		
		mapper.insertSelective(user);
	}
   
	
	@Override
	public void deleteUser(String id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUser(UserVO user) {
		mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserVO getUserByAccount(String account) {
		UserVOExample example = new UserVOExample();
		example.createCriteria().andAccountEqualTo(account);
		List<UserVO> list = mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserVO getUserById(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	@Override
	public UserVO checkLogin(String account,String pwd) throws Throwable{
		UserVO user=this.getUserByAccount(account);
		if(user!=null){
			String inputPwd=MD5Util.md5(pwd+user.getSalt());
			if(user.getPassword().equals(inputPwd)){//验证通过
				return user;
			}
		}
		return null;
		
	}
	
	@Transactional
	@Override
	public void addRoles(List<RoleVO> roles, UserVO user) throws Throwable {
		this.addUser(user);
		Map<String,Object> condition = new HashMap<>();
		Sequence sequence = new Sequence();
		System.out.println("*******roles:"+roles);
		for(RoleVO role : roles){
			commonMapper.getSequence(sequence);
			condition.put("user_role_id", sequence.getId());
			condition.put("userId", user.getUserId());
			condition.put("roleId", role.getRoleId());
			this.extMapper.addRoles(condition);
		}
	}

	@Override
	public List<OrganizationVO> listUser() throws Throwable {
		OrganizationVOExample example = new OrganizationVOExample();
		List<OrganizationVO> list=ormapper.selectByExample(example);
		System.out.println(list);
		return list;
	}
}
