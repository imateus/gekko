package com.gekkobt.bean;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class StatusBean {

	public StatusBean() {

	}

	@Id
	private Long id;
	private String statusType;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
}
