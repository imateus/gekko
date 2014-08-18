package com.gekkobt.enums;


public enum Status {
	PENDENTE(1L,"Pendente"),
	FECHADO(2L,"Fechado"),
	RESOLVIDO(3L,"Resolvido"),
	REABERTO(4L,"Reaberto");

	private Long id;
	private String statusType;
	
	Status(Long id, String statusType){
		this.id = id;
		this.statusType = statusType;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
}
