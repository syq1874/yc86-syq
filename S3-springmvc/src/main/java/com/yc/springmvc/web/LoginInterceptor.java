package com.yc.springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginedUser") == null) {
			String accept=request.getHeader("Accept");
			if(accept.startsWith("application/json")) {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().append("{code:0,mag:'请先登录系统'}");
			}else {
				response.setContentType("text/html;charset=utf-8");
				response.sendRedirect("/login.html");
			}
			return false;
		}
		return true;
	}

}
