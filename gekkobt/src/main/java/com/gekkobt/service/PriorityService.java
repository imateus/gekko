package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.PriorityBean;
import com.gekkobt.dao.PriorityDAO;
import com.gekkobt.dao.db.entity.parser.PriorityEntityParse;


@Service
@Transactional
public class PriorityService {

	@Autowired
	private PriorityDAO priorityDAO;
	


	public List<PriorityBean> findAll() {
		List<PriorityBean> list;

		list = new PriorityEntityParse().entityToBean(priorityDAO.findAll());

		return list;
	}
	
	public PriorityBean findPriorityId(Integer id)
			throws Exception {
		PriorityBean bean = new PriorityEntityParse().entityToBean(priorityDAO.findById(id));

		return bean;
	}
}