package com.gekkobt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gekkobt.bean.AnnexBean;
import com.gekkobt.bean.HistoricStatusBean;
import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.bean.ProjectBean;
import com.gekkobt.bean.UserBean;
import com.gekkobt.service.AnnexService;
import com.gekkobt.service.HistoricStatusService;
import com.gekkobt.service.OccurrenceService;
import com.gekkobt.service.PriorityService;
import com.gekkobt.service.ProjectService;
import com.gekkobt.service.StatusService;
import com.gekkobt.service.TypeOccurrenceService;
import com.gekkobt.service.UserService;
import com.gekkobt.util.ExceptionUtils;
import com.gekkobt.util.JSONParser;

@Controller
@RequestMapping("/occurrence")
public class OccurrenceController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TypeOccurrenceService typeOccurrenceService;

	@Autowired
	private PriorityService priorityService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private OccurrenceService occurrenceService;

	@Autowired
	private UserService userService;

	@Autowired
	private HistoricStatusService historicStatusService;

	@Autowired
	private AnnexService annexService;
	
	private static final int BUFFER_SIZE = 4096;
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String retornaListaOcorrencia(Model model, HttpServletRequest req,
			HttpServletResponse resp) {
		UserBean userBean = (UserBean) req.getSession().getAttribute(
				"userLogged");
		Object UserFind = userService.findAll();
		OccurrenceFilterBean bean = new OccurrenceFilterBean();
		Integer num = null;
		List<OccurrenceBean> list = getOccurrences(bean, 1, userBean.getId());
		double quantityOccurrence = (int) getNumberOccurrences(bean,
				userBean.getId());

		int numberPage = (int) Math.ceil(quantityOccurrence / 20);

		if (list.size() > 0) {
			model.addAttribute("occurrence", list);
			/*model.addAttribute("excelOccurrence", excel);*/
			model.addAttribute("qtdOccurrenceOnPage", list.size());
			model.addAttribute("firtsOccurrenceOnPage", (1 * 20 + 1) - 20);
		} else {
			model.addAttribute("occurrenceNotFoud",
					"Nenhuma ocorrência encontrada.");
		}

		model.addAttribute("numberOfOcurrences", numberPage);
		model.addAttribute("countOcurrences", (int) quantityOccurrence);
		req.getParameter("inclusionDateParamTo");
		model.addAttribute("project", projectService.findAll());
		model.addAttribute("typeOccurrence", typeOccurrenceService.findAll());
		model.addAttribute("status", statusService.findAll());
		model.addAttribute("occurrenceUserInclusion", UserFind);
		model.addAttribute("occurrenceUserResponsible", UserFind);
		

		model.addAttribute("searchId", bean.getIdOccurrence());
		
		req.getSession().setAttribute("occurrence", list);
		/*req.getSession().setAttribute("excelOccurrence", null);*/
		/*req.getSession().setAttribute("excelOccurrence", excel);*/
		req.getSession().setAttribute("qtdOccurrenceOnPage", list.size());
		req.getSession().setAttribute("firtsOccurrenceOnPage",
				(numberPage * 20 + 1) - 20);
		req.getSession().setAttribute("numberOfOcurrences", numberPage);
		req.getSession().setAttribute("countOcurrences",
				(int) quantityOccurrence);
		return "occurrence/list-occurrence";
	}

	@RequestMapping(value = "/{pagination}", method = RequestMethod.POST)
	public String getOccurrence(ModelMap model, ModelAndView mav,
			HttpServletRequest req, HttpServletResponse resp,
			@ModelAttribute("filter-occurrence") OccurrenceFilterBean bean,
			@PathVariable Integer pagination) {
		
		
		List<OccurrenceBean> list = getOccurrences(bean, pagination,
				bean.getIdResponsableOccurrence());
		
		
		
		double quantityOccurrence = (int) getNumberOccurrences(bean,
				bean.getIdResponsableOccurrence());

		int numberPage = (int) Math.ceil(quantityOccurrence / 20);

		if (list.size() > 0) {
			model.addAttribute("occurrence", list);
			/*model.addAttribute("exceloccurrence", excel);*/
			model.addAttribute("numberOfOcurrences", numberPage);
			model.addAttribute("countOcurrences", (int) quantityOccurrence);
			model.addAttribute("qtdOccurrenceOnPage", list.size());
			model.addAttribute("firtsOccurrenceOnPage", (pagination * 20) - 19);
			
			req.getSession().setAttribute("qtdOccurrenceOnPage", list.size());
			req.getSession().setAttribute("firtsOccurrenceOnPage",
					(pagination * 20) - 19);

			req.getSession().setAttribute("occurrence", list);
			/*req.getSession().setAttribute("exceloccurrence", null);
			req.getSession().setAttribute("exceloccurrence",excel );*/
			req.getSession().setAttribute("numberOfOcurrences", numberPage);
			req.getSession().setAttribute("countOcurrences",
					(int) quantityOccurrence);
			return "ajaxPages/table-occurrence";
		} else {
			new ExceptionUtils().printBusinessError(resp, new Exception(
					new String("Nenhuma ocorrência encontrada.")));

		}
		return null;

	}

	@RequestMapping(value = "/pagination", method = RequestMethod.GET)
	public String getOccurrence(ModelMap model, HttpServletRequest req) {

		model.addAttribute("numberOfOcurrences",
				req.getSession().getAttribute("numberOfOcurrences"));
		model.addAttribute("countOcurrences",
				req.getSession().getAttribute("countOcurrences"));
		model.addAttribute("qtdOccurrenceOnPage", req.getSession()
				.getAttribute("qtdOccurrenceOnPage"));
		model.addAttribute("firtsOccurrenceOnPage", req.getSession()
				.getAttribute("firtsOccurrenceOnPage"));

		
		req.getSession().setAttribute("qtdOccurrenceOnPage", null);
		req.getSession().setAttribute("firtsOccurrenceOnPage", null);
		req.getSession().setAttribute("countOcurrences", null);
		req.getSession().setAttribute("numberOfOcurrences", null);

		return "ajaxPages/pagination-occurrence";
	}

	public double getNumberOccurrences(OccurrenceFilterBean bean, Long IdUser) {
		Long numberOfOcurrences = null;
		numberOfOcurrences = occurrenceService.sizeOfList(bean, IdUser);

		return numberOfOcurrences;

	}

	public List<OccurrenceBean> getOccurrences(OccurrenceFilterBean bean,
			Integer pagination, Long IdUser) {

		List<OccurrenceBean> list = null;

		try {
			list = occurrenceService
					.filterOccurrences(bean, pagination, IdUser);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@RequestMapping(value = "/listForExcel", method = RequestMethod.GET)
	public void listForExcel(ModelMap model, HttpServletRequest req,OccurrenceFilterBean bean) {
		Integer num = null;
		
		List<OccurrenceBean> excel = getOccurrences(bean, num,bean.getIdResponsableOccurrence());
		req.getSession().setAttribute("excelOccurrence", null);
		req.getSession().setAttribute("excelOccurrence", excel);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/maintenance", method = RequestMethod.GET)
	public String maintenance(HttpServletResponse resp, String id,
			ModelMap model, AnnexBean annexBean, String hdnIdOcurrence) {
		
		Integer occurenceDeleted=null;
		model.addAttribute("listProjects", projectService.findAll());
		model.addAttribute("typesOccurrences", typeOccurrenceService.findAll());
		model.addAttribute("typesPriority", priorityService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("status", statusService.findAll());
		
		
		OccurrenceBean occurrenceBean = new OccurrenceBean();
		occurrenceBean.setId(annexBean.getId());

		annexBean.setOccurrenceBean(occurrenceBean);
		List<AnnexBean> list = null;
		try {
			list = annexService.filterAnnex(annexBean);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		if (list == null) {
			model.addAttribute("annex", annexService.findAll());
		} else {
			model.addAttribute("annex", list);
		}

		try {
			OccurrenceBean bean = new OccurrenceBean();
			
			if (id != null) {
				bean = occurrenceService.findOccurrenceId(Long
						.parseLong(id));
				
				occurenceDeleted = bean.getOccurrenceDeleted();
				if (bean == null) {
					model.addAttribute("update", false);
				}
			}
			else {
				bean.setProjectBean(new ProjectBean());
			}
				
			
			model.addAttribute("occurrence", bean);
			/*model.addAttribute("excelOccurrence", bean);*/
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getOutputStream().print(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (occurenceDeleted != null && occurenceDeleted == 0) {
			return "redirect:../occurrence";
		} else {

			return "occurrence/maintenance-occurrence";
		}
	}

	
	@RequestMapping(value = "download/{idAnnex}", method = RequestMethod.GET)
	public void download(HttpSession request,
			HttpServletResponse response, @PathVariable Long idAnnex) throws IOException {
		AnnexBean bean = new AnnexBean();
		try {
			bean = occurrenceService.findAnnexId(idAnnex);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ServletContext context = request.getServletContext();
	
		String appPath = context.getRealPath(bean.getFilePath());
		System.out.println("appPath = " + appPath);

		File downloadFile = new File(bean.getFilePath());
		FileInputStream inputStream = new FileInputStream(downloadFile);

		String mimeType = context.getMimeType("");
		if (mimeType == null) {

			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();
	}

	@RequestMapping(value = "/alterStatus", method = RequestMethod.POST)
	public void alterStatus(HttpServletResponse resp, HttpServletRequest req,
			HistoricStatusBean historicStatusBean, BindingResult result,
			ModelMap modelMap, String dateChange) throws Exception {
		UserBean userBean = (UserBean) req.getSession().getAttribute(
				"userLogged");

		historicStatusBean = occurrenceService.alterStatus(userBean,
				historicStatusBean, dateChange);
		resp.setCharacterEncoding("UTF-8");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteOccurrence(String id, HttpServletResponse resp, HttpServletRequest req,OccurrenceFilterBean bean)
			throws Exception {
		

		occurrenceService.deleteOccurrence(Long.parseLong(id));

		int quantityOccurrence = (int) getNumberOccurrences(bean,bean.getIdResponsableOccurrence());
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(quantityOccurrence);
	}

	@RequestMapping(value = "/deleteAnnex", method = RequestMethod.POST)
	public void deleteAnnex(String id, HttpServletResponse resp,
			AnnexBean annexBean) throws Exception {

		occurrenceService.deleteAnnex(annexBean.getId());
		new ArrayList().contains("cdlj");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(new JSONParser().objectToJSON(true));

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse resp, HttpServletRequest req,
			OccurrenceBean occurrenceBean, BindingResult result,
			String idOcurrence, Model model) throws Exception {
		req.getSession().setAttribute("idOccurrence", occurrenceBean.getId());

		occurrenceBean.setOccurrenceDeleted(1);
		occurrenceBean = occurrenceService.updateOccurrence(occurrenceBean,
				occurrenceBean.getId());
		model.addAttribute("success", "Ocorrência alterada com sucesso.");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(new JSONParser().objectToJSON(occurrenceBean));

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(HttpServletResponse resp, HttpServletRequest req,
			OccurrenceBean occurrenceBean, BindingResult result,
			ModelMap modelMap) throws Exception {

		UserBean userBean = (UserBean) req.getSession().getAttribute(
				"userLogged");

		occurrenceBean = occurrenceService.includeOccurrence(userBean,
				occurrenceBean);
		resp.setCharacterEncoding("UTF-8");
		req.getSession().setAttribute("idOccurrence", occurrenceBean.getId());
		resp.getWriter().print(new JSONParser().objectToJSON(occurrenceBean));

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req, ModelMap modelMap,
			HttpServletResponse resp, String hdnId) {

		UserBean userBean = (UserBean) req.getSession().getAttribute(
				"userLogged");

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		List<MultipartFile> multipartFiles = multipartRequest.getFiles("file");

		for (MultipartFile multipartFile : multipartFiles) {

			if (multipartFile.getSize() > 0) {
				try {
					occurrenceService.upload(multipartFile,
							Long.parseLong(hdnId), userBean);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return "redirect:../occurrence/maintenance?id=" + hdnId;
	}
	
}
