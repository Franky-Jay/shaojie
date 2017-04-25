package com.mashen.role.dao;

import com.mashen.role.domain.RoleVO;
import com.mashen.role.domain.RoleVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleVOMapper {
    int countByExample(RoleVOExample example);

    int deleteByExample(RoleVOExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    List<RoleVO> selectByExample(RoleVOExample example);

    RoleVO selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByExample(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);
}