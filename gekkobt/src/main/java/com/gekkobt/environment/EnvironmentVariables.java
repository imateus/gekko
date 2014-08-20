package com.gekkobt.environment;

import com.gekkobt.enums.FileProperties;
import com.gekkobt.util.Properties;

public class EnvironmentVariables {
	
	public static String ENVIRONMENT; 

	public static String SERVER;
	
	public static Properties getDashboardProperties() {
		return new Properties(FileProperties.GEKKO.getPath());
	}
	

	public static Boolean isDev() {
		return "DEV".equalsIgnoreCase(EnvironmentVariables.ENVIRONMENT);
	}
	
	public static Boolean isJetty() {
		return "JETTY".equalsIgnoreCase(EnvironmentVariables.SERVER);
	}
	
	public static String getServerIP(){
		return null;
	}
}
