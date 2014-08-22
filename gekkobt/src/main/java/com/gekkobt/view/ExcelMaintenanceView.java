
package com.gekkobt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.gekkobt.bean.OccurrenceBean;

public class ExcelMaintenanceView extends AbstractExcelView {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,	HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
 
		List<OccurrenceBean> listBean = (List<OccurrenceBean>) model.get("operations");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Occorrência"+"Id: ?");
 
		HSSFRow rowHeader = sheet.createRow(0);		
	
		rowHeader.createCell(0).setCellValue("?"); 
		rowHeader.createCell(0).setCellValue("?"); 
		
		              	
		int rowNum = 1;
/*		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");*/
		
		for (OccurrenceBean bean : listBean) {
			HSSFRow row = sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(bean.getId());
			row.createCell(1).setCellValue(bean.getOccurrenceTitle());					
		}  
	}      
	       
}          
           
           