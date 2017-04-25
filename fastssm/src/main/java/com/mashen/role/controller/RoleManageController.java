package com.mashen.role.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.common.domain.JsonResult;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.privilege.aop.annotation.FunctionPrivilege;
import com.mashen.role.domain.RoleVO;
import com.mashen.role.service.RoleService;
import com.mashen.user.domain.UserVO;

@Controller
@RequestMapping("/role")
public class RoleManageController {
	@Autowired
	private RoleService service;
	
	@RequestMapping("/list")
	public String list(HttpSession session,HttpServletRequest request){
		System.out.println("uri:"+request.getRequestURI());
		return "role/list";
	}
	
	@RequestMapping("/rest/doSearch")
//	@FunctionPrivilege
	public @ResponseBody DataTablesResponse<RoleVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.list(request);
	}
	
	/**
	 * 跳转到编辑页面
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/edit")
	public ModelAndView add(String id) throws Throwable{
		System.out.println(id);
		ModelAndView model=new ModelAndView("role/edit");
		if(id!=null){//修改
			model.addObject("role",service.getRoleById(id));
		}
		return model;
	}
	
	/**
	 * 保存编辑
	 * @param user
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/doEdit")
//	@FunctionPrivilege
	public ModelAndView doAdd(RoleVO role) throws Throwable{
		ModelAndView model=new ModelAndView("role/list");
		
		if(role.getRoleId()!=null&&service.getRoleById(role.getRoleId())!=null){//修改
			service.updateRole(role);
		}else{//新增
			service.addRole(role);
		}
		return model;
	}
	
	@RequestMapping("/doDel")
	public @ResponseBody JsonResult doDel(String id) throws Throwable{
		JsonResult rs=new JsonResult();
		service.deleteRole(id);
		rs.setStatus(1);
		rs.setMsg("删除成功！");
		return rs;
	}
}
