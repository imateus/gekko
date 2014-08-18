package com.gekkobt.bean;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class PriorityBean {

	public PriorityBean() {

	}

	@Id
	private Integer id;
	/*
	 * @NotNull(message = "Tipo de prioridade não pode ser nulo.")
	 * 
	 * @Min(value = 1, message = "Selecione um tipo de prioridade.")
	 */
	private String priorityType;

	private List<OccurrenceBean> priority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPriorityType() {
		return priorityType;
	}

	public void setPriorityType(String priorityType) {
		this.priorityType = priorityType;
	}

	public List<OccurrenceBean> getPriority() {
		return priority;
	}

	public void setPriority(List<OccurrenceBean> priority) {
		this.priority = priority;
	}

}