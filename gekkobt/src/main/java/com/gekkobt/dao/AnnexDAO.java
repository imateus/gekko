package com.gekkobt.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gekkobt.entity.AnnexEntity;

@Repository
public class AnnexDAO extends GenericDAO<AnnexEntity, Long> {


		List<String> list = null;

		@SuppressWarnings("unchecked")
		public List<AnnexEntity> filterAnnex(AnnexEntity entity)
				throws ParseException {

			@SuppressWarnings("unused")
			TypedQuery<AnnexEntity> query = null;
			String sQuery = "from AnnexEntity o where o.annexDeleted=1";

			@SuppressWarnings("rawtypes")
			List parameters = new ArrayList();
			
				sQuery += " AND o.occurrenceEntity.id = ?";
				
				parameters.add(entity.getOccurrenceEntity().getId());
				
			
			
			TypedQuery<AnnexEntity> q = em.createQuery(sQuery,
					AnnexEntity.class);
			TypedQuery queryFinal = createQuery(q, parameters);
			return queryFinal.getResultList();
		}

		private TypedQuery createQuery(TypedQuery query, List parameters) {
			for (int j = 0; j < parameters.size(); j++) {
				query.setParameter(j + 1, parameters.get(j));
			}
			return query;
		}

	}


