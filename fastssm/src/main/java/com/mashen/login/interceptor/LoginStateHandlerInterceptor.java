package com.mashen.login.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录状态检测拦截器
 * @author liushd
 *
 */
public class LoginStateHandlerInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<String> allowUris;
	public void setAllowUris(List<String> allowUris) {
		this.allowUris = allowUris;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("LoginStateHandlerInterceptor preHandle");
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpRes=(HttpServletResponse)response;
		if(httpReq.getSession().getAttribute("s_user")!=null){//已经登录
			logger.debug("已经登录");
			return true;
		}else{//没有登录
			String uri=httpReq.getRequestURI();
			if(isAllowURI(uri)){//本身登录模块不需要 拦截
				return true;
			}else{
				httpRes.sendRedirect(httpReq.getContextPath()+"/login.action");
				return false;
			}
			
		}
	}
	
	/**
	 * 判断是否不需要拦截的URI
	 * @param uri
	 * @return
	 */
	private boolean isAllowURI(String uri){
		if(allowUris!=null){
			for(String str : allowUris){
				if(uri.indexOf(str)>-1){
					return true;
				}
			}
		}
		return false;
	}
	

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}


}
