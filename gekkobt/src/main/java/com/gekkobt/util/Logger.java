package com.gekkobt.util;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.UserBean;
import com.gekkobt.dao.LogDAO;
import com.gekkobt.entity.LogEntity;
import com.gekkobt.entity.UserEntity;
import com.gekkobt.enums.Log;
import com.gekkobt.environment.EnvironmentVariables;

@Service
@Transactional
public class Logger {

	@Autowired
	private UserBean user;

	public Logger() {
		logger4j = org.apache.log4j.Logger.getRootLogger();
	}

	@Autowired
	private LogDAO dao;

	private org.apache.log4j.Logger logger4j;

	public void info(String message) {
		info(message, getUser(), getIP());
	}

	public void info(String message, String userId, String ip) {
		info(message, null, null, null, userId, ip);
	}

	public void info(String message, String className, String methodName,
			Object[] args, String userId, String ip) {
		log(message, processText(className, methodName, args, Log.INFO, null),
				Log.INFO, userId, ip);
	}

	public void debug(String message, String className, String methodName,
			Object[] args, String userId, String ip) {
		log(message, processText(className, methodName, args, Log.DEBUG, null),
				Log.DEBUG, userId, ip);
	}

	public void error(String message, String className, String methodName,
			Object[] args, Exception ex) {
		error(message, className, methodName, args, ex, getUser(), getIP());
	}

	public void error(String message, String className, String methodName,
			Object[] args, Exception ex, String userId, String ip) {
		log(message, processText(className, methodName, args, Log.ERROR, ex),
				Log.ERROR, userId, ip);
	}

	public String processText(String className, String methodName,
			Object[] args, Log log, Exception ex) {
		StringBuffer text = new StringBuffer();

		if (className != null) {
			text.append(className + ".");
		}

		if (methodName != null) {
			text.append(methodName);
		}
		if (args != null && args.length > 0) {
			text.append("(");
			for (Object object : args) {
				if (object != null) {
					text.append(object.toString().replaceAll("class", "")
							.replaceAll("interface", "").replaceAll(" ", ""));
					text.append(", ");
				}
			}
			try {
				text.replace(text.length() - 2, text.length() + 1, ")");
			} catch (Exception e) {
			}
		}

		if (ex != null && ex.getMessage() != null) {
			String cause = null;
			if (ex.getCause() != null) {
				cause = ex.getCause().toString();
			}
			text.append("[EXCEPTION]" + ex.getMessage().toString() + " "
					+ "Cause:" + cause + "[/EXCEPTION]");
		}

		return text.toString();
	}

	public void log(String message, String text, Log log, String userId,
			String ip) {
		UserEntity  userEntity = new UserEntity();
		userEntity.setId(Long.parseLong(userId));
		LogEntity entity = new LogEntity();

		entity.setLogMessageText(message);
		entity.setUserEntity(userEntity);
		entity.setLogRequestIpAddr(ip);
		entity.setLogSourceText(text);
		entity.setLogDate(new Timestamp(new java.util.Date().getTime()));
		entity.setLogTypeInd(log.getValue());
		try {
			entity.setLogTypeInd(log.getValue());
			logger4j.debug("[MESSAGE]" + message + "[/MESSAGE] :: [TEXT]"
					+ text + "[/TEXT]");
			dao.save(entity);
		} catch (Exception e) {
			logger4j.info("[MESSAGE]" + message + "[/MESSAGE] :: [TEXT]" + text
					+ "[/TEXT]");
			logger4j.error("Não foi possível salvar o log.", e);
		}
	}

	public String getUser() {
		try {
			if (user == null || user != null
					&& (user.getUserId() == null || user.getUserId() == ""))
				return "DASH";
			else
				return user.getUserId();
		} catch (Exception e) {
			return "DASH";
		}
	}

	public String getIP() {
		try {
			if (user == null || user != null
					&& (user.getUserIp() == null || user.getUserIp() == ""))
				return EnvironmentVariables.getServerIP();
			else
				return user.getUserIp();
		} catch (Exception e) {
			return "DASH";
		}
	}
}