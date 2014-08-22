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

import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.service.OccurrenceService;
import com.gekkobt.view.ExcelOccurrenceView;

@Controller
@RequestMapping("/occurrence")
@SessionAttributes(value = "operations")
public class ExcelOcurrenceController extends AbstractController {
	
	@Autowired
	private OccurrenceService occurrenceService;
	
	@Autowired
	private ExcelOccurrenceView excelOperationListView;
	
	@RequestMapping(value = "/excelOccurrences", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, OccurrenceFilterBean bean){
		Integer num = null;
		
		ExcelOccurrenceView view = new ExcelOccurrenceView();
		
		return new ModelAndView(view, "operations", getOccurrences(bean, num,bean.getIdResponsableOccurrence()));
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return null;
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
}
