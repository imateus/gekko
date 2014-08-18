package com.gekkobt.bean;

import org.springframework.stereotype.Component;

@Component
public class ProjectBean {

	public ProjectBean() {

	}

	private Long id;
	private String projectName;
	private String projectClient;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

}
