package com.gekkobt.bean;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserBean {

	public UserBean() {

	}

	private Long id;

	@NotEmpty(message = "Login não pode ser nulo.")
	private String userLogin;

	@NotEmpty(message = "Senha não pode ser nula.")
	private String userPassword;

	@NotEmpty(message = "E-mail não pode ser nulo.")
	private String userEmail;

	private String userName;

	private List<OccurrenceBean> userInclusion;

	private List<OccurrenceBean> userResponsable;

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<OccurrenceBean> getUserInclusion() {
		return userInclusion;
	}

	public void setUserInclusion(List<OccurrenceBean> userInclusion) {
		this.userInclusion = userInclusion;
	}

	public List<OccurrenceBean> getUserResponsable() {
		return userResponsable;
	}

	public void setUserResponsable(List<OccurrenceBean> userResponsable) {
		this.userResponsable = userResponsable;
	}

}
