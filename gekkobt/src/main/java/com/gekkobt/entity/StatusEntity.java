package com.gekkobt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_STATUS")
public class StatusEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_STATUS", precision=0)
	private Long id;
	
	@Column(name = "STATUS_TYPE")
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
