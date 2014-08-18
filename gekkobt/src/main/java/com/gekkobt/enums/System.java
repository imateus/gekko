package com.gekkobt.enums;

public enum System {
	PEGASUS("PEG", 1L,"Pegasus"),
	DEPOBOX("DEP", 2L,"Depobox"),
	TRADESYSTEM("TRD", 3L,"Trade System"),
	GRB("GRB", 4L,"GRB"),
	BWPAGEE("BWP", 5L,"BWPAGEE"),
	SECORE("SEC", 6L,"SCORE");
	
	System(String code, Long segmentCode, String nome) {
		this.code = code;
		this.segmentCode = segmentCode;
		this.nome = nome;
	}
	private String nome;
	private String code;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	private Long segmentCode;
	
	public String getCode() {
		return code;
	}

	public Long getSegmentCode() {
		return segmentCode;
	}
	
	public static System fromSystem(String code) throws IllegalArgumentException {
		try {
			for (System system : System.values()) {
				if (system.getCode().equals(code)) {
					return system;
				}
			}
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Unknown enum value :" + code);
		}
	}
	
	public static System fromCodeSystem(String nome) throws IllegalArgumentException {
		try {
			for (System system : System.values()) {
				if (system.getNome().equals(nome)) {
					return system;
				}
			}
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Unknown enum value :" + nome);
		}
	}
}
