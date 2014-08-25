package com.gekkobt.bean;

import java.sql.Timestamp;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.gekkobt.enums.Log;


public class LogBean {
	
	@Id
	@NotEmpty(message = "Número do log não pode ser nulo.")
	private Long logId;
	
	@NotEmpty(message = "Data não pode ser nulo.")
	private Timestamp logDate;
	private String logUserId;
	private String logTypeInd;
	private String logSourceText;
	private String logMessageText;
	private String logRequestIpAddr;
	private String logTypeName;
	
	public String getLogTypeName() {
		return logTypeName;
	}

	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}
	
	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Timestamp getLogDate() {
		return logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public String getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(String logUserId) {
		this.logUserId = logUserId;
	}

	public String getLogTypeInd() {
		return logTypeInd;
	}

	public void setLogTypeInd(String logTypeInd) {
		this.logTypeInd = logTypeInd;
	}

	public String getLogSourceText() {
		return logSourceText;
	}

	public void setLogSourceText(String logSourceText) {
		this.logSourceText = logSourceText;
	}

	public String getLogMessageText() {
		return logMessageText;
	}

	public void setLogMessageText(String logMessageText) {
		this.logMessageText = logMessageText;
	}

	public String getLogRequestIpAddr() {
		return logRequestIpAddr;
	}

	public void setLogRequestIpAddr(String logRequestIpAddr) {
		this.logRequestIpAddr = logRequestIpAddr;
	}

	public String getValueLogType(){		
		return Log.fromValue(logTypeName).getDescription();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logDate == null) ? 0 : logDate.hashCode());
		result = prime * result	+ ((logUserId == null) ? 0 : logUserId.hashCode());
		result = prime * result	+ ((logTypeInd == null) ? 0 : logTypeInd.hashCode());
		result = prime * result	+ ((logSourceText == null) ? 0 : logSourceText.hashCode());
		result = prime * result + ((logMessageText == null) ? 0 : logMessageText.hashCode());
		result = prime * result + ((logRequestIpAddr == null) ? 0 : logRequestIpAddr.hashCode());		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogBean other = (LogBean) obj;
		if (logDate == null) {
		if (other.logDate != null)
				return false;
		} else if (!logDate.equals(other.logDate))
			return false;
		if (logUserId == null) {
			if (other.logUserId != null)
				return false;
		} else if (!logUserId.equals(other.logUserId))
			return false;
		if (logTypeInd == null) {
			if (other.logTypeInd != null)
				return false;
		} else if (!logTypeInd.equals(other.logTypeInd))
			return false;
		if (logSourceText == null) {
			if (other.logSourceText != null)
				return false;
		} else if (!logSourceText.equals(other.logSourceText))
			return false;
		if (logMessageText == null) {
			if (other.logMessageText != null)
				return false;
		} else if (!logMessageText.equals(other.logMessageText))
			return false;	
		if (logRequestIpAddr == null) {
			if (other.logRequestIpAddr != null)
				return false;
		} else if (!logRequestIpAddr.equals(other.logRequestIpAddr))
			return false;
		return true;

	}

	public LogBean clone() {
		LogBean  clone = new LogBean ();
		clone.setLogDate(this.logDate);		
		clone.setLogUserId(this.logUserId);
		clone.setLogTypeInd(this.logTypeInd);
		clone.setLogSourceText(this.logSourceText);
		clone.setLogMessageText(this.logMessageText);
		clone.setLogRequestIpAddr(this.logRequestIpAddr);
		return clone;
	}

}
