package com.gekkobt.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gekkobt.entity.OccurrenceEntity;
import com.gekkobt.entity.ProjectEntity;

@Repository
public class ReportProjectOccurrencesDAO extends
		GenericDAO<OccurrenceEntity, Long> {

	List<String> list = null;

	@SuppressWarnings("unchecked")
	public List<Long> filterReportProject(ProjectEntity projectEntity) throws ParseException {

		
		TypedQuery<OccurrenceEntity> query = null;
		
		List<Long> occurrenceReportsProject = new ArrayList<Long>();

		
		if (projectEntity.getId() != null) {
			long Type = sizeOfList("TypeOccurrenceEntity");
			long Status = sizeOfList("StatusEntity");
			
			for (int i = 1; i <= Status; i++) {
				for (int j = 1; j <= Type; j++) {
					ArrayList parameters = new ArrayList();
					String sQuery = "select count (id) from OccurrenceEntity o where o.occurrenceDeleted=1 AND o.projectEntity.id = ? AND o.statusEntity.id = ? AND typeOccurrenceEntity.id = ?";
					parameters.add(projectEntity.getId());
					parameters.add(new Long(i));
					parameters.add(new Long(j));
					TypedQuery<Long> q = em.createQuery(sQuery, Long.class);
					TypedQuery<Long> queryFinal = createQuery(q, parameters);
					occurrenceReportsProject.addAll(queryFinal.getResultList());
				}

			}
			return occurrenceReportsProject;
		} else {
			return null;
		}

	}

	private TypedQuery createQuery(TypedQuery query, List parameters) {
		for (int j = 0; j < parameters.size(); j++) {
			query.setParameter(j + 1, parameters.get(j));
		}
		return query;
	}
	
	public Long sizeOfList(String typeEntity) {

		TypedQuery<Long> q = em.createQuery("select count (*) from "+ typeEntity, Long.class);

		return (Long) q.getSingleResult();
	}

}
