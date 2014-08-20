package com.gekkobt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Column(name="LOG_ID")
	private long logId;

	@Column(name="LOG_DATE")
	private Timestamp logDate;

	@Column(name="LOG_MESSAGE_TEXT")
	private String logMessageText;

	@Column(name="LOG_SOURCE_TEXT")
	private String logSourceText;

	@Column(name="LOG_TYPE_IND")
	private String logTypeInd;
	
	@Column(name="LOG_DATE_GLB")
	private Timestamp logDateGlb;
	
	@Column(name="LOG_USER_ID")
	private String logUserId;
	
	@Column(name="LOG_SUCCESS_IND")
	private String logSucessInd;
	
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

	public Timestamp getLogDateGlb() {
		return logDateGlb;
	}

	public void setLogDateGlb(Timestamp logDateGlb) {
		this.logDateGlb = logDateGlb;
	}

	public String getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(String logUserId) {
		this.logUserId = logUserId;
	}

	public String getLogSucessInd() {
		return logSucessInd;
	}

	public void setLogSucessInd(String logSucessInd) {
		this.logSucessInd = logSucessInd;
	}

	public String getLogRequestIpAddr() {
		return logRequestIpAddr;
	}

	public void setLogRequestIpAddr(String logRequestIpAddr) {
		this.logRequestIpAddr = logRequestIpAddr;
	}
	
}