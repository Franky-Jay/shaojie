package com.mashen.login.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashen.datarule.service.DataruleService;
import com.mashen.permission.domain.PermissionVOExt;
import com.mashen.privilege.service.PrivilegeService;
import com.mashen.user.domain.UserVO;
import com.mashen.user.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private DataruleService dataruleService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpSession session){
		if(session.getAttribute("user")!=null){//已经登录
			return "redirect:main.action";
		}else{//未登录
			return "login";
		}
		
	}
	
	/**
	 * 登录处理
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/doLogin")
	public String doLogin(HttpSession session,@RequestParam(required=true) String account,@RequestParam(required=true) String pwd,ModelMap map) throws Throwable{
		UserVO user=userService.checkLogin(account, pwd);
		if(user!=null){//登录成功
			//设置当前用户到session
			session.setAttribute("s_user",user);
			
			//设置当前用户的所有角色到session
			List<String> roles=privilegeService.listUserRoles(user.getUserId());
			session.setAttribute("s_roles",roles);
			
			//设置当前用户的功能权限到session
			Set<PermissionVOExt> functionPrivileges=privilegeService.listUserMenuPermissions(roles);
			session.setAttribute("s_functionPrivileges", functionPrivileges);
			
			//功能权限树
			Set<PermissionVOExt> functionPrivilegesTree=privilegeService.listUserMenuTreePermissions(functionPrivileges);
			session.setAttribute("s_functionPrivilegesTree", functionPrivilegesTree);
			
			//按钮权限
			Set<PermissionVOExt> buttonPrivileges=privilegeService.listUserButtonPermissions(roles);
			session.setAttribute("s_buttonPrivileges", buttonPrivileges);
			
			//设置当前用户的数据权限到session
			Map<String,String> dataPrivileges=dataruleService.listDataRule(roles);
		    session.setAttribute("s_dataPrivileges", dataPrivileges);
		    
		    //跳转到后台主页
		    return "redirect:main.action";
		    
		}else{//登录失败
			map.addAttribute("msg","账号或密码错误！");
			return "login";
		}
		
	}
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/loginout")
	public String loginout(HttpSession session){
		session.invalidate();
		return "redirect:login.action";
	}
	
}
