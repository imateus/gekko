
package com.gekkobt.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.gekkobt.bean.LogBean;

public class ExcelLogView extends AbstractExcelView {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,	HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		List<LogBean> listBean = (List<LogBean>) model.get("operations");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Logs sistêmicos");
 
		HSSFRow rowHeader = sheet.createRow(0);
		sheet.setDefaultColumnWidth(20);
	
		creatCell(workbook, rowHeader, "Log id", 0);
		creatCell(workbook, rowHeader, "Log Data", 1);
		creatCell(workbook, rowHeader, "Mensagem de log", 2);
		creatCell(workbook, rowHeader, "Origem do log", 3);
		creatCell(workbook, rowHeader, "Tipo de log", 4);
		creatCell(workbook, rowHeader, "Usuário responsável", 5);
		             	
		int rowNum = 1;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		for (LogBean bean : listBean) {
			HSSFRow row = sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(bean.getLogId());
			row.createCell(1).setCellValue(formatDate.format(bean.getLogDate()));
			row.createCell(2).setCellValue(bean.getLogMessageText());
			row.createCell(3).setCellValue(bean.getLogSourceText());	
			row.createCell(4).setCellValue(bean.getLogTypeInd());
			row.createCell(5).setCellValue(bean.getUserBean().getUserName());	
		}  
	}     
	
	private void creatCell(HSSFWorkbook workbook, HSSFRow rowHeader,String titleCell,int indexCell) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
       
        HSSFCell cell = rowHeader.createCell(indexCell);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(titleCell);
	}        
}          
           
           