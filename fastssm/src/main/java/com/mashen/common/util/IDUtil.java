package com.mashen.common.util;

import java.util.UUID;
import com.mashen.common.dao.CommonMapper;
import com.mashen.common.domain.Sequence;

public class IDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString();
	}
	
	public static Long sequence(){
		CommonMapper mapper=SpringUtil.getBean(CommonMapper.class);
		Sequence seq=new Sequence();
		mapper.getSequence(seq);
		return seq.getId();
	}

}
