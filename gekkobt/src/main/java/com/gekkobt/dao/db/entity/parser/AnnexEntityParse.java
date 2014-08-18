package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.AnnexBean;
import com.gekkobt.entity.AnnexEntity;

public class AnnexEntityParse {

	public AnnexBean entityToBean(AnnexEntity entity) {
		if (entity == null) {
			return null;
		}

		AnnexBean bean = new AnnexBean();

		bean.setId(entity.getId());
		bean.setFileName(entity.getFileName());
		bean.setFilePath(entity.getFilePath());
		bean.setInclusionDate(entity.getInclusionDate());
		bean.setAnnexDeleted(entity.getAnnexDeleted());
		bean.setFileExtension(entity.getFileExtension());
		bean.setOccurrenceBean(new OccurrenceEntityParse().entityToBean(entity.getOccurrenceEntity()));
		bean.setUserBean(new UserEntityParse().entityToBean(entity.getUserEntity()));


		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public AnnexEntity beanToEntity(AnnexBean bean) {
		if (bean == null) {
			return null;
		}

		AnnexEntity entity = new AnnexEntity();

		entity.setId(bean.getId());
		entity.setFileName(bean.getFileName());
		entity.setFilePath(bean.getFilePath());
		entity.setInclusionDate(bean.getInclusionDate());
		entity.setAnnexDeleted(bean.getAnnexDeleted());
		entity.setFileExtension(bean.getFileExtension());
		entity.setOccurrenceEntity(new OccurrenceEntityParse().beanToEntity(bean.getOccurrenceBean()));
		entity.setUserEntity(new UserEntityParse().beanToEntity(bean.getUserBean()));
		
		
		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<AnnexBean> entityToBean(
			List<AnnexEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<AnnexBean> list = new ArrayList<AnnexBean>();
		for (AnnexEntity entity : listEntity) {
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
	public List<AnnexEntity> beanToEntity(List<AnnexBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<AnnexEntity> list = new ArrayList<AnnexEntity>();
		for (AnnexBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}