package com.gekkobt.bean;

import java.util.Date;

import javax.validation.Valid;

public class OccurrenceBean {

	private Long id;

	@Valid
	private TypeOccurrenceBean typeOccurrenceBean;

	@Valid
	private StatusBean statusBean;

	@Valid
	private ProjectBean projectBean;

	private Date inclusionDate;

	private Date finalizationDate;

	@Valid
	private PriorityBean priorityBean;

	@Valid
	private UserBean occurrenceUserResponsibleBean;

	@Valid
	private UserBean occurrenceUserInclusionBean;

	private String occurrenceTitle;

	private String occurrenceDescription;

	private Integer occurrenceDeleted;

	public String getOccurrenceTitle() {
		return occurrenceTitle;
	}

	public void setOccurrenceTitle(String occurrenceTitle) {
		this.occurrenceTitle = occurrenceTitle;
	}

	public String getOccurrenceDescription() {
		return occurrenceDescription;
	}

	public void setOccurrenceDescription(String occurrenceDescription) {
		this.occurrenceDescription = occurrenceDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeOccurrenceBean getTypeOccurrenceBean() {
		return typeOccurrenceBean;
	}

	public void setTypeOccurrenceBean(TypeOccurrenceBean typeOccurrenceBean) {
		this.typeOccurrenceBean = typeOccurrenceBean;
	}

	public StatusBean getStatusBean() {
		return statusBean;
	}

	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public Date getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(Date inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public Date getFinalizationDate() {
		return finalizationDate;
	}

	public void setFinalizationDate(Date finalizationDate) {
		this.finalizationDate = finalizationDate;
	}

	public PriorityBean getPriorityBean() {
		return priorityBean;
	}

	public void setPriorityBean(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
	}

	public UserBean getOccurrenceUserResponsibleBean() {
		return occurrenceUserResponsibleBean;
	}

	public void setOccurrenceUserResponsibleBean(
			UserBean occurrenceUserResponsibleBean) {
		this.occurrenceUserResponsibleBean = occurrenceUserResponsibleBean;
	}

	public UserBean getOccurrenceUserInclusionBean() {
		return occurrenceUserInclusionBean;
	}

	public void setOccurrenceUserInclusionBean(
			UserBean occurrenceUserInclusionBean) {
		this.occurrenceUserInclusionBean = occurrenceUserInclusionBean;
	}

	public Integer getOccurrenceDeleted() {
		return occurrenceDeleted;
	}

	public void setOccurrenceDeleted(Integer occurrenceDeleted) {
		this.occurrenceDeleted = occurrenceDeleted;
	}

}