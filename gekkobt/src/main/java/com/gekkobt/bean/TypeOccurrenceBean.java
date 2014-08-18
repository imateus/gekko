package com.gekkobt.bean;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class TypeOccurrenceBean {

	public TypeOccurrenceBean() {

	}

	@Id
	/*
	 * @NotNull(message = "Tipo de ocorrência não pode ser nulo.")
	 * 
	 * @Min(value = 1, message = "Selecione um tipo de ocorrência.")
	 */
	private Long id;
	private String occurenceType;

	private List<OccurrenceBean> typeoccurrence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccurenceType() {
		return occurenceType;
	}

	public void setOccurenceType(String occurenceType) {
		this.occurenceType = occurenceType;
	}

	public List<OccurrenceBean> getTypeoccurrence() {
		return typeoccurrence;
	}

	public void setTypeoccurrence(List<OccurrenceBean> typeoccurrence) {
		this.typeoccurrence = typeoccurrence;
	}

}
