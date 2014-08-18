package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.StatusBean;
import com.gekkobt.entity.StatusEntity;

public class StatusEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public StatusBean entityToBean(StatusEntity entity) {
		if (entity == null) {
			return null;
		}

		StatusBean bean = new StatusBean();

		bean.setId(entity.getId());
		bean.setStatusType(entity.getStatusType());

		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public StatusEntity beanToEntity(StatusBean bean) {
		if (bean == null) {
			return null;
		}

		StatusEntity entity = new StatusEntity();
		
		entity.setId(bean.getId());
		entity.setStatusType(bean.getStatusType());

		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<StatusBean> entityToBean(List<StatusEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<StatusBean> list = new ArrayList<StatusBean>();
		for (StatusEntity entity : listEntity) {
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
	public List<StatusEntity> beanToEntity(List<StatusBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<StatusEntity> list = new ArrayList<StatusEntity>();
		for (StatusBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}