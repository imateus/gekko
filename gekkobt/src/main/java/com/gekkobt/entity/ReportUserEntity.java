package com.gekkobt.entity;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportUserEntity {
	
	@Column(name = "dataChange", precision = 0)
	private Date dataChange;
	
	@Id
	@Column(name = "responsibleId", precision = 0)
	private BigInteger responsibleId;
	
	@Column(name = "qtdPendende", precision = 0)
	private BigInteger qtdPendende;
	
	@Column(name = "qtdFinalizado", precision = 0)
	private BigInteger qtdFinalizado;
	
	@Column(name = "qtdIncluida", precision = 0)	
	private BigInteger qtdIncluida;
	
	@Column(name = "responsibleName", precision = 0)	
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
