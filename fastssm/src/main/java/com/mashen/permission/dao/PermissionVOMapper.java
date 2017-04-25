package com.mashen.permission.dao;

import com.mashen.permission.domain.PermissionVO;
import com.mashen.permission.domain.PermissionVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionVOMapper {
    int countByExample(PermissionVOExample example);

    int deleteByExample(PermissionVOExample example);

    int deleteByPrimaryKey(String permissionId);

    int insert(PermissionVO record);

    int insertSelective(PermissionVO record);

    List<PermissionVO> selectByExample(PermissionVOExample example);

    PermissionVO selectByPrimaryKey(String permissionId);

    int updateByExampleSelective(@Param("record") PermissionVO record, @Param("example") PermissionVOExample example);

    int updateByExample(@Param("record") PermissionVO record, @Param("example") PermissionVOExample example);

    int updateByPrimaryKeySelective(PermissionVO record);

    int updateByPrimaryKey(PermissionVO record);
}