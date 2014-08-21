package com.gekkobt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gekkobt.bean.OccurrenceBean;

public class ExcelParse {

	/*public List<OccurrenceBean> parseOperation(String pathFile,
			MappingIntegration mapping) {
		List<OccurrenceBean> response = new ArrayList<OccurrenceBean>();

		try {
			FileInputStream file = new FileInputStream(new File(pathFile));
			HSSFWorkbook workbook = new HSSFWorkbook(file); // Get the workbook
															// instance for XLS
															// file
			for(int j=0;j<workbook.getNumberOfSheets();j++){
				HSSFSheet sheet = workbook.getSheetAt(j); // Get sheet
				if (   mapping == MappingIntegration.CITIDOCS_CAMBIO_APPROVED
					|| mapping == MappingIntegration.CITIDOCS_CAMBIO_WAITING
					|| mapping == MappingIntegration.CITIDOCS_CAMBIO_WAITTING_APPROVE) {
					if(!(workbook.getSheetName(j).equalsIgnoreCase("COMPRA")
							|| workbook.getSheetName(j).equalsIgnoreCase("VENDA"))){
						continue;
					}
				}else if(j > 0){
					continue;
				}
			
				Iterator<Row> rowIterator = sheet.iterator(); // Iterate through
																// each rows from
																// first sheet
				OccurrenceBean bean;
				AccountBean account;
				Row row;
				Cell cell;
				Properties properties = new Properties(FileProperties.MAPPING_FILE);
				String prefixNameProperty = mapping.getValue();
				int headerEndRow = Integer.parseInt(properties
						.getValue(prefixNameProperty + ".header"));
				int valueColumn = Integer.parseInt(properties
						.getValue(prefixNameProperty + ".value"));
				Integer accountColumn = null;
				Integer beanTypeColumn = null;
				Integer statusColumn = null;
				Integer creditDebitColumn = null;
				Integer descriptionColumn = null;
				Integer clientColumn = null;
				Integer boletaColumn = null;
				Integer bcColumn = null;
				Integer payCodeColumn = null;
				
	
				String accountValueColumn = properties.getValue(prefixNameProperty
						+ ".account");
				String beanTypeValueColumn = properties
						.getValue(prefixNameProperty + ".beanType");
				String statusValueColumn = properties.getValue(prefixNameProperty
						+ ".status");
	
				String creditDebit = properties.getValue(prefixNameProperty
						+ ".credit_debit");
	
				String description = properties.getValue(prefixNameProperty + ".description");
				
				String clientColumnValue = properties.getValue(prefixNameProperty + ".client");
				
				String boletaColumnValue = properties.getValue(prefixNameProperty + ".boleta");
				
				String bcColumnValue = properties.getValue(prefixNameProperty + ".bc");
				
				String payCodeColumnValue = properties.getValue(prefixNameProperty + ".payCode");
				
				if (clientColumnValue != null && !clientColumnValue.isEmpty()) {
					clientColumn = Integer.parseInt(clientColumnValue);
				}
				if (boletaColumnValue != null && !boletaColumnValue.isEmpty()) {
					boletaColumn = Integer.parseInt(boletaColumnValue);
				}
				if (bcColumnValue != null && !bcColumnValue.isEmpty()) {
					bcColumn = Integer.parseInt(bcColumnValue);
				}
				if (payCodeColumnValue != null && !payCodeColumnValue.isEmpty()) {
					payCodeColumn = Integer.parseInt(payCodeColumnValue);
				}
				
				if (accountValueColumn != null && !accountValueColumn.isEmpty()) {
					accountColumn = Integer.parseInt(accountValueColumn);
				}
	
				if (beanTypeValueColumn != null
						&& !beanTypeValueColumn.isEmpty()) {
					beanTypeColumn = Integer
							.parseInt(beanTypeValueColumn);
				}
	
				if (statusValueColumn != null && !statusValueColumn.isEmpty()) {
					statusColumn = Integer.parseInt(statusValueColumn);
				}
	
				if (creditDebit != null) {
					creditDebitColumn = Integer.parseInt(creditDebit);
				}
				
				if(description != null){
					descriptionColumn = Integer.parseInt(description);
				}
	
				int currentRow = 0;
	
				while (rowIterator.hasNext()) {
					row = rowIterator.next();
	
					if (currentRow > headerEndRow) {
						bean = new OccurrenceBean();
						account = new AccountBean();
	
						if (accountValueColumn != null) {
							cell = row.getCell(accountColumn);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							account.setAccountId((String) getValue(cell));
							ProfileAccountBean profile = new ProfileAccountBean();
							account.setProfileAccountBean(profile);
							bean.setAccount(account);
						}
	
						if (beanTypeValueColumn != null) {
							cell = row.getCell(beanTypeColumn);
							bean.setOperationType((String) getValue(cell));
						}
	
						cell = row.getCell(valueColumn);
						BigDecimal opValue = new BigDecimal(0);
						if (cell != null) {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String valueStr = (String)getValue(cell);
							valueStr.replaceAll(".", "");
							valueStr.replaceAll(",", ".");
							opValue = new BigDecimal(valueStr,
									MathContext.DECIMAL64);
						}
						if (creditDebitColumn != null) {
							Cell cellCreditDebit = row.getCell(creditDebitColumn);
							if ("DÉBITO"
									.equalsIgnoreCase((String) getValue(cellCreditDebit))) {
								bean.setValue(opValue.negate());
							} else {
								bean.setValue(opValue);
							}
						} else {
							bean.setValue(opValue);
						}
						
						if(descriptionColumn != null){
							cell = row.getCell(descriptionColumn);
							bean.setDescription((String) getValue(cell));
						}
	
						if (statusValueColumn != null) {
							cell = row.getCell(statusColumn);
							bean.setStatus((String) getValue(cell));
						}
	
						
						//////
						if (clientColumn != null) {
							cell = row.getCell(clientColumn);
							String client = "";
							if(getValue(cell) != null){
								client = (String) getValue(cell);
							}
							bean.setOperationCitidocsCustomerText(client);
						}
						
						if (boletaColumn != null) {
							cell = row.getCell(boletaColumn);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							bean.setReferenceText((String) getValue(cell));
						}
						
						if (bcColumn != null) {
							cell = row.getCell(bcColumn);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							bean.setBcNature((String) getValue(cell));
						}
						response.add(bean);
					}
	
					currentRow++;
				}
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
*/
	
	public void exportExcel(String nomeArquivo, List<OccurrenceBean> listbean) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Gekko-Ocorrências");

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File(nomeArquivo));

			int i = 1;

			HSSFRow rowHeader = firstSheet.createRow(0);
			rowHeader.createCell(0).setCellValue("Id da Ocorrência");
			rowHeader.createCell(1).setCellValue("Projeto");
			rowHeader.createCell(2).setCellValue("Descrição da Ocorrência");

			for (OccurrenceBean occurrenceBean : listbean) {
				HSSFRow row = firstSheet.createRow(i);

				row.createCell(0).setCellValue(occurrenceBean.getId());
				row.createCell(1).setCellValue(occurrenceBean.getProjectBean().getProjectName());
				row.createCell(2).setCellValue(occurrenceBean.getOccurrenceTitle());

				i++;
			}

			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
