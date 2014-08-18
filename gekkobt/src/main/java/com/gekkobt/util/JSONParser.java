package com.gekkobt.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JSONParser {
	public String objectToJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			return null;
		}
	}
}