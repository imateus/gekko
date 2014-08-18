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
@Table(name="TB_USER")	
public class UserEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_USER", precision=0)
	private Long id;

	@Column(name = "USER_LOGIN")
	private String userLogin;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name = "OCCURRENCE_USER_INCLUSION", updatable=false, insertable=false)
	private List<OccurrenceEntity> userInclusion;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name = "OCCURRENCE_USER_RESPONSIBLE", updatable=false, insertable=false)
	private List<OccurrenceEntity> userResponsable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<OccurrenceEntity> getUserInclusion() {
		return userInclusion;
	}

	public void setUserInclusion(List<OccurrenceEntity> userInclusion) {
		this.userInclusion = userInclusion;
	}

	public List<OccurrenceEntity> getUserResponsable() {
		return userResponsable;
	}

	public void setUserResponsable(List<OccurrenceEntity> userResponsable) {
		this.userResponsable = userResponsable;
	}


}