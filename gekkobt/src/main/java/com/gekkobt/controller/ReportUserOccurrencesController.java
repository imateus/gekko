package com.gekkobt.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gekkobt.bean.ReportUserBean;
import com.gekkobt.service.ProjectService;
import com.gekkobt.service.ReportUserOccurrencesService;
import com.gekkobt.service.UserService;

@Controller
@RequestMapping("/userOccurrences")
public class ReportUserOccurrencesController {

	@Autowired
	private UserService userService;

	@Autowired
	private ReportUserOccurrencesService reportUserOccurrencesService;

	@Autowired
	private ProjectService projectService;
	
	List<ReportUserBean> listAllReport = new ArrayList<ReportUserBean>();
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ProjectOccurrences(Model model, ReportUserBean bean, HttpServletRequest req)
			throws NumberFormatException, Exception {
		
		model.addAttribute("user", userService.findAll());
		model.addAttribute("project", projectService.findAll());

		if (bean.getResponsibleId() == null) {
			try {
				listAllReport = reportUserOccurrencesService.filterReportUser();
				model.addAttribute("reports", listAllReport);
				req.getSession().setAttribute("reports", null);
				req.getSession().setAttribute("reports", listAllReport);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {

			List<ReportUserBean> listReport = reportUserOccurrencesService.filterReport(bean.getResponsibleId().intValue(),
							listAllReport);
			model.addAttribute("reports", listReport);
			req.getSession().setAttribute("reports", null);
			req.getSession().setAttribute("reports", listAllReport);
		}

		return "report/report-user-occurrences";
	}

	@RequestMapping(value = "/showTableUser", method = RequestMethod.GET)
	public String showTable(ModelMap model, ReportUserBean bean, HttpServletRequest req) {
		
	
		if (bean.getResponsibleId() == null) {
			try {
				model.addAttribute("reports",reportUserOccurrencesService.filterReportUser());
				listAllReport = reportUserOccurrencesService.filterReportUser();
				req.getSession().setAttribute("reports", null);
				req.getSession().setAttribute("reports", listAllReport);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {

			List<ReportUserBean> listReport = reportUserOccurrencesService.filterReport(bean.getResponsibleId().intValue(),
							listAllReport);
			model.addAttribute("reports", listReport);
			req.getSession().setAttribute("reports", null);
			req.getSession().setAttribute("reports", listAllReport);
		}
	
		return "ajaxPages/table-occurrence-users";
	}

}