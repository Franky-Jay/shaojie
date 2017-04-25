package com.mashen.role.permission.dao;

import com.mashen.role.permission.domain.RolePermissionVO;
import com.mashen.role.permission.domain.RolePermissionVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionVOMapper {
    int countByExample(RolePermissionVOExample example);

    int deleteByExample(RolePermissionVOExample example);

    int deleteByPrimaryKey(String rolePermissionId);

    int insert(RolePermissionVO record);

    int insertSelective(RolePermissionVO record);

    List<RolePermissionVO> selectByExample(RolePermissionVOExample example);

    RolePermissionVO selectByPrimaryKey(String rolePermissionId);

    int updateByExampleSelective(@Param("record") RolePermissionVO record, @Param("example") RolePermissionVOExample example);

    int updateByExample(@Param("record") RolePermissionVO record, @Param("example") RolePermissionVOExample example);

    int updateByPrimaryKeySelective(RolePermissionVO record);

    int updateByPrimaryKey(RolePermissionVO record);
}