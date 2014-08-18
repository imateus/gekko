package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.HistoricStatusBean;
import com.gekkobt.entity.HistoricStatusEntity;

public class HistoricStatusEntityParse {

	public HistoricStatusBean entityToBean(HistoricStatusEntity entity) {
		if (entity == null) {
			return null;
		}

		HistoricStatusBean bean = new HistoricStatusBean();

		bean.setId(entity.getId());
		bean.setHistoricDateChange(entity.getHistoricDateChange());
		bean.setHistoricJustification(entity.getHistoricJustification());
		bean.setHistoricStatusBean(new StatusEntityParse().entityToBean(entity
				.getHistoricStatusEntity()));
		bean.setIdOccurrenceBean(new OccurrenceEntityParse()
				.entityToBean(entity.getIdOccurrenceEntity()));
		bean.setResponsibleChangeBean(new UserEntityParse().entityToBean(entity
				.getResponsibleChangeEntity()));

		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public HistoricStatusEntity beanToEntity(HistoricStatusBean bean) {
		if (bean == null) {
			return null;
		}

		HistoricStatusEntity entity = new HistoricStatusEntity();

		entity.setId(bean.getId());
		entity.setHistoricDateChange(bean.getHistoricDateChange());
		entity.setHistoricJustification(bean.getHistoricJustification());
		entity.setHistoricStatusEntity(new StatusEntityParse()
				.beanToEntity(bean.getHistoricStatusBean()));
		entity.setIdOccurrenceEntity(new OccurrenceEntityParse()
				.beanToEntity(bean.getIdOccurrenceBean()));
		entity.setResponsibleChangeEntity(new UserEntityParse()
				.beanToEntity(bean.getResponsibleChangeBean()));

		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<HistoricStatusBean> entityToBean(
			List<HistoricStatusEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<HistoricStatusBean> list = new ArrayList<HistoricStatusBean>();
		for (HistoricStatusEntity entity : listEntity) {
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
	public List<HistoricStatusEntity> beanToEntity(List<HistoricStatusBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<HistoricStatusEntity> list = new ArrayList<HistoricStatusEntity>();
		for (HistoricStatusBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}