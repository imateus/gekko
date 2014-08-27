
package com.gekkobt.controller.excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gekkobt.service.LogService;
import com.gekkobt.view.ExcelLogView;

@Controller
@RequestMapping("/log")
@SessionAttributes(value = "operations")

public class ExcelLogController extends AbstractController {
	
	@Autowired
	private ExcelLogView excelLogView;
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value = "/excelOccurrences", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, String id, String initialDate, String endDate){
		
		ExcelLogView view = new ExcelLogView();
		
		return new ModelAndView(view, "operations", logService.filterLog(initialDate, endDate, id));
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return null;
	}

}
