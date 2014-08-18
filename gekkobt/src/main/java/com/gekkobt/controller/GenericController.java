package com.gekkobt.controller;

import org.springframework.context.ApplicationContext;

import com.gekkobt.bean.UserBean;
import com.gekkobt.util.SpringContextHolder;

abstract class GenericController {

	public UserBean getUser() {
		ApplicationContext context = SpringContextHolder
				.getApplicationContext();
		return (UserBean) context.getBean("user");
	}
}