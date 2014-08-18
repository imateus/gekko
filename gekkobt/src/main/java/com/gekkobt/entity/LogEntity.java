package com.gekkobt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_LOG")
public class LogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LOG", precision = 0)
	private Long id;

	@Column(name = "LOG_EVENT")
	private String logEvent;

	@Column(name = "LOG_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date logDate;

	@Column(name = "LOG_RESPONSIBLE")
	private String logResponsible;

	@Column(name = "LOG_TYPE")
	private String logType;

	@Column(name = "LOG_EXCEPTION_MESSAGE")
	private String exceptionMessage;

	@Column(name = "LOG_STACKTRACE")
	private String stackTrace;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogEvent() {
		return logEvent;
	}

	public void setLogEvent(String logEvent) {
		this.logEvent = logEvent;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getLogResponsible() {
		return logResponsible;
	}

	public void setLogResponsible(String logResponsible) {
		this.logResponsible = logResponsible;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	

}
