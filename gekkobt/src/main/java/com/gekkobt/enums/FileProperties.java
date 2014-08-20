package com.gekkobt.enums;

public enum FileProperties {
	GEKKO("C:\\dev\\Gekko"),

	// DASHBOARD("/apps/was/aplic/dashboard/dat/Dashboard"),

	MAPPING_FILE("");

	String path;

	FileProperties(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}