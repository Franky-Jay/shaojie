package com.mashen.datarule.dao;

import com.mashen.datarule.domain.DataruleVO;
import com.mashen.datarule.domain.DataruleVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataruleVOMapper {
    int countByExample(DataruleVOExample example);

    int deleteByExample(DataruleVOExample example);

    int deleteByPrimaryKey(String ruleid);

    int insert(DataruleVO record);

    int insertSelective(DataruleVO record);

    List<DataruleVO> selectByExample(DataruleVOExample example);

    DataruleVO selectByPrimaryKey(String ruleid);

    int updateByExampleSelective(@Param("record") DataruleVO record, @Param("example") DataruleVOExample example);

    int updateByExample(@Param("record") DataruleVO record, @Param("example") DataruleVOExample example);

    int updateByPrimaryKeySelective(DataruleVO record);

    int updateByPrimaryKey(DataruleVO record);
}