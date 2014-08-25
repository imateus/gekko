package com.gekkobt.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.gekkobt.bean.UserBean;
import com.gekkobt.enums.Log;
import com.gekkobt.thread.LoggerThread;
import com.gekkobt.util.SpringContextHolder;


public class LogAOP implements MethodBeforeAdvice, AfterReturningAdvice {

	@Autowired(required=true)
	private UserBean user;
	
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {

		try {			
			String className = method.getDeclaringClass().getName();
			String methodName = method.getName();
			log("Starting method", className, methodName,
					method.getParameterTypes(), Log.DEBUG);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		try {

			String className = method.getDeclaringClass().getName();
			String methodName = method.getName();
			log("Finishing method", className, methodName,
					method.getParameterTypes(), Log.DEBUG);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void log(String message) {
		ApplicationContext context = SpringContextHolder
				.getApplicationContext();
		try {
			if (context != null) {
				LoggerThread logger = (LoggerThread) context
						.getBean("loggerThread");
				logger.clean();
				logger.setMessage(message);
				logger.start();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void log(String message, String className, String methodName,
			Object[] args, Log log) {
		ApplicationContext context = SpringContextHolder
				.getApplicationContext();
		try {
			if (context != null) {
				LoggerThread logger = (LoggerThread) context
						.getBean("loggerThread");
				logger.clean();
				logger.setMessage(message);
				logger.setClassName(className);
				logger.setMethodName(methodName);
				logger.setArgs(args);
				logger.setLog(log);
				try{
					logger.setUserId(String.valueOf(user.getId()));
					logger.setIp(user.getUserIp());
				}catch(Exception e){
					logger.setUserId("GEKKO");
					logger.setIp("");
				}
				logger.start();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
