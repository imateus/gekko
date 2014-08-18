package com.gekkobt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACTION")
public class ActionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ACTION", precision = 0)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_FUNCTIONALITY")
	private FunctionalityEntity functionality;

	@Column(name = "ACTION_NAME")
	private String actionName;

	@Column(name = "ACTION_DESCRIPTION")
	private String actionDescription;

	
	
	public FunctionalityEntity getFunctionality() {
		return functionality;
	}

	public void setFunctionality(FunctionalityEntity functionality) {
		this.functionality = functionality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

}
