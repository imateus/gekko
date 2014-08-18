package com.gekkobt.environment;

import com.gekkobt.enums.FileProperties;
import com.gekkobt.util.Properties;

public class EnvironmentVariables {
	public static Properties getDashboardProperties() {
		return new Properties(FileProperties.DASHBOARD.getPath());
	}
}