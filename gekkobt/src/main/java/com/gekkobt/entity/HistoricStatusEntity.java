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
@Table(name = "TB_HISTORIC_STATUS")
public class HistoricStatusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_HISTORIC_STATUS", precision = 0)
	private Long id;

	@Column(name = "HISTORIC_JUSTIFICATION")
	private String historicJustification;

	@Column(name = "HISTORIC_DATE_CHANGE")
	@Temporal(value = TemporalType.DATE)
	private Date historicDateChange;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "HISTORIC_RESPONSIBLE_CHANGE")
	private UserEntity responsibleChangeEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "HISTORIC_STATUS")
	private StatusEntity historicStatusEntity;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_OCCURRENCE")
	private OccurrenceEntity idOccurrenceEntity;

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

	public UserEntity getResponsibleChangeEntity() {
		return responsibleChangeEntity;
	}

	public void setResponsibleChangeEntity(UserEntity responsibleChangeEntity) {
		this.responsibleChangeEntity = responsibleChangeEntity;
	}

	public StatusEntity getHistoricStatusEntity() {
		return historicStatusEntity;
	}

	public void setHistoricStatusEntity(StatusEntity historicStatusEntity) {
		this.historicStatusEntity = historicStatusEntity;
	}

	public OccurrenceEntity getIdOccurrenceEntity() {
		return idOccurrenceEntity;
	}

	public void setIdOccurrenceEntity(OccurrenceEntity idOccurrenceEntity) {
		this.idOccurrenceEntity = idOccurrenceEntity;
	}

}
