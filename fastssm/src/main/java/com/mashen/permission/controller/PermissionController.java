package com.mashen.permission.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.permission.domain.PermissionVO;
import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.permission.service.PermissionService;

@Controller
public class PermissionController {
	@Autowired
	private PermissionService service;
	
	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(HttpSession session){
		System.out.println("**********************");
//		if(session.getAttribute("user")!=null){//已经登录
//			
//		}else{//未登录
//			return "login";
//		}
		ModelAndView modelAndView = new ModelAndView("permission/add");
		Set<PermissionVOExt> permissonVOExtSet = service.getAllPermissonVOExt();
		modelAndView.addObject("set", permissonVOExtSet);
		return modelAndView;
	}
	
	@RequestMapping("/addPermission")
	public String addPermission(PermissionVO permission,String icon,ModelMap map) throws Throwable{
		System.out.println("------>"+permission);
		//permission.setPid("0");
		if(service.addPermission(permission) > 0){
			//map.addAttribute("msg", "添加成功!");
			map.addAttribute("permission", permission);
			return "redirect:add.action";
		}
		
		return "redirect:add.action";
	}
	
	
	
	@RequestMapping("/pidFirstlist")
	public @ResponseBody List<PermissionVO> getFirstPidJson(String id) throws Throwable{
		
		if(id != null && !id.equals("")){
			return service.getFirstPid(id);
		}else{
			return null;
		}
		
	}
	
	@RequestMapping("/getPermission")
	public @ResponseBody PermissionVO getPermissionToJson(String permissionId) throws Throwable{
		System.out.println(permissionId);
		if(permissionId != null && !permissionId.equals("")){
			System.out.println(service.getPermissionVO(permissionId));
			return service.getPermissionVO(permissionId);
		}else{
			return null;
		}
	}
	
	@RequestMapping("/delPermission")
	public @ResponseBody int delPermission(String permissionId) throws Throwable{
		System.out.println(permissionId);
		if(permissionId != null && !permissionId.equals("")){
			System.out.println(service.getPermissionVO(permissionId));
			return service.delPermissionVO(permissionId);
		}else{
			return 0;
		}
		
	}
	
	@RequestMapping("/upPermission")
	public String upPermission(PermissionVO permission) throws Throwable{
		if(service.updatePermission(permission) > 0){
			System.out.println("修改成功");
		}
		
		return "redirect:add.action";
	}
	
	

	
}
