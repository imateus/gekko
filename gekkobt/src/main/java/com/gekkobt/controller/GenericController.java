package com.gekkobt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.functions.Functions;
import org.springframework.context.ApplicationContext;

import com.gekkobt.bean.UserBean;
import com.gekkobt.util.SpringContextHolder;

abstract class GenericController {
	
	protected Functions function;

	public Functions getFunction() {
		return function;
	}

	public UserBean getUser() {
		ApplicationContext context = SpringContextHolder
				.getApplicationContext();
		return (UserBean) context.getBean("user");
	}

	public String getUserIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		
		return ipAddress;
	}

	public void setAjaxOk(HttpServletResponse resp) {
		try {
			resp.getOutputStream().print("200");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
