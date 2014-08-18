package com.gekkobt.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.functions.Functions;
import org.springframework.ui.ModelMap;




public interface ControllerInterface {
	
	public String index(ModelMap modelMap, HttpServletRequest req);
	public Functions getFunction();
}
