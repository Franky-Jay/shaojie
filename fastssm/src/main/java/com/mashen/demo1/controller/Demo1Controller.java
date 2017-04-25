package com.mashen.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashen.common.domain.CurrentUser;
import com.mashen.common.domain.JsonResult;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.demo1.domain.DemoVO;
import com.mashen.demo1.service.Demo1Service;
import com.mashen.privilege.aop.annotation.FunctionPrivilege;

@Controller
@RequestMapping("/demo")
public class Demo1Controller {
	@Autowired
	private Demo1Service service;
	
	@RequestMapping("/edit")
	public String edit(Integer id,ModelMap map){
		if(id!=null){
			map.addAttribute("demoVo",service.get(id));
		}
		return "demo/edit";//跳转到编辑页面
	}
	
	@RequestMapping("/doEdit")
	public String doEdit(DemoVO demoVo){
		CurrentUser user=CurrentUser.getInstance();
		demoVo.setCreatorUserId(user.getUserId());
		demoVo.setCreatorDepartmentId(user.getDepartmentId());
		
		if(demoVo.getTestid()!=null){//修改
			service.update(demoVo);
		}else{//新增
			service.add(demoVo);
		}
		return "redirect:/demo/list.action";//跳转到列表页面
	}
	
	@RequestMapping("/rest/doDelete")
	public @ResponseBody JsonResult doDelete(Integer id){
		JsonResult rs=new JsonResult();
		service.delete(id);
		rs.setStatus(1);
		rs.setMsg("删除成功！");
		return rs;
	}
	
	@RequestMapping("/list")
	public String list(){
		return "demo/list";//跳转到分页查询页面
	}
	/**
	 * datatable分页查询接口
	 * @param request
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping("/rest/doSearch")
	@FunctionPrivilege
	public @ResponseBody DataTablesResponse<DemoVO> pageSearch(
			@RequestBody DataTablesRequest request) throws Throwable{
		return service.listByPage(request);
	}
}
