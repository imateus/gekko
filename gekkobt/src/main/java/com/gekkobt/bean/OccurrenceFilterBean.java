package com.gekkobt.bean;

import org.springframework.stereotype.Component;

@Component
public class OccurrenceFilterBean {

	public OccurrenceFilterBean() {

	}
	
	private Long IdOccurrence;

	private String InclusionDateParamFrom;

	private String InclusionDateParamTo;

	private String FinalizationDateParamFrom;

	private String FinalizationDateParamTo;

	private Long IdUserOccurrence;

	private Long IdProjectOccurrence;

	private Long IdResponsableOccurrence;

	private Long IdTypeOccurrence;

	private Integer IdStatusOccurrence;

	public Long getIdOccurrence() {
		return IdOccurrence;
	}

	public void setIdOccurrence(Long idOccurrence) {
		IdOccurrence = idOccurrence;
	}

	public String getInclusionDateParamFrom() {
		return InclusionDateParamFrom;
	}

	public void setInclusionDateParamFrom(String inclusionDateParamFrom) {
		InclusionDateParamFrom = inclusionDateParamFrom;
	}

	public String getInclusionDateParamTo() {
		return InclusionDateParamTo;
	}

	public void setInclusionDateParamTo(String inclusionDateParamTo) {
		InclusionDateParamTo = inclusionDateParamTo;
	}

	public String getFinalizationDateParamFrom() {
		return FinalizationDateParamFrom;
	}

	public void setFinalizationDateParamFrom(String finalizationDateParamFrom) {
		FinalizationDateParamFrom = finalizationDateParamFrom;
	}

	public String getFinalizationDateParamTo() {
		return FinalizationDateParamTo;
	}

	public void setFinalizationDateParamTo(String finalizationDateParamTo) {
		FinalizationDateParamTo = finalizationDateParamTo;
	}

	public Long getIdUserOccurrence() {
		return IdUserOccurrence;
	}

	public void setIdUserOccurrence(Long idUserOccurrence) {
		IdUserOccurrence = idUserOccurrence;
	}

	public Long getIdProjectOccurrence() {
		return IdProjectOccurrence;
	}

	public void setIdProjectOccurrence(Long idProjectOccurrence) {
		IdProjectOccurrence = idProjectOccurrence;
	}

	public Long getIdResponsableOccurrence() {
		return IdResponsableOccurrence;
	}

	public void setIdResponsableOccurrence(Long idResponsableOccurrence) {
		IdResponsableOccurrence = idResponsableOccurrence;
	}

	public Long getIdTypeOccurrence() {
		return IdTypeOccurrence;
	}

	public void setIdTypeOccurrence(Long idTypeOccurrence) {
		IdTypeOccurrence = idTypeOccurrence;
	}

	public Integer getIdStatusOccurrence() {
		return IdStatusOccurrence;
	}

	public void setIdStatusOccurrence(Integer idStatusOccurrence) {
		IdStatusOccurrence = idStatusOccurrence;
	}

}