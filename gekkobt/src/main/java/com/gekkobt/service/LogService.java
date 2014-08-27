package com.gekkobt.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.LogBean;
import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.dao.LogDAO;
import com.gekkobt.dao.db.entity.parser.LogEntityParse;
import com.gekkobt.dao.db.entity.parser.OccurrenceEntityParse;
import com.gekkobt.entity.LogEntity;
import com.gekkobt.entity.OccurrenceEntity;

@Service
@Transactional
public class LogService {

@Autowired
private LogDAO logDAO;

public List<LogBean> findAll() {
		
	List<LogBean> list;

	list = new LogEntityParse().entityToBean(logDAO.findAll());

	return list;
	
	}
	
public List<LogBean> filterLog(String initialDate, String endDate,
		String userId) {
	
	List<LogEntity> list = null;
	try {
		list = logDAO.filterLog(initialDate, endDate, userId);
	} catch (ParseException e) {
		e.printStackTrace();
	}

	return new LogEntityParse().entityToBean(list);
	
	}

}