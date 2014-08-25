
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
import com.gekkobt.service.OccurrenceService;
import com.gekkobt.view.ExcelMaintenanceView;

@Controller
@RequestMapping("/occurrence/maintenance")
@SessionAttributes(value = "operations")

public class ExcelMaintenanceController extends AbstractController {
	
	@Autowired
	private ExcelMaintenanceView excelMaintenanceView;
	
	@Autowired
	private OccurrenceService occurrenceService;
	
	@RequestMapping(value = "/exportExcelMaintenance", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response,String id){
		
		
		ExcelMaintenanceView view = new ExcelMaintenanceView();
		try {
			OccurrenceBean bean = new OccurrenceBean();
			bean = occurrenceService.findOccurrenceId(Long.parseLong(id));
			request.getSession().setAttribute("occurrenceExcel", bean);
			List<OccurrenceBean> operationList=null;
			return new ModelAndView(view, "operations", bean);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return null;
	}

}
