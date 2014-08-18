package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.HistoricStatusBean;
import com.gekkobt.dao.HistoricStatusDAO;
import com.gekkobt.dao.db.entity.parser.HistoricStatusEntityParse;


@Service
@Transactional
public class HistoricStatusService {

	@Autowired
	private HistoricStatusDAO historicStatusDAO;


	public List<HistoricStatusBean> findAll() {
		List<HistoricStatusBean> list;

		list = new HistoricStatusEntityParse().entityToBean(historicStatusDAO.findAll());

		return list;
	}
	
	public HistoricStatusBean findPriorityId(Integer id)
			throws Exception {
		HistoricStatusBean bean = new HistoricStatusEntityParse().entityToBean(historicStatusDAO.findById(id));

		return bean;
	}

}