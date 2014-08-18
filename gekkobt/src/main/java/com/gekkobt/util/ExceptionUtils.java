package com.gekkobt.util;

import javax.servlet.http.HttpServletResponse;

public class ExceptionUtils {
	
	String genericError = "O servidor encontrou um erro e não completou sua requisição.";
	
	public void printBusinessError(HttpServletResponse resp,
			Exception e) {
		try {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getOutputStream().print(new JSONParser().objectToJSON(e));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}