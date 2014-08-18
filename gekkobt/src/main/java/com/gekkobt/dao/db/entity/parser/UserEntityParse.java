package com.gekkobt.dao.db.entity.parser;

import java.util.ArrayList;
import java.util.List;

import com.gekkobt.bean.UserBean;
import com.gekkobt.entity.UserEntity;

public class UserEntityParse {
	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayEntity
	 * @return HolidayBean
	 */

	public UserBean entityToBean(UserEntity entity) {
		if (entity == null) {
			return null;
		}

		UserBean bean = new UserBean();

		bean.setId(entity.getId());
		bean.setUserLogin(entity.getUserLogin());
		bean.setUserPassword(entity.getUserPassword());
		bean.setUserEmail(entity.getUserEmail());
		bean.setUserName(entity.getUserName());
/*		bean.setUserInclusion(new OccurrenceEntityParse().entityToBean(entity
				.getUserInclusion()));
		bean.setUserResponsable(new OccurrenceEntityParse().entityToBean(entity
				.getUserResponsable()));*/

		return bean;
	}

	/**
	 * Convert HolidayEntity to HolidayBean
	 * 
	 * @param HolidayBean
	 * @return HolidayEntity
	 */
	public UserEntity beanToEntity(UserBean bean) {
		if (bean == null) {
			return null;
		}

		UserEntity entity = new UserEntity();

		entity.setId(bean.getId());
		entity.setUserLogin(bean.getUserLogin());
		entity.setUserPassword(bean.getUserPassword());
		entity.setUserEmail(bean.getUserEmail());
		entity.setUserName(bean.getUserName());
		/*entity.setUserInclusion(new OccurrenceEntityParse().beanToEntity(bean
				.getUserInclusion()));
		entity.setUserResponsable(new OccurrenceEntityParse().beanToEntity(bean
				.getUserResponsable()));*/
		
		return entity;
	}

	/**
	 * Convert a list of HolidayEntity to HolidayBean
	 * 
	 * @param List
	 *            <HolidayEntity>
	 * @return List<HolidayBean>
	 */
	public List<UserBean> entityToBean(List<UserEntity> listEntity) {
		if (listEntity == null) {
			return null;
		}

		List<UserBean> list = new ArrayList<UserBean>();
		for (UserEntity entity : listEntity) {
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
	public List<UserEntity> beanToEntity(List<UserBean> listBean) {
		if (listBean == null) {
			return null;
		}

		List<UserEntity> list = new ArrayList<UserEntity>();
		for (UserBean bean : listBean) {
			list.add(beanToEntity(bean));
		}

		return list;
	}
}
