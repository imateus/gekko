package com.gekkobt.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.entity.OccurrenceEntity;

@Repository
public class OccurrenceDAO extends GenericDAO<OccurrenceEntity, Long> {

	@SuppressWarnings("rawtypes")
	List parameters = new ArrayList();

	@SuppressWarnings({ "unchecked" })
	public List<OccurrenceEntity> filterOccurrences(
			OccurrenceFilterBean bean, Integer paginationParm,Long idUserLogged)
			throws ParseException {
		String sQuery = "";
		sQuery = filterWhere(bean, sQuery,idUserLogged);

		TypedQuery<OccurrenceEntity> q = em.createQuery(sQuery,
				OccurrenceEntity.class);

		TypedQuery<OccurrenceEntity> queryFinal = createQuery(q,
				paginationParm);
		return queryFinal.getResultList();

	}

	@SuppressWarnings("unchecked")
	private String filterWhere(OccurrenceFilterBean bean, String sQuery,Long idUserLogged)
			throws ParseException {

		parameters = new ArrayList();
		sQuery += "from OccurrenceEntity o where o.occurrenceDeleted=1";
		String dateMask = "__/__/____";

		if (bean.getIdOccurrence() != null
				&& !"".equals(bean.getIdOccurrence())) {
			sQuery += " AND o.id = ?";
			parameters.add(bean.getIdOccurrence());
		}

		if (bean.getIdProjectOccurrence() != null
				&& !"".equals(bean.getIdProjectOccurrence())) {
			sQuery += " AND o.projectEntity.id = ?";
			parameters.add(bean.getIdProjectOccurrence());
		}

		if (bean.getIdTypeOccurrence() != null
				&& !"".equals(bean.getIdTypeOccurrence())) {
			sQuery += " AND o.typeOccurrenceEntity.id = ?";
			parameters.add(bean.getIdTypeOccurrence());
		}

		if (bean.getIdStatusOccurrence() != null
				&& !"".equals(bean.getIdStatusOccurrence())) {
			sQuery += " AND o.statusEntity.id = ?";
			parameters.add(bean.getIdStatusOccurrence());
		}

		if (bean.getIdUserOccurrence() != null
				&& !"".equals(bean.getIdUserOccurrence())) {
			sQuery += " AND o.occurrenceUserInclusionEntity.id = ?";
			parameters.add(bean.getIdUserOccurrence());
		}

		if (bean.getIdResponsableOccurrence() != null
				&& !"".equals(bean.getIdResponsableOccurrence())) {
			sQuery += " AND o.occurrenceUserResponsibleEntity.id = ?";
			parameters.add(bean.getIdResponsableOccurrence());
		}

		if (bean.getInclusionDateParamFrom() != null
				&& !"".equals(bean.getInclusionDateParamFrom())
				&& !dateMask.equals(bean.getInclusionDateParamFrom())
				|| bean.getInclusionDateParamTo() != null
				&& !"".equals(bean.getInclusionDateParamTo())
				&& !dateMask.equals(bean.getInclusionDateParamTo())) {

			if (bean.getInclusionDateParamFrom() != null
					&& !"".equals(bean.getInclusionDateParamFrom())
					&& !"".equals(bean.getInclusionDateParamTo())
					&& !dateMask.equals(bean.getInclusionDateParamFrom())
					&& !dateMask.equals(bean.getInclusionDateParamTo())) {
				sQuery += " AND o.inclusionDate BETWEEN ? and ?";
				parameters.add(formatDate(bean.getInclusionDateParamFrom()));
				parameters.add(formatDate(bean.getInclusionDateParamTo()));

			} else if (bean.getInclusionDateParamFrom() != null
					&& !"".equals(bean.getInclusionDateParamFrom())
					&& !dateMask.equals(bean.getInclusionDateParamTo())) {
				sQuery += " AND o.inclusionDate >= ?";
				parameters.add(formatDate(bean.getInclusionDateParamFrom()));
			} else {
				sQuery += " AND o.inclusionDate <= ?";
				parameters.add(formatDate(bean.getInclusionDateParamTo()));
			}
		}
		if (bean.getFinalizationDateParamFrom() != null
				&& !"".equals(bean.getFinalizationDateParamFrom())
				&& !dateMask.equals(bean.getFinalizationDateParamFrom())
				|| bean.getFinalizationDateParamTo() != null
				&& !"".equals(bean.getFinalizationDateParamTo())
				&& !dateMask.equals(bean.getFinalizationDateParamTo())) {

			if (bean.getFinalizationDateParamFrom() != null
					&& !"".equals(bean.getFinalizationDateParamFrom())
					&& !dateMask.equals(bean.getFinalizationDateParamFrom())
					&& bean.getFinalizationDateParamTo() != null
					&& !"".equals(bean.getFinalizationDateParamTo())
					&& !dateMask.equals(bean.getFinalizationDateParamTo())) {
				sQuery += " AND o.finalizationDate BETWEEN ? and ?";
				parameters.add(formatDate(bean.getFinalizationDateParamFrom()));
				parameters.add(formatDate(bean.getFinalizationDateParamTo()));

			} else if (bean.getFinalizationDateParamFrom() != null
					&& !"".equals(bean.getFinalizationDateParamFrom())
					&& !dateMask.equals(bean.getFinalizationDateParamTo())) {
				sQuery += " AND o.finalizationDate >= ?";
				parameters.add(formatDate(bean.getFinalizationDateParamFrom()));
			} else {
				sQuery += " AND o.finalizationDate <= ?";
				parameters.add(formatDate(bean.getFinalizationDateParamTo()));
			}
		}
		
		if (parameters.size()>0 || idUserLogged==null) {
			return sQuery;
		}else {
			sQuery += " AND o.occurrenceUserResponsibleEntity.id = ?";
			parameters.add(idUserLogged);
			return sQuery; 
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List<OccurrenceBean> filterUserOccurrences(Long IdUserOccurrence)
			throws ParseException {

		String sQuery = "from OccurrenceEntity o where o.occurrenceDeleted=1";
		List parameters = new ArrayList();
		sQuery += " AND o.occurrenceUserInclusionEntity.id = ?";
		parameters.add(IdUserOccurrence);
		TypedQuery<OccurrenceBean> query = em.createQuery(sQuery,
				OccurrenceBean.class);

		for (int j = 0; j < parameters.size(); j++) {
			query.setParameter(j + 1, parameters.get(j));
		}

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	private TypedQuery createQuery(TypedQuery query, Integer numberPage) {
		if (numberPage != null) {
			query.setFirstResult((numberPage * 20) - 20);
			query.setMaxResults(20);
		}
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

	public Long sizeOfList(OccurrenceFilterBean bean,Long idUserLogged) {

		String sQuery = "select count (*) ";

		try {
			sQuery = filterWhere(bean, sQuery,idUserLogged);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		TypedQuery<Long> q = em.createQuery(sQuery, Long.class);

		Query queryFinal = createQuery(q, null);
		return (Long) queryFinal.getSingleResult();
	}

}
