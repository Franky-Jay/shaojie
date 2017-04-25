package com.mashen.demo1.dao;

import com.mashen.demo1.domain.DemoVO;
import com.mashen.demo1.domain.DemoVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoVOMapper {
    int countByExample(DemoVOExample example);

    int deleteByExample(DemoVOExample example);

    int deleteByPrimaryKey(Integer testid);

    int insert(DemoVO record);

    int insertSelective(DemoVO record);

    List<DemoVO> selectByExample(DemoVOExample example);

    DemoVO selectByPrimaryKey(Integer testid);

    int updateByExampleSelective(@Param("record") DemoVO record, @Param("example") DemoVOExample example);

    int updateByExample(@Param("record") DemoVO record, @Param("example") DemoVOExample example);

    int updateByPrimaryKeySelective(DemoVO record);

    int updateByPrimaryKey(DemoVO record);
}