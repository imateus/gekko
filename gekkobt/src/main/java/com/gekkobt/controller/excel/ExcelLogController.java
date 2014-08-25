
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
import com.gekkobt.service.LogService;
import com.gekkobt.view.ExcelLogView;

@Controller
@RequestMapping("/log")
@SessionAttributes(value = "operations")
@SuppressWarnings("unchecked")
public class ExcelLogController extends AbstractController {
	
	@Autowired
	private ExcelLogView excelLogView;
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value = "/excelOccurrences", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, String id, String initialDate, String endDate){
		
		ExcelLogView view = new ExcelLogView();
		
		logService.filterLog(initialDate, endDate, id);
		
		List<OccurrenceBean> operationList = (List<OccurrenceBean>) request.getSession(true).getAttribute("occurrence");
		return new ModelAndView(view, "operations", operationList);
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return null;
	}

}
