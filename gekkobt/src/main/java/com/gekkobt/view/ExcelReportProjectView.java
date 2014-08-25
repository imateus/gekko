package com.gekkobt.view;

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

import com.gekkobt.bean.ReportProjectBean;

public class ExcelReportProjectView extends AbstractExcelView {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<ReportProjectBean> listBean = (List<ReportProjectBean>) model
				.get("operations");
				
		// create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Ocorrência projeto - " + listBean.get(0).getNameProject());

		HSSFRow rowHeader = sheet.createRow(0);
		sheet.setDefaultColumnWidth(20);

		creatCell(workbook, rowHeader, "Status", 0);
		creatCell(workbook, rowHeader, "Erro", 1);
		creatCell(workbook, rowHeader, "Alteração de escopo", 2);
		creatCell(workbook, rowHeader, "Reincidência", 3);


		int rowNum = 1;

		for (ReportProjectBean bean : listBean) {
			HSSFRow row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(bean.getDescriptionStatus());
			row.createCell(1).setCellValue(bean.getQtdError());
			row.createCell(2).setCellValue(bean.getQtdAlterScope());
			row.createCell(3).setCellValue(bean.getQtdRecurrence());
		}
	}

	private void creatCell(HSSFWorkbook workbook, HSSFRow rowHeader,
			String titleCell, int indexCell) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell cell = rowHeader.createCell(indexCell);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(titleCell);
	}

}
