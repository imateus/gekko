package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.TypeOccurrenceBean;
import com.gekkobt.entity.TypeOccurrenceEntity;

public class TypeOccurrenceEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public TypeOccurrenceBean entityToBean(TypeOccurrenceEntity entity) {
		if (entity == null) {
			return null;
		}

		TypeOccurrenceBean bean = new TypeOccurrenceBean();

		bean.setId(entity.getId());
		bean.setOccurenceType(entity.getOccurenceType());
		/*bean.setTypeoccurrence(new OccurrenceEntityParse().entityToBean(entity
				.getTypeoccurrence()));
		*/


		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public TypeOccurrenceEntity beanToEntity(TypeOccurrenceBean bean) {
		if (bean == null) {
			return null;
		}

		TypeOccurrenceEntity entity = new TypeOccurrenceEntity();

		entity.setId(bean.getId());
		entity.setOccurenceType(bean.getOccurenceType());
/*		entity.setTypeoccurrence(new OccurrenceEntityParse().beanToEntity(bean
				.getTypeoccurrence()));*/
		
		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<TypeOccurrenceBean> entityToBean(
			List<TypeOccurrenceEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<TypeOccurrenceBean> list = new ArrayList<TypeOccurrenceBean>();
		for (TypeOccurrenceEntity entity : listEntity) {
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
	public List<TypeOccurrenceEntity> beanToEntity(
			List<TypeOccurrenceBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<TypeOccurrenceEntity> list = new ArrayList<TypeOccurrenceEntity>();
		for (TypeOccurrenceBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}