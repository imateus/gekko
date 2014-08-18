package com.gekkobt.bean;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class ReportUserBean {

	public ReportUserBean() {

	}

	private Date dataChange;

	private BigInteger responsibleId;

	private BigInteger qtdPendende;

	private BigInteger qtdFinalizado;

	private BigInteger qtdIncluida;
	
	private String responsibleName;

	public Date getDataChange() {
		return dataChange;
	}

	public void setDataChange(Date dataChange) {
		this.dataChange = dataChange;
	}

	public BigInteger getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(BigInteger responsibleId) {
		this.responsibleId = responsibleId;
	}

	public BigInteger getQtdPendende() {
		return qtdPendende;
	}

	public void setQtdPendende(BigInteger qtdPendende) {
		this.qtdPendende = qtdPendende;
	}

	public BigInteger getQtdFinalizado() {
		return qtdFinalizado;
	}

	public void setQtdFinalizado(BigInteger qtdFinalizado) {
		this.qtdFinalizado = qtdFinalizado;
	}

	public BigInteger getQtdIncluida() {
		return qtdIncluida;
	}

	public void setQtdIncluida(BigInteger qtdIncluida) {
		this.qtdIncluida = qtdIncluida;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

}
