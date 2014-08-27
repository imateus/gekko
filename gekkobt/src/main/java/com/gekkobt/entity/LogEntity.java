package com.gekkobt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the TD0_LOG database table.
 * 
 */
@Entity
@Table(name="TD0_LOG")
public class LogEntity implements Serializable {

	private static final long serialVersionUID = -8429270988528259383L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOG_ID", precision = 0)
	private long logId;

	@Column(name="LOG_DATE")
	private Timestamp logDate;

	@Column(name="LOG_MESSAGE_TEXT")
	private String logMessageText;

	@Column(name="LOG_SOURCE_TEXT", precision = 400, length = 400)
	private String logSourceText;

	@Column(name="LOG_TYPE_IND")
	private String logTypeInd;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="LOG_USER_ID")
	private UserEntity userEntity;
	
	@Column(name="LOG_REQUEST_IP_ADDR")
	private String logRequestIpAddr;

	public LogEntity() {
	}

	public long getLogId() {
		return this.logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public String getLogMessageText() {
		return this.logMessageText;
	}

	public void setLogMessageText(String logMessageText) {
		this.logMessageText = logMessageText;
	}

	public String getLogSourceText() {
		return this.logSourceText;
	}

	public void setLogSourceText(String logSourceText) {
		this.logSourceText = logSourceText;
	}

	public String getLogTypeInd() {
		return this.logTypeInd;
	}

	public void setLogTypeInd(String logTypeInd) {
		this.logTypeInd = logTypeInd;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLogRequestIpAddr() {
		return logRequestIpAddr;
	}

	public void setLogRequestIpAddr(String logRequestIpAddr) {
		this.logRequestIpAddr = logRequestIpAddr;
	}
	
}