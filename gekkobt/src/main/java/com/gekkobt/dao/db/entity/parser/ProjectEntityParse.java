package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.ProjectBean;
import com.gekkobt.entity.ProjectEntity;

public class ProjectEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public ProjectBean entityToBean(ProjectEntity entity) {
		if (entity == null) {
			return null;
		}

		ProjectBean bean = new ProjectBean();

		bean.setId(entity.getId());
		bean.setProjectClient(entity.getProjectClient());
		bean.setProjectName(entity.getProjectName());
		/*bean.setProject(new OccurrenceEntityParse().entityToBean(entity
				.getProject()));*/
		return bean;

	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public ProjectEntity beanToEntity(ProjectBean bean) {
		if (bean == null) {
			return null;
		}

		ProjectEntity entity = new ProjectEntity();

		entity.setId(bean.getId());
		entity.setProjectClient(bean.getProjectClient());
		entity.setProjectName(bean.getProjectName());
/*		entity.setProject(new OccurrenceEntityParse().beanToEntity(bean
				.getProject()));*/
		
		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<ProjectBean> entityToBean(List<ProjectEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<ProjectBean> list = new ArrayList<ProjectBean>();
		for (ProjectEntity entity : listEntity) {
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
	public List<ProjectEntity> beanToEntity(List<ProjectBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<ProjectEntity> list = new ArrayList<ProjectEntity>();
		for (ProjectBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}
