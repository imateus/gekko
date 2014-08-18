package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.ReportUserBean;
import com.gekkobt.entity.ReportUserEntity;


public class ReportUserEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public ReportUserBean entityToBean(ReportUserEntity entity) {
		if (entity == null) {
			return null;
		}

		ReportUserBean bean = new ReportUserBean();

		bean.setDataChange(entity.getDataChange());
		bean.setQtdFinalizado(entity.getQtdFinalizado());
		bean.setQtdIncluida(entity.getQtdIncluida());
		bean.setQtdPendende(entity.getQtdPendende());
		bean.setResponsibleId(entity.getResponsibleId());
		bean.setResponsibleName(entity.getResponsibleName());

		return bean;
	}
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public ReportUserEntity beanToEntity(ReportUserBean bean) {
		if (bean == null) {
			return null;
		}

		ReportUserEntity entity = new ReportUserEntity();

		entity.setDataChange(bean.getDataChange());
		entity.setQtdFinalizado(bean.getQtdFinalizado());
		entity.setQtdIncluida(bean.getQtdIncluida());
		entity.setQtdPendende(bean.getQtdPendende());
		entity.setResponsibleId(bean.getResponsibleId());
		entity.setResponsibleName(bean.getResponsibleName());
		
		return entity;
	}
	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<ReportUserBean> entityToBean(List<ReportUserEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<ReportUserBean> list = new ArrayList<ReportUserBean>();
		for (ReportUserEntity entity : listEntity) {
			list.add(entityToBean(entity));
		}

		return list;
	}
	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayBean>
	 * @return List<HolidayEntity>
	 */
	public List<ReportUserEntity> beanToEntity(List<ReportUserBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<ReportUserEntity> list = new ArrayList<ReportUserEntity>();
		for (ReportUserBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}