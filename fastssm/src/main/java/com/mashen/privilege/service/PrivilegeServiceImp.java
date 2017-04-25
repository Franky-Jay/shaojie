package com.mashen.privilege.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.privilege.dao.PrivilegeExtMapper;

@Service
public class PrivilegeServiceImp implements PrivilegeService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PrivilegeExtMapper mapper;

	@Override
	public List<String> listUserRoles(String userid) {
		return mapper.listRoleByUserId(userid);
	}

	@Override
	public Set<PermissionVOExt> listUserMenuPermissions(List<String> roleList) {
		Set<PermissionVOExt> allMenu= new LinkedHashSet<>();//所有功能菜单，保持插入顺序
		for(String roleid : roleList){//查询所有功能菜单
			allMenu.addAll(mapper.listMenuPermissionByRoleId(roleid));
		}
		//TODO 清理测试代码
		logger.debug("所有菜单权限:");
		for(PermissionVOExt pms : allMenu){
			logger.debug(pms.getUri()+":"+pms.getClasspath());
		}
		return allMenu;
	}
	
	@Override
	public Set<PermissionVOExt> listUserButtonPermissions(List<String> roleList){
		Set<PermissionVOExt> allButton= new LinkedHashSet<>();//所有功能菜单，保持插入顺序
		for(String roleid : roleList){//查询所有功能菜单
			allButton.addAll(mapper.listButtonPermissionByRoleId(roleid));
		}
		//TODO 清理测试代码
		logger.debug("所有按钮权限:");
		for(PermissionVOExt pms : allButton){
			logger.debug(pms.getUri()+":"+pms.getClasspath());
		}
		return allButton;
	}
	
	@Override
	public Set<PermissionVOExt> listUserMenuTreePermissions(Set<PermissionVOExt> allMenu) {
		//设置菜单层级
		Set<PermissionVOExt> firstMenu=listSubPermissions(allMenu,"0");//第一级菜单，父ID为0
		for(PermissionVOExt menu : firstMenu){//二级菜单
			menu.setSubPermissionVO(listSubPermissions(allMenu,menu.getPermissionId()));
		}
		return firstMenu;
		
	}
	
	//通过pid获取子菜单
	private Set<PermissionVOExt> listSubPermissions(
			Set<PermissionVOExt> allPermission, String pid) {
		Set<PermissionVOExt> subPermissiones = new LinkedHashSet<>();
		for (PermissionVOExt permission : allPermission) {
			if (pid.equals(permission.getPid())) {
				subPermissiones.add(permission);
			}
		}
		return subPermissiones;
	}

}
