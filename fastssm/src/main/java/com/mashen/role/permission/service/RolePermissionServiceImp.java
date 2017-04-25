package com.mashen.role.permission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.permission.domain.PermissionVO;
import com.mashen.role.permission.dao.RolePermissionVOMapper;
import com.mashen.role.permission.domain.RolePermissionVO;
import com.mashen.role.permission.domain.RolePermissionVOExample;
import com.mashen.role.permission.domain.RolePermissionVOExample.Criteria;

@Service
public class RolePermissionServiceImp implements RolePermissionService {
	
	@Autowired
	private RolePermissionVOMapper mapper;
	
	@Override
	public int addPermission(RolePermissionVO record) throws Throwable {
		mapper.insert(record);
		return 0;
	}

	@Override
	public int updatePermission(String roleid, PermissionVO permissionVO) throws Throwable {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermission(String roleid) throws Throwable {
		RolePermissionVOExample example = new RolePermissionVOExample();
		Criteria c = example.createCriteria();
		c.andRoleIdEqualTo(roleid);
		mapper.deleteByExample(example);
		
	}

	@Override
	public List<RolePermissionVO> getRolePermissionVOList(String roleid) throws Throwable {
		RolePermissionVOExample example = new RolePermissionVOExample();
		Criteria c = example.createCriteria();
		c.andRoleIdEqualTo(roleid);
		return mapper.selectByExample(example);
		
	}

}
