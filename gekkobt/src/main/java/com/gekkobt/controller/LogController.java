package com.gekkobt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gekkobt.service.UserService;


@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String ProjectOccurrences(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "log/log";
	}
}