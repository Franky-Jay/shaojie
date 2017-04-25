package com.mashen.privilege.datarule;

/**
 * 固定数据规则
 * @author liushd
 *
 */
public class DataRules {
	/**
	 * 只能看本人创建的数据
	 */
	public static final String ONESELF="CreatorUserIdEqualTo";
	
	/**
	 * 只能看本部门创建的数据(不包括下级)
	 */
	public static final String DEPARTMENT="CreatorDepartmentIdEqualTo";
	
	/**
	 * 只能看本部门及下级创建的数据
	 */
	public static final String DEPARTMENT_AND_SUB="CreatorDepartmentIdLike";
	
	
}
