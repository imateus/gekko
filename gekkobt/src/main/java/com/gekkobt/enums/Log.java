package com.gekkobt.enums;

public enum Log {
	DEBUG("V", "DEBUG"),
	INFO("I", "INFO"),
	ERROR("E", "ERROR");
	
	Log(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	private String value;
	private String description;

	public String getValue() {
		return value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Log fromValue(String value) throws IllegalArgumentException {
		try {
			for (Log log : Log.values()) {
				if (log.getValue().equals(value)) {
					return log;
				}
			}
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Unknown enum value :" + value);
		}
	}
}
