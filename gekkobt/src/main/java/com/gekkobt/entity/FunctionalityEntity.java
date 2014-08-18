package com.gekkobt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity	
@Table(name="TB_FUNCTIONALITY")
public class FunctionalityEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_FUNCTIONALITY", precision=0)
	private Long id;

	@Column(name = "FUNCTIONALITY_NAME")
	private String functionalityName;
	
	@Column(name = "FUNCTIONALITY_DESCRIPTION")
	private String functionalityDescription;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="ID_FUNCTIONALITY")
	private List<ActionEntity> actions;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionalityName() {
		return functionalityName;
	}

	public void setFunctionalityName(String functionalityName) {
		this.functionalityName = functionalityName;
	}

	public String getFunctionalityDescription() {
		return functionalityDescription;
	}

	public void setFunctionalityDescription(String functionalityDescription) {
		this.functionalityDescription = functionalityDescription;
	}

}
