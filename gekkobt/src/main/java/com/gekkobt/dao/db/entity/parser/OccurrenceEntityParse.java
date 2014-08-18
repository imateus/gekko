package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.entity.OccurrenceEntity;

public class OccurrenceEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public OccurrenceBean entityToBean(OccurrenceEntity entity) {
		if (entity == null) {
			return null;
		}

		OccurrenceBean bean = new OccurrenceBean();

		bean.setId(entity.getId());
		bean.setFinalizationDate(entity.getFinalizationDate());
		bean.setInclusionDate(entity.getInclusionDate());
		bean.setOccurrenceTitle(entity.getOccurrenceTitle());
		bean.setOccurrenceDescription(entity.getOccurrenceDescription());
		bean.setOccurrenceDeleted(entity.getOccurrenceDeleted());
		bean.setProjectBean(new ProjectEntityParse().entityToBean(entity
				.getProjectEntity()));
		bean.setPriorityBean(new PriorityEntityParse().entityToBean(entity
				.getPriorityEntity()));
		bean.setStatusBean(new StatusEntityParse().entityToBean(entity
				.getStatusEntity()));
		bean.setTypeOccurrenceBean(new TypeOccurrenceEntityParse()
				.entityToBean(entity.getTypeOccurrenceEntity()));
		bean.setOccurrenceUserInclusionBean(new UserEntityParse()
				.entityToBean(entity.getOccurrenceUserInclusionEntity()));
		bean.setOccurrenceUserResponsibleBean(new UserEntityParse()
				.entityToBean(entity.getOccurrenceUserResponsibleEntity()));

		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public OccurrenceEntity beanToEntity(OccurrenceBean bean) {
		if (bean == null) {
			return null;
		}

		OccurrenceEntity entity = new OccurrenceEntity();

		entity.setId(bean.getId());
		entity.setFinalizationDate(bean.getFinalizationDate());
		entity.setInclusionDate(bean.getInclusionDate());
		entity.setOccurrenceTitle(bean.getOccurrenceTitle());
		entity.setOccurrenceDescription(bean.getOccurrenceDescription());
		entity.setOccurrenceDeleted(bean.getOccurrenceDeleted());
		entity.setProjectEntity(new ProjectEntityParse().beanToEntity(bean
				.getProjectBean()));
		entity.setPriorityEntity(new PriorityEntityParse().beanToEntity(bean
				.getPriorityBean()));
		entity.setStatusEntity(new StatusEntityParse().beanToEntity(bean
				.getStatusBean()));
		entity.setTypeOccurrenceEntity(new TypeOccurrenceEntityParse()
				.beanToEntity(bean.getTypeOccurrenceBean()));
		entity.setOccurrenceUserInclusionEntity(new UserEntityParse()
				.beanToEntity(bean.getOccurrenceUserInclusionBean()));
		entity.setOccurrenceUserResponsibleEntity(new UserEntityParse()
				.beanToEntity(bean.getOccurrenceUserResponsibleBean()));

		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<OccurrenceBean> entityToBean(List<OccurrenceEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<OccurrenceBean> list = new ArrayList<OccurrenceBean>();
		for (OccurrenceEntity entity : listEntity) {
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
	public List<OccurrenceEntity> beanToEntity(List<OccurrenceBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<OccurrenceEntity> list = new ArrayList<OccurrenceEntity>();
		for (OccurrenceBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}