package com.mashen.common.exception;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		ResponseBody body = handlerMethod
				.getMethodAnnotation(ResponseBody.class);
		// 判断有没有@ResponseBody的注解没有的话直接重定向到页面
		if (body == null) {
			 Map<String, Object> model = new HashMap<String, Object>();  
		        model.put("exception", ex);
			return  new ModelAndView("/error/exception", model); 
		}
		ModelAndView mv = new ModelAndView();
		// 设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示 //并且不会有任何反应
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		// 设置ContentType
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		// 避免乱码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		try {
			PrintWriter writer = response.getWriter();
			/*Map<String,String> resutlMap=new HashMap<String,String>();
			resutlMap.put("status","0");
			resutlMap.put("msg",ex.getMessage());
			writer.write(JSONObject.toJSONString(resutlMap));*/
			writer.write(ex.getMessage());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mv;
	}

}