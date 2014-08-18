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
@Table(name = "TB_ANNEX")
public class AnnexEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ANNEX", precision = 0)
	private Long id;

	@Column(name = "ANNEX_FILE_NAME")
	private String fileName;
	
	@Column(name = "ANNEX_FILE_EXTENSION")
	private String fileExtension;

	@Column(name = "ANNEX_FILE_PATH")
	private String filePath;

	@Column(name = "ANNEX_INCLUSION_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date inclusionDate;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ANNEX_USER_FILE_INCLUSION")
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OCCURRENCE_ID")
	private OccurrenceEntity occurrenceEntity;
	
	@Column(name = "ANNEX_DELETED")
	private Integer annexDeleted;

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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public OccurrenceEntity getOccurrenceEntity() {
		return occurrenceEntity;
	}

	public void setOccurrenceEntity(OccurrenceEntity occurrenceEntity) {
		this.occurrenceEntity = occurrenceEntity;
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
