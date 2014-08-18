package com.gekkobt.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.gekkobt.enums.FileProperties;

public class Properties {
	private PropertiesConfiguration configuration;
	private String sufix = ".properties";
	
	public Properties(FileProperties property) {
		try {
			configuration = new PropertiesConfiguration(property.name() + sufix);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public Properties(String fileName) {
		try {
			configuration = new PropertiesConfiguration(fileName + sufix);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		if (!configuration.containsKey(key)) return null;
		
		return configuration.getString(key);
	}
}