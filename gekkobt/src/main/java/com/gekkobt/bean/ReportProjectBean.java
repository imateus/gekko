package com.gekkobt.bean;

import org.springframework.stereotype.Component;

@Component
public class ReportProjectBean {

	public ReportProjectBean() {

	}
	
	private Long IdStatus;
	private String DescriptionStatus;
	private Long QtdError;
	private Long QtdAlterScope;
	private Long QtdRecurrence;
	
	public Long getIdStatus() {
		return IdStatus;
	}
	public void setIdStatus(Long idStatus) {
		IdStatus = idStatus;
	}
	public Long getQtdError() {
		return QtdError;
	}
	public void setQtdError(Long qtdError) {
		QtdError = qtdError;
	}
	public Long getQtdAlterScope() {
		return QtdAlterScope;
	}
	public void setQtdAlterScope(Long qtdAlterScope) {
		QtdAlterScope = qtdAlterScope;
	}
	public Long getQtdRecurrence() {
		return QtdRecurrence;
	}
	public void setQtdRecurrence(Long qtdRecurrence) {
		QtdRecurrence = qtdRecurrence;
	}
	public String getDescriptionStatus() {
		return DescriptionStatus;
	}
	public void setDescriptionStatus(String descriptionStatus) {
		DescriptionStatus = descriptionStatus;
	}
	
}
