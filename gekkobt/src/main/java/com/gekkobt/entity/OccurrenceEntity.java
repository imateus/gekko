package com.gekkobt.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_OCCURRENCE")
public class OccurrenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_OCCURRENCE", precision = 0)
	private Long id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_PROJECT_NAME")
	private ProjectEntity projectEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "PRIORITY_TYPE")
	private PriorityEntity priorityEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_STATUS")
	private StatusEntity statusEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_USER_INCLUSION")
	private UserEntity occurrenceUserInclusionEntity;

	@Column(name = "OCCURRENCE_INCLUSION_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date inclusionDate;

	@Column(name = "OCCURRENCE_FINALIZATION_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date finalizationDate;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_TYPE")
	private TypeOccurrenceEntity typeOccurrenceEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_USER_RESPONSIBLE")
	private UserEntity occurrenceUserResponsibleEntity;

	@Column(name = "OCCURRENCE_TITLE")
	private String occurrenceTitle;

	@Column(name = "OCCURRENCE_DESCRIPTION")
	private String occurrenceDescription;
	
	@Column(name = "OCCURRENCE_DELETED")
	private Integer occurrenceDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public PriorityEntity getPriorityEntity() {
		return priorityEntity;
	}

	public void setPriorityEntity(PriorityEntity priorityEntity) {
		this.priorityEntity = priorityEntity;
	}

	public StatusEntity getStatusEntity() {
		return statusEntity;
	}

	public void setStatusEntity(StatusEntity statusEntity) {
		this.statusEntity = statusEntity;
	}

	public UserEntity getOccurrenceUserInclusionEntity() {
		return occurrenceUserInclusionEntity;
	}

	public void setOccurrenceUserInclusionEntity(
			UserEntity occurrenceUserInclusionEntity) {
		this.occurrenceUserInclusionEntity = occurrenceUserInclusionEntity;
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

	public TypeOccurrenceEntity getTypeOccurrenceEntity() {
		return typeOccurrenceEntity;
	}

	public void setTypeOccurrenceEntity(
			TypeOccurrenceEntity typeOccurrenceEntity) {
		this.typeOccurrenceEntity = typeOccurrenceEntity;
	}

	public UserEntity getOccurrenceUserResponsibleEntity() {
		return occurrenceUserResponsibleEntity;
	}

	public void setOccurrenceUserResponsibleEntity(
			UserEntity occurrenceUserResponsibleEntity) {
		this.occurrenceUserResponsibleEntity = occurrenceUserResponsibleEntity;
	}

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

	public Integer getOccurrenceDeleted() {
		return occurrenceDeleted;
	}

	public void setOccurrenceDeleted(Integer occurrenceDeleted) {
		this.occurrenceDeleted = occurrenceDeleted;
	}

}
