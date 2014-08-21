package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.LogBean;
import com.gekkobt.entity.LogEntity;

public class LogEntityParse {
	/**
	 * Convert LogEntity to LogBean
	 * 
	 * @param LogEntity
	 * @return LogBean
	 */

	public LogBean entityToBean(LogEntity entity) {
		if (entity == null) {
			return null;
		}
		
		LogBean bean = new LogBean();
		
		bean.setLogDate(entity.getLogDate());
		bean.setLogDateGlb(entity.getLogDateGlb());
		bean.setLogId(entity.getLogId());
		bean.setLogMessageText(entity.getLogMessageText());
		bean.setLogRequestIpAddr(entity.getLogRequestIpAddr());
		bean.setLogSourceText(entity.getLogSourceText());
		bean.setLogSuccessInd(entity.getLogSucessInd());
		bean.setLogTypeInd(entity.getLogTypeInd());
		bean.setLogUserId(entity.getLogUserId());
		bean.setLogTypeName(entity.getLogTypeInd());
		
		return bean;
	}

	/**
	 * Convert LogBean to LogEntity
	 * 
	 * @param LogBean
	 * @return LogEntity
	 */
	public LogEntity beanToEntity(LogBean bean) {
		if (bean == null) {
			return null;
		}

		LogEntity entity = new LogEntity();
		
		entity.setLogDate(bean.getLogDate());
		entity.setLogDateGlb(bean.getLogDateGlb());
		entity.setLogId(bean.getLogId());
		entity.setLogMessageText(bean.getLogMessageText());
		entity.setLogRequestIpAddr(bean.getLogRequestIpAddr());
		entity.setLogSourceText(bean.getLogSourceText());
		entity.setLogSucessInd(bean.getLogSuccessInd());
		entity.setLogTypeInd(bean.getLogTypeInd());
		entity.setLogUserId(bean.getLogUserId());
		
		return entity;
	}

	/**
	 * Convert a list of LogEntity to LogBean
	 * 
	 * @param List
	 *            <LogEntity>
	 * @return List<LogBean>
	 */
	public List<LogBean> entityToBean(List<LogEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}
		
		List<LogBean> list = new ArrayList<LogBean>();
		for (LogEntity entity : listEntity) {
			list.add(entityToBean(entity));
		}
		
		return list;
	}

	/**
	 * Convert a list of LogEntity to LogBean
	 * 
	 * @param List
	 *            <LogBean>
	 * @return List<LogEntity>
	 */
	public List<LogEntity> beanToEntity(List<LogBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<LogEntity> list = new ArrayList<LogEntity>();
		for (LogBean bean : listBean) {
			list.add(beanToEntity(bean));
		}
		
		return list;
	}

}
