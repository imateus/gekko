
package com.gekkobt.controller.excel;

import java.text.ParseException;
import java.util.ArrayList;
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

import com.gekkobt.bean.ReportUserBean;
import com.gekkobt.service.ReportUserOccurrencesService;
import com.gekkobt.view.ExcelReportUserView;

@Controller
@RequestMapping("/userOccurrences")
@SessionAttributes(value = "operations")
@SuppressWarnings("unchecked")
public class ExcelReportUserController extends AbstractController {
	
	@Autowired
	private ExcelReportUserView excelReportUserView;
	
	@Autowired
	private ReportUserOccurrencesService reportUserOccurrencesService;
	
	@RequestMapping(value = "/excelUserOccurrences", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, String id){
		
		List<ReportUserBean> listAllReport = new ArrayList<ReportUserBean>();
		try {
			listAllReport = reportUserOccurrencesService.filterReportUser();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (!id.equals("")) {
	
			listAllReport = reportUserOccurrencesService.filterReport(Integer.parseInt(id),
						listAllReport);
		}
		
		ExcelReportUserView view = new ExcelReportUserView();
		
		return new ModelAndView(view, "operations", listAllReport);
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return null;
	}

}
