package com.gekkobt.bean;

import java.util.Date;

import javax.validation.Valid;

public class AnnexBean {

	private Long id;
	
	private String fileName;
	
	private String fileExtension;
	
	private String filePath;

	private Date inclusionDate;
	
	private Integer annexDeleted;
	
	@Valid
	private UserBean userBean;

	@Valid
	private OccurrenceBean occurrenceBean;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(Date inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public OccurrenceBean getOccurrenceBean() {
		return occurrenceBean;
	}

	public void setOccurrenceBean(OccurrenceBean occurrenceBean) {
		this.occurrenceBean = occurrenceBean;
	}

	public Integer getAnnexDeleted() {
		return annexDeleted;
	}

	public void setAnnexDeleted(Integer annexDeleted) {
		this.annexDeleted = annexDeleted;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}
