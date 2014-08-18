package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.PriorityBean;
import com.gekkobt.entity.PriorityEntity;

public class PriorityEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public PriorityBean entityToBean(PriorityEntity entity) {
		if (entity == null) {
			return null;
		}

		PriorityBean bean = new PriorityBean();

		bean.setPriorityType(entity.getPriorityType());
		bean.setId(entity.getId());
	/*	bean.setPriority(new OccurrenceEntityParse().entityToBean(entity
				.getPriority()));*/

		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public PriorityEntity beanToEntity(PriorityBean bean) {
		if (bean == null) {
			return null;
		}

		PriorityEntity entity = new PriorityEntity();

		entity.setId(bean.getId());
		entity.setPriorityType(bean.getPriorityType());
		/*entity.setPriority(new OccurrenceEntityParse().beanToEntity(bean
				.getPriority()));*/

		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<PriorityBean> entityToBean(List<PriorityEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<PriorityBean> list = new ArrayList<PriorityBean>();
		for (PriorityEntity entity : listEntity) {
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
	public List<PriorityEntity> beanToEntity(List<PriorityBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<PriorityEntity> list = new ArrayList<PriorityEntity>();
		for (PriorityBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}