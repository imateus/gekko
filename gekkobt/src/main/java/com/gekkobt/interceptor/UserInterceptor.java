package com.gekkobt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gekkobt.bean.UserBean;
import com.gekkobt.controller.LoginController;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private LoginController loginController;

	@Autowired
	private UserBean user;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = request.getRequestURI();
		
		if (!path.matches("/gekkobt/")
				&& !path.matches("/gekkobt/login")
				&& !path.matches("/gekkobt/login/userMake")
				&& !path.matches("/gekkobt/login/email")
				&& !path.matches("/gekkobt/login/logout")
				&& !path.matches("[/gekkobt/](.*)[.].*")) {
				
				HandlerMethod handlerMethod = null;

			if (handler instanceof HandlerMethod) {
				handlerMethod = ((HandlerMethod) handler);
			}
			if (user.getId() == null) {
				response.sendRedirect("/gekkobt/login");
				return false;
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2, ModelAndView modelMap)
			throws Exception {
	}
}