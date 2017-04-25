package com.mashen.user.domain;

import java.util.ArrayList;
import java.util.List;

import com.mashen.role.domain.RoleVO;


public class UserVOExt extends UserVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<RoleVO> roles = new ArrayList<>();

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

}
