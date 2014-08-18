package com.gekkobt.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.ProjectBean;
import com.gekkobt.bean.ReportProjectBean;
import com.gekkobt.bean.ReportUserBean;
import com.gekkobt.dao.HistoricStatusDAO;
import com.gekkobt.dao.OccurrenceDAO;
import com.gekkobt.dao.ReportProjectOccurrencesDAO;
import com.gekkobt.dao.UserDao;
import com.gekkobt.dao.db.entity.parser.ProjectEntityParse;
import com.gekkobt.enums.Status;


@Service
@Transactional
public class ReportProjectOccurrencesService {

	@Autowired
	private ReportProjectOccurrencesDAO reportProjectOccurrencesDAO;

	@Autowired
	private UserDao userDao;

	@Autowired
	private OccurrenceDAO occurrenceDAO;

	@Autowired
	private HistoricStatusDAO historicStatusDAO;

	public List<ReportProjectBean> filterReportProject(ProjectBean projectBean) throws ParseException {
		List<ReportProjectBean> listReport = new ArrayList();
		ReportProjectBean reportProjectBean = new ReportProjectBean();
		Long cont = 1L;
		List<Long> list = reportProjectOccurrencesDAO.filterReportProject(new ProjectEntityParse().beanToEntity(projectBean));
		
		
				for (int j = 0; j <= list.size(); j++) {
					if (j==0||j==3||j==6||j==9) {
						reportProjectBean.setQtdError(list.get(j));
					}
					if (j==1||j==4||j==7||j==10) {
						reportProjectBean.setQtdAlterScope(list.get(j));
					}
					if (j==2||j==5||j==8||j==11) {						
						reportProjectBean.setIdStatus((cont));
						reportProjectBean.setQtdRecurrence(list.get(j));
						
						listReport.add(reportProjectBean);
						reportProjectBean = new ReportProjectBean();
						cont += 1L;
					}					
				}
				
				for (ReportProjectBean report : listReport) {
					if (report.getIdStatus() == Status.PENDENTE.getId().intValue()){
						report.setDescriptionStatus(Status.PENDENTE.getStatusType());
					}
					if (report.getIdStatus() == Status.FECHADO.getId().intValue()){
						report.setDescriptionStatus(Status.FECHADO.getStatusType());
					}
					if (report.getIdStatus() == Status.RESOLVIDO.getId().intValue()){
						report.setDescriptionStatus(Status.RESOLVIDO.getStatusType());
					}
					if (report.getIdStatus() == Status.REABERTO.getId().intValue()){
						report.setDescriptionStatus(Status.REABERTO.getStatusType());
					}
				}
				
		return listReport;
	}

	public List<ReportUserBean> filterReport(int id,List<ReportUserBean> listReport) {
		 List<ReportUserBean> returnReport = new ArrayList<ReportUserBean>();
		returnReport = new ArrayList<ReportUserBean>();
		for (ReportUserBean report : listReport) {
			if (report.getResponsibleId() == BigInteger.valueOf(id)) {
				returnReport.add(report);
				break;
			}
		}

		return returnReport;
	}
}
