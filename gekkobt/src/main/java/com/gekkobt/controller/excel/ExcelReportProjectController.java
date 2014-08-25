
package com.gekkobt.controller.excel;

import java.text.ParseException;
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

import com.gekkobt.bean.ProjectBean;
import com.gekkobt.bean.ReportProjectBean;
import com.gekkobt.service.ReportProjectOccurrencesService;
import com.gekkobt.view.ExcelReportProjectView;

@Controller
@RequestMapping("/projectOccurrences")
@SessionAttributes(value = "operations")
public class ExcelReportProjectController extends AbstractController {
	
	@Autowired
	private ExcelReportProjectView excelReportProjectView;
	
	@Autowired
	private ReportProjectOccurrencesService reportProjectOccurrencesService;
	
	@RequestMapping(value = "/excelReportProject", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, String id) throws Exception{
		
		ExcelReportProjectView view = new ExcelReportProjectView();
		
		ProjectBean projectBean = new ProjectBean();
		projectBean.setId(Long.parseLong(id));
	
		List<ReportProjectBean> operationList = null;
		try {
			operationList = reportProjectOccurrencesService.filterReportProject(projectBean);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ModelAndView(view, "operations", operationList);
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return null;
	}

}
