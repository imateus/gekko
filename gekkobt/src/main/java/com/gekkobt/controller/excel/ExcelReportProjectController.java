
package com.gekkobt.controller.excel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.view.ExcelReportProjectView;

@Controller
@RequestMapping("/projectOccurrences")
@SessionAttributes(value = "operations")
@SuppressWarnings("unchecked")
public class ExcelReportProjectController extends AbstractController {
	
	@Autowired
	private ExcelReportProjectView excelReportProjectView;
	
	@Override
	@RequestMapping(value = "/excelReportProject", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		
		ExcelReportProjectView view = new ExcelReportProjectView();
		
		List<OccurrenceBean> operationList = (List<OccurrenceBean>) request.getSession(true).getAttribute("?");
		return new ModelAndView(view, "operations", operationList);
		
	}

}
