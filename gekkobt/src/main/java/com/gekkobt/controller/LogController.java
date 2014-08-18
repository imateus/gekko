package com.gekkobt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/log")
public class LogController {


	@RequestMapping("")
	public String ProjectOccurrences() {
		return "log/log";
	}
}