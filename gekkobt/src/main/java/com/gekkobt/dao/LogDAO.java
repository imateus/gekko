package com.gekkobt.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.entity.LogEntity;
import com.gekkobt.entity.OccurrenceEntity;

@Repository
public class LogDAO extends GenericDAO<LogEntity, Long> {

	@SuppressWarnings("rawtypes")
	List parameters = new ArrayList();
	
	public List<LogEntity> filterLog(String initialDate, String endDate,
			String userId)
			throws ParseException {
		String sQuery = "";
		sQuery = filterWhere(sQuery, initialDate, endDate, userId);

		TypedQuery<LogEntity> q = em.createQuery(sQuery,
				LogEntity.class);

		@SuppressWarnings("unchecked")
		TypedQuery<LogEntity> queryFinal = createQuery(q);
		return queryFinal.getResultList();
	}

	@SuppressWarnings("unchecked")
	private String filterWhere(String sQuery, String initialDate, String endDate,
			String userId)
			throws ParseException {

		parameters = new ArrayList<String>();
		sQuery += "from LogEntity o where 1=1";
		String dateMask = "__/__/____";

		if (userId != null
				&& !"".equals(userId)) {
			sQuery += " AND o.userEntity.id = ?";
			parameters.add(Long.parseLong(userId));
		}

		if (initialDate != null
				&& !"".equals(initialDate) 
				&& !dateMask.equals(initialDate) || endDate != null 
				&& !"".equals(endDate) 
				&& !dateMask.equals(endDate)) {

			if (initialDate != null
					&& !"".equals(initialDate)
					&& !"".equals(endDate)
					&& !dateMask.equals(initialDate)
					&& !dateMask.equals(endDate)) {
				sQuery += " AND o.logDate BETWEEN ? and ?";
				parameters.add(formatDate(initialDate));
				parameters.add(formatDate(endDate));

			} else if (initialDate != null
					&& !"".equals(initialDate)
					&& !dateMask.equals(endDate)) {
				sQuery += " AND o.logDate >= ?";
				parameters.add(formatDate(initialDate));
			} else {
				sQuery += " AND o.logDate <= ?";
				parameters.add(formatDate(endDate));
			}
		}
			return sQuery; 	
	}

	@SuppressWarnings("rawtypes")
	private TypedQuery createQuery(TypedQuery query) {

		for (int j = 0; j < parameters.size(); j++) {
			query.setParameter(j + 1, parameters.get(j));
		}
		return query;
	}

	public Date formatDate(String dateString) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date formatedDate = new java.sql.Date(format.parse(dateString)
				.getTime());

		return formatedDate;
	}

}
