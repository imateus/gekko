package com.gekkobt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="TB_CLIENT")
public class ClientEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_CLIENT", precision=0)
	private Long id;

	@Column(name = "CLIENT_REASON_SOCIAL")
	private String reasonSocial;

	@Column(name = "CLIENT_FANTASY_NAME")
	private String fantasyName;
	
	@Column(name = "CLIENT_NUMBER_CNPJ")
	private Integer numberCnpj;
	
	public String getReasonSocial() {
		return reasonSocial;
	}

	public void setReasonSocial(String reasonSocial) {
		this.reasonSocial = reasonSocial;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public Integer getNumberCnpj() {
		return numberCnpj;
	}

	public void setNumberCnpj(Integer numberCnpj) {
		this.numberCnpj = numberCnpj;
	}

	public ClientEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
