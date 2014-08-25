
package com.gekkobt.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.gekkobt.bean.ReportUserBean;

public class ExcelReportUserView extends AbstractExcelView {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,	HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		ArrayList<String> listTitlesCellOccurrences = new ArrayList<>();
		listTitlesCellOccurrences.add("ID da occorrência");
 
		List<ReportUserBean> listBean = (List<ReportUserBean>) model.get("operations");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Ocorrências por usuário");
 
		HSSFRow rowHeader = sheet.createRow(0);		
		
		sheet.setDefaultColumnWidth(20);
		    
		creatCell(workbook, rowHeader, "Usuário", 0);
        creatCell(workbook, rowHeader, "Ocorrências criadas", 1);
        creatCell(workbook, rowHeader, "Ocorrências resolvidas", 2);
        creatCell(workbook, rowHeader, "Ocorrências pendentes", 3);
        creatCell(workbook, rowHeader, "Última atualização", 4);
	              	
		int rowNum = 1;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		for (ReportUserBean bean : listBean) {
			HSSFRow row = sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(bean.getResponsibleName());
			row.createCell(1).setCellValue(bean.getQtdIncluida().intValue());
			row.createCell(2).setCellValue(bean.getQtdFinalizado().intValue());	
			row.createCell(3).setCellValue(bean.getQtdPendende().intValue());	
			row.createCell(4).setCellValue(bean.getDataChange() == null ? "":formatDate.format(bean.getDataChange()));
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
           
           