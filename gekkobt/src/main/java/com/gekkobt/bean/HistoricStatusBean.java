package com.gekkobt.bean;

import java.util.Date;

import javax.validation.Valid;

public class HistoricStatusBean {

	private Long id;

	private String historicJustification;

	private Date historicDateChange;

	@Valid
	private UserBean responsibleChangeBean;

	@Valid
	private StatusBean historicStatusBean;
	
	@Valid
	private OccurrenceBean idOccurrenceBean;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistoricJustification() {
		return historicJustification;
	}

	public void setHistoricJustification(String historicJustification) {
		this.historicJustification = historicJustification;
	}

	public Date getHistoricDateChange() {
		return historicDateChange;
	}

	public void setHistoricDateChange(Date historicDateChange) {
		this.historicDateChange = historicDateChange;
	}

	public UserBean getResponsibleChangeBean() {
		return responsibleChangeBean;
	}

	public void setResponsibleChangeBean(UserBean responsibleChangeBean) {
		this.responsibleChangeBean = responsibleChangeBean;
	}

	public StatusBean getHistoricStatusBean() {
		return historicStatusBean;
	}

	public void setHistoricStatusBean(StatusBean historicStatusBean) {
		this.historicStatusBean = historicStatusBean;
	}

	public OccurrenceBean Bean() {
		return idOccurrenceBean;
	}

	public void setIdOccurrenceBean(OccurrenceBean idOccurrenceBean) {
		this.idOccurrenceBean = idOccurrenceBean;
	}

	public OccurrenceBean getIdOccurrenceBean() {
		return idOccurrenceBean;
	}
	
	
}
