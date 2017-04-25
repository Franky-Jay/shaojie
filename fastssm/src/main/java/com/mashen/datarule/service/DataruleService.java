package com.mashen.datarule.service;

import java.util.List;
import java.util.Map;

import com.mashen.datarule.domain.DataruleVO;

public interface DataruleService {
	public Map<String,String> listDataRule(List<String> roles);
	
	public void addDataRule(DataruleVO datarule);
	public void deleteDataRule(String roleid);
	public List<DataruleVO> list(String roleid);
}
