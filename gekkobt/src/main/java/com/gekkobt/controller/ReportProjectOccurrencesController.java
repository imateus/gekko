package com.gekkobt.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.bean.ProjectBean;
import com.gekkobt.service.ProjectService;
import com.gekkobt.service.ReportProjectOccurrencesService;
import com.gekkobt.service.UserService;
import com.gekkobt.util.ExceptionUtils;

@Controller
@RequestMapping("/projectOccurrences")
public class ReportProjectOccurrencesController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ReportProjectOccurrencesService reportProjectOccurrencesService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ProjectOccurrences(Model model, ProjectBean bean) {
		
		ProjectBean projectBean = new ProjectBean();
		
		
		model.addAttribute("user", userService.findAll());
		model.addAttribute("project", projectService.findAll());
		try {
			if (bean.getId()==null) {
				projectBean.setId(1L);//verificar qual projeto o usuario está associado para definir qual projeto ir mostrar na tela.
				model.addAttribute("reportsProject", reportProjectOccurrencesService.filterReportProject(projectBean));
			}else{
				projectBean.setId(bean.getId());
				model.addAttribute("reportsProject", reportProjectOccurrencesService.filterReportProject(projectBean));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "report/report-project-occurrences";
	}
	
	@RequestMapping(value = "/showTable", method = RequestMethod.GET)
	public String showTable(ModelMap model, ProjectBean bean) {
		
		ProjectBean projectBean = new ProjectBean();
		
		projectBean.setId(bean.getId());
		try {
			model.addAttribute("reportsProject", reportProjectOccurrencesService.filterReportProject(projectBean));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "ajaxPages/table-occurrence-project";

	}

}