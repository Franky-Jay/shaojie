package com.mashen.permission.dao;

import java.util.Set;

import com.mashen.permission.domain.PermissionVOExt;

public interface PermissionExtVOMapper {
	
	public Set<PermissionVOExt> getPerExtsByPid(String pid);
}
