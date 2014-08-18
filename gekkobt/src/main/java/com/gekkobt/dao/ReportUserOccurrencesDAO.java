package com.gekkobt.dao;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gekkobt.entity.ReportUserEntity;

@Repository
public class ReportUserOccurrencesDAO extends GenericDAO<ReportUserEntity, BigInteger> {

	@SuppressWarnings("unchecked")
	public List<ReportUserEntity> filterReportOccurrencesUser()
			throws ParseException {
		
		Query query = em.createNativeQuery("call procRepotUser()", ReportUserEntity.class); 
		  
		/*
		 *Procedure BD - mysql 
		TypedQuery<OccurrenceEntity> query = null;
		TypedQuery queryFinal = null;*/
			/*	use test;
		DELIMITER $$
		create procedure procRepotUser()
		BEGIN
		 select max(dataChange) as dataChange,
				responsibleName,
				responsibleId,
				max(qtdPendende) as qtdPendende,
				max(qtdFinalizado) as qtdFinalizado,
				max(qtdIncluida) as qtdIncluida
		from (
		 select max(h.HISTORIC_DATE_CHANGE) as dataChange,
				u.user_name as responsibleName,	
				h.HISTORIC_RESPONSIBLE_CHANGE as responsibleId, 
		 		count(h.historic_status) as qtdPendende,
				0 as qtdFinalizado,
				0 as qtdIncluida
		    from test.tb_historic_status h
			inner join test.tb_user u
			on u.id_user = h.HISTORIC_RESPONSIBLE_CHANGE
		   where h.historic_status = 1
		group by h.HISTORIC_RESPONSIBLE_CHANGE, h.historic_status
		union all
		 select max(HISTORIC_DATE_CHANGE) as dataChange, 
				u.user_name as responsibleName,		
				HISTORIC_RESPONSIBLE_CHANGE as responsibleId, 
		 		0 as qtdPendende,
				count(h.historic_status) as qtdFinalizado,
				0 as qtdIncluida
		    from test.tb_historic_status h
			inner join test.tb_user u
			on u.id_user = h.HISTORIC_RESPONSIBLE_CHANGE
		   where h.historic_status = 3
		group by h.HISTORIC_RESPONSIBLE_CHANGE, h.historic_status
		union all
		  select null as dataChange,
				 u.user_name as responsibleName,	
				 o.occurrence_user_inclusion  as responsibleId, 
		 		 0 as qtdPendende,
				 0 as qtdFinalizado,
		         count(id_occurrence) as qtdIncluida
		    from test.tb_occurrence o
			inner join test.tb_user u
			on u.id_user = o.occurrence_user_inclusion
		group by o.occurrence_user_inclusion) t
		group by responsibleId;
		END $$ 
		*/
		return query.getResultList();
	}

}
