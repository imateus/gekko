package com.gekkobt.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.ReportUserBean;
import com.gekkobt.dao.HistoricStatusDAO;
import com.gekkobt.dao.OccurrenceDAO;
import com.gekkobt.dao.ReportUserOccurrencesDAO;
import com.gekkobt.dao.UserDao;
import com.gekkobt.dao.db.entity.parser.ReportUserEntityParse;
import com.gekkobt.entity.ReportUserEntity;

@Service
@Transactional
public class ReportUserOccurrencesService {

	@Autowired
	private ReportUserOccurrencesDAO reportUserOccurrencesDAO;

	@Autowired
	private UserDao userDao;

	@Autowired
	private OccurrenceDAO occurrenceDAO;

	@Autowired
	private HistoricStatusDAO historicStatusDAO;

	public List<ReportUserBean> filterReportUser() throws ParseException {

		List<ReportUserEntity> list = reportUserOccurrencesDAO
				.filterReportOccurrencesUser();

		return new ReportUserEntityParse().entityToBean(list);
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
