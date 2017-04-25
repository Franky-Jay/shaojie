package com.mashen.role.permission.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.mashen.common.util.IDUtil;
import com.mashen.datarule.domain.DataruleVO;
import com.mashen.datarule.service.DataruleService;
import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.permission.service.PermissionService;
import com.mashen.privilege.datarule.CustomRule;
import com.mashen.role.permission.domain.RolePermissionVO;
import com.mashen.role.permission.service.RolePermissionService;

@Controller
public class RolePermissionController {
	
	@Autowired
	private DataruleService dataruleService ;
	@Autowired
	private RolePermissionService service;
	@Autowired
	private PermissionService service1;
	
	/**
	 * 用户授权
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("toPermission")
	public String toRolePermission(String roleid, String[] rule ,String[] permissionId) throws Throwable{
		System.out.println(permissionId==null);
		System.out.println("permissionId------>" + permissionId);
		//更新操作-------每次先删除，然后再添加。
		dataruleService.deleteDataRule(roleid);
		service.deletePermission(roleid);
		if(rule!=null && permissionId != null){
			System.out.println(permissionId.length);
			CuttingRule(rule);
			Set<Entry<String, String>> set = map.entrySet();
			String id = "";
			String businessCode = "";
			
			for (int i = 0; i < permissionId.length; i++) {
				//sb.append(permissionId[i]);
				//System.out.println("permissionId:---> " + permissionId[i]);
				String str = permissionId[i];
				String[] s = str.split(",");
				System.out.println("s大小：" + s.length);
				
				DataruleVO dataruleVO = null;
				RolePermissionVO record = null;
				for (int j = 0; j < s.length; j++) {
					if(j == 0){
						id = s[j].replace("@", "");
						if(!id.equals("")){
							dataruleVO = new DataruleVO();
							String seqID = IDUtil.sequence()+"";
							dataruleVO.setRuleid(seqID);//设置自增id
							dataruleVO.setRoleId(roleid);//设置用户id
							
							//角色权限
							record = new RolePermissionVO();
							record.setRoleId(roleid);
							record.setRolePermissionId(seqID);
							dataruleVO.setPermissionId(id);
							record.setPermissionId(id);
							for (Entry<String, String> entry : set) {
								//System.out.println("key:" + entry.getKey() +",value:" + entry.getValue());
								if(id.equals(entry.getKey())){
									if(entry.getValue().equals("currid")){
										CustomRule r = new CustomRule();
										r.setType("currid");
										r.setValue(roleid);
										dataruleVO.setRule(JSONObject.toJSON(r).toString());
									}else{
										dataruleVO.setRule(entry.getValue());
									}
									
								}
							}
							
						}else{
							break;
						}
						//System.out.println("切割后：---->" + s[j].replace("@", ""));
					}else{
						businessCode = s[j].replace("@", "");
						if(s[j].equals("@")){
							System.out.println("");
							businessCode = "";
						}
						dataruleVO.setBusinessCode(businessCode);
					}	
				}
				//插入数据规则
				// TODO 为测试。。。。
				if(dataruleVO != null && record != null){
					System.out.println(dataruleVO);
					System.out.println(record);
					dataruleService.addDataRule(dataruleVO);
					service.addPermission(record);
				}	
				System.out.println("\n----------\n");
				
			}
			for (Entry<String, String> entry : set) {
				System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
			}
		}	
		return "role/list";
	}
	
	
	
	
	/**
	 * 跳转到授权页面
	 * @return
	 */
	@RequestMapping("/view")
	public ModelAndView view(HttpSession session,String id){
			
		System.out.println("**********************");
		ModelAndView modelAndView = new ModelAndView("permission/authorised");
		
		Set<PermissionVOExt> permissonVOExtSet = service1.getAllPermissonVOExt();
		for (PermissionVOExt permissionVOExt : permissonVOExtSet) {
			System.out.println(permissionVOExt.getSubPermissionVO());
			System.out.println(permissionVOExt.getSubPermissionVO().size());
		}
		modelAndView.addObject("set", permissonVOExtSet);
		modelAndView.addObject("size",service1.getSize()+1);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	Map<String,String> map = new HashMap<String,String>();
	//切割规则
	public void CuttingRule(String[] rule){
		for (int i = 0; i < rule.length; i++) {
			
			String str = rule[i];
			if(str != null && !str.equals("")){
				String[] s = str.split(",");
				for (int j = 0; j < s.length; j++) {
					if(s[1].equals("@")){
						map.put(s[0], "");
					}else{
						map.put(s[0], s[1]);
					}
					
				}
			}

		}
	}
	
	
	
	/**
	 * 返回数据规则的json字符串
	 * @param roleid
	 * @return
	 */
	@RequestMapping("/toDatarule")
	public @ResponseBody List<DataruleVO> toJsonFromDatarule(String roleid){
		return dataruleService.list(roleid);
	}
	
	
	@RequestMapping("/toRolePermission")
	public @ResponseBody List<RolePermissionVO> toJsonFromRolePermissionVO(String roleid) throws Throwable{
		return service.getRolePermissionVOList(roleid);
	}
	
}
