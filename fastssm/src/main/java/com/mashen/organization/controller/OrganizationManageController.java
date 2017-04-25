package com.mashen.organization.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.common.dao.CommonMapper;
import com.mashen.common.domain.JsonResult;
import com.mashen.common.domain.Sequence;
import com.mashen.common.util.IDUtil;
import com.mashen.datatables.domain.DataTablesRequest;
import com.mashen.datatables.domain.DataTablesResponse;
import com.mashen.organization.domain.OrganizationVO;
import com.mashen.organization.service.OrganizationService;
import com.mashen.organization.service.OrganizationServiceImp;
import com.mashen.privilege.aop.annotation.FunctionPrivilege;
import com.mashen.user.domain.UserVO;

@Controller
@RequestMapping("/organization")
public class OrganizationManageController {
	@Autowired
	private OrganizationService service;
	
	@Autowired
	private OrganizationServiceImp serviceImp;
	@Autowired
	private CommonMapper commonMapper;
	
	/**
	 * 跳转到列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpSession session,HttpServletRequest request){
		System.out.println("uri:"+request.getRequestURI());
		return "organization/list";
	}
	/**
	 * 分页查接口
	 * @param pageVo
	 * @param userVo
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/rest/doSearch")
	@FunctionPrivilege
	public @ResponseBody DataTablesResponse<OrganizationVO> pageSearch(
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
		ModelAndView model=new ModelAndView("organization/edit");
		List<OrganizationVO> list = service.getByPId(id);
		if(list.size() > 0){
			model.addObject("list", list);
		}else{
			model.addObject("list", null);
		}
		//model.addObject("list", list);
		if(id!=null){//修改
			model.addObject("organization",service.get(id));
		}
		System.out.println(list);
		return model;
	}
	
	/**
	 * 保存编辑
	 * @param user
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping("/doEdit")
	//@FunctionPrivilege
	public ModelAndView doAdd(OrganizationVO organization) throws Throwable{
		ModelAndView model=new ModelAndView("organization/list");
		System.out.println("pid:"+organization.getPid());
		
		if(organization.getDepartmentId()!=null&&service.get(organization.getDepartmentId())!=null){//修改
			service.update(organization);
		}else{//新增
			if(organization.getPid()!=null){
				String pid = organization.getPid();
				String sequence = String.valueOf(IDUtil.sequence());
				organization.setDepartmentId(pid+sequence);
				service.add(organization);
			}else{
				organization.setPid("0");
				
				String sequence = String.valueOf(IDUtil.sequence());
				organization.setDepartmentId(sequence);
				service.add(organization);
			}
			
		}
		return model;
	}
	
	@RequestMapping("/doDel")
	public @ResponseBody JsonResult doDel(String id) throws Throwable{
		JsonResult rs=new JsonResult();
		service.delete(id);
		rs.setStatus(1);
		rs.setMsg("删除成功！");
		return rs;
	}
	
	
	

}
