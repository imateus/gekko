package com.gekkobt.enums;
public enum MappingIntegration {
	PEGASUSOPERATION("pegasus.operation", "Pegasus - Operações Tampa", "Pegasus Operation", System.PEGASUS, true),
	
	PEGASUSTAX("pegasus.tax", "Pegasus - Impostos das operações", "Pegasus Tax", System.PEGASUS, true),
	
	SECOREPEN10AM("secore.pen10am", "Secore - Operações de projeção D-1", "Secore PEN10AM", System.SECORE, false),
	
	DEPOBOXD0("depobox.d0", "Depobox - Operações de TED", "Depobox D0", System.DEPOBOX, false),
	
	DEPOBOXD1("depobox.d-1", "Depobox - Operações de projeção D-1", "Depobox D-1", System.DEPOBOX, true),
	
	TRADESYSTEMCAMBIO("tradesystem.cambio", "TradeSystem - Operações de Câmbio e Evento de Tampa", "TradeSystem Câmbio Evento", System.TRADESYSTEM, false),
	
	GRBDANNQ601("grb.dann601", "GRB - Saldo da C/C", "GRB Saldo Conta Corrente", System.GRB, false),
	
	BW("bw.operation", "BW - Resumo de operações", "BW Resumo", System.BWPAGEE, true);

	MappingIntegration(String value, String description, String folder,
			System system, Boolean isManualInput) {
		this.value = value;
		this.description = description;
		this.folder = folder;
		this.system = system;
		this.isManualInput = isManualInput;
	}

	private String value;
	private String description;
	private String folder;
	private System system;
	private Boolean isManualInput;

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Boolean getIsManualInput() {
		return isManualInput;
	}

	public void setIsManualInput(Boolean isManualInput) {
		this.isManualInput = isManualInput;
	}
}
