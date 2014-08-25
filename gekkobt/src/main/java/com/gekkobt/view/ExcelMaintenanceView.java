
package com.gekkobt.view;

import java.text.SimpleDateFormat;
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

import com.gekkobt.bean.OccurrenceBean;

public class ExcelMaintenanceView extends AbstractExcelView {

	@Override
	@SuppressWarnings({"rawtypes" })
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,	HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
 
		OccurrenceBean bean =  (OccurrenceBean) model.get("operations");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Occorrência id - " + bean.getId().toString());
 
		HSSFRow rowHeader = sheet.createRow(0);		
		sheet.setDefaultColumnWidth(20);
		
		creatCell(workbook, rowHeader, "Id da ocorrência", 0);
        creatCell(workbook, rowHeader, "Ocorrência", 1);
        creatCell(workbook, rowHeader, "Descrição da ocorrência", 2);
        creatCell(workbook, rowHeader, "Tipo da ocorrência", 3);
        creatCell(workbook, rowHeader, "Prioridade", 4);
        creatCell(workbook, rowHeader, "Status", 5);
        creatCell(workbook, rowHeader, "Nome do projeto", 6);
        creatCell(workbook, rowHeader, "Usuário de inclusão", 7);
        creatCell(workbook, rowHeader, "Usuário responsável", 8);
        creatCell(workbook, rowHeader, "Data de inclusão", 9);
        creatCell(workbook, rowHeader, "Data de Finalização", 10); 
		
		              	
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
	
		HSSFRow row = sheet.createRow(1);
			
		row.createCell(0).setCellValue(bean.getId());
		row.createCell(1).setCellValue(bean.getOccurrenceTitle());
		row.createCell(2).setCellValue(bean.getOccurrenceDescription());
		row.createCell(3).setCellValue(bean.getTypeOccurrenceBean().getOccurenceType());
		row.createCell(4).setCellValue(bean.getPriorityBean().getPriorityType());
		row.createCell(5).setCellValue(bean.getStatusBean().getStatusType());
		row.createCell(6).setCellValue(bean.getProjectBean().getProjectName());
		row.createCell(7).setCellValue(bean.getOccurrenceUserInclusionBean().getUserName());
		row.createCell(8).setCellValue(bean.getOccurrenceUserResponsibleBean().getUserName());
		row.createCell(9).setCellValue(formatDate.format(bean.getInclusionDate()));	
		row.createCell(10).setCellValue(bean.getFinalizationDate() == null ? "":formatDate.format(bean.getFinalizationDate()));  
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
           
           