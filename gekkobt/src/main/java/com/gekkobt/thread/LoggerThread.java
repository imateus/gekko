package com.gekkobt.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gekkobt.enums.Log;
import com.gekkobt.util.Logger;

@Component
@Scope("prototype")
public class LoggerThread extends Thread {

	@Autowired
	private Logger logger;

	private String message;
	private String className;
	private String methodName;
	private Object[] args;
	private Object object;
	private Log log;
	private String userId;
	private String ip;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public void clean() {
		message = null;
		className = null;
		methodName = null;
		args = null;
		object = null;
	}

	@Override
	public void run() {
		try {
			if (log == Log.INFO) {
				logger.info(message, className, methodName, args, userId, ip);
			} else if (log == Log.DEBUG) {
				logger.debug(message, className, methodName, args, userId, ip);
			} else {
				logger.error(message, className, methodName, args,
						(Exception) object, userId, ip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
