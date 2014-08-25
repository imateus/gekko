package com.gekkobt.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gekkobt.bean.ProjectBean;
import com.gekkobt.service.ProjectService;
import com.gekkobt.service.ReportProjectOccurrencesService;
import com.gekkobt.service.UserService;

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
	public String ProjectOccurrences(Model model, ProjectBean bean) throws Exception {
		
		ProjectBean projectBean = new ProjectBean();
		
		
		model.addAttribute("user", userService.findAll());
		model.addAttribute("project", projectService.findAll());
		try {
			if (bean.getId()==null) {
				projectBean.setId(1L);//verificar qual projeto o usuário está associado para definir qual projeto irá mostrar na tela.
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
	public String showTable(ModelMap model, ProjectBean bean) throws Exception {
		
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