package com.gekkobt.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gekkobt.bean.LogBean;
import com.gekkobt.dao.db.entity.parser.LogEntityParse;
import com.gekkobt.entity.LogEntity;

@Repository
public class LogDAO extends GenericDAO<LogEntity, Long> {

	public List<LogBean> findLog(String initialDate, String endDate, String userId) {

		List<LogEntity> listEntity = null;
		try {

			String qlString = "FROM LogEntity LOG where LOG.logDate BETWEEN :initialDate AND :endDate and LOG.logTypeInd != 'D'";

			if (!"TODOS".equalsIgnoreCase(userId.toUpperCase()))
				qlString = qlString + " and LOG.logUserId = :userId ";

		
			TypedQuery<LogEntity> query = em.createQuery(qlString,
					LogEntity.class);

			if (!"TODOS".equalsIgnoreCase(userId.toUpperCase()))
				query.setParameter("userId", userId);
			


			query.setParameter("initialDate", initialDate);
			query.setParameter("endDate", endDate);

			listEntity = query.getResultList();
			
			return new LogEntityParse().entityToBean(listEntity);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return new ArrayList<LogBean>();
	}

	public List<String> findUserLog() {

		TypedQuery<String> query = em.createQuery(
				"SELECT DISTINCT log.logUserId  FROM LogEntity log ",
				String.class);

		List<String> list = query.getResultList();
		return list;
	}

	public List<String> findTypeIndLog() {

		TypedQuery<String> query = em.createQuery(
				"SELECT DISTINCT log.logTypeInd  FROM LogEntity log ",
				String.class);

		List<String> list = query.getResultList();
		return list;
	}

}
