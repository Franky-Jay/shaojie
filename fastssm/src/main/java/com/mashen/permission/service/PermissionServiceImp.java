package com.mashen.permission.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.common.util.IDUtil;
import com.mashen.permission.dao.PermissionExtVOMapper;
import com.mashen.permission.dao.PermissionVOMapper;
import com.mashen.permission.domain.PermissionVO;
import com.mashen.permission.domain.PermissionVOExample;
import com.mashen.permission.domain.PermissionVOExample.Criteria;
import com.mashen.permission.domain.PermissionVOExt;

@Service
public class PermissionServiceImp implements PermissionService {
	@Autowired
	private PermissionVOMapper mapper;
	
	@Autowired
	private PermissionExtVOMapper extMapper;
	@Override
	public Integer addPermission(PermissionVO permission) throws Throwable {
		
		permission.setPermissionId(permission.getPid()+IDUtil.sequence());
		//定级菜单默认开头为0
		System.out.println(permission);
		return mapper.insert(permission);

	}

	@Override
	public Integer deletePermission(String permissionId) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updatePermission(PermissionVO permission) throws Throwable {
		return mapper.updateByPrimaryKeySelective(permission);
		
	}

	@Override
	public List<PermissionVO> selectAll() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PermissionVO> getFirstPid(String id) throws Throwable {
		PermissionVOExample example = new PermissionVOExample();
		Criteria c = example.createCriteria();
		c.andPidEqualTo(id);
		return mapper.selectByExample(example);
	}

	@Override
	public PermissionVO getPermissionVO(String permissionId) throws Throwable{
		return mapper.selectByPrimaryKey(permissionId);
	}

	@Override
	public int delPermissionVO(String permissionId) throws Throwable {
		//删除父节点时如果有子节点，则删除所有的子节点
		PermissionVOExample example = new PermissionVOExample();
		Criteria c = example.createCriteria();
		/*c.andPidEqualTo(permissionId);*/
		c.andPermissionIdLike(permissionId + "%");
		mapper.deleteByExample(example);
		return mapper.deleteByPrimaryKey(permissionId);
	}
	
	@Override
	public Set<PermissionVOExt> getPermissionByPid(String id) {
		return extMapper.getPerExtsByPid(id);
	}

	private int size = 0;
	@Override
	public Set<PermissionVOExt> getAllPermissonVOExt() {
		Set<PermissionVOExt> first = getPermissionByPid("0");//查出出第一层
		for(PermissionVOExt firstLevel : first){
			Set<PermissionVOExt> second = getPermissionByPid(firstLevel.getPermissionId());//查出第二层
			System.out.println(second);
			size = second.size();
			//size = ;
			for(PermissionVOExt secondLevel : second){
				Set<PermissionVOExt> third = getPermissionByPid(secondLevel.getPermissionId());//查出第三层
				secondLevel.setSubPermissionVO(third);
			}
			firstLevel.setSubPermissionVO(second);
		}
		return first;
	}

	@Override
	public int getSize() {
//		Set<PermissionVOExt> first = getPermissionByPid("0");//查出出第一层
//		Set<PermissionVOExt> second = null;
//		for(PermissionVOExt firstLevel : first){
//			second = getPermissionByPid(firstLevel.getPermissionId());//查出第二层
//		}
		return size;
	}

	
	
}
