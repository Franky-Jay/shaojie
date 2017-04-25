package com.mashen.organization.dao;

import com.mashen.organization.domain.OrganizationVO;
import com.mashen.organization.domain.OrganizationVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationVOMapper {
    int countByExample(OrganizationVOExample example);

    int deleteByExample(OrganizationVOExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(OrganizationVO record);

    int insertSelective(OrganizationVO record);

    List<OrganizationVO> selectByExample(OrganizationVOExample example);

    OrganizationVO selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") OrganizationVO record, @Param("example") OrganizationVOExample example);

    int updateByExample(@Param("record") OrganizationVO record, @Param("example") OrganizationVOExample example);

    int updateByPrimaryKeySelective(OrganizationVO record);

    int updateByPrimaryKey(OrganizationVO record);
}