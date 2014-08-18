package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.StatusBean;
import com.gekkobt.dao.StatusDAO;
import com.gekkobt.dao.db.entity.parser.StatusEntityParse;

@Service
@Transactional
public class StatusService {

	@Autowired
	private StatusDAO statusDAO;

	public List<StatusBean> findAll() {
		List<StatusBean> list;

		list = new StatusEntityParse().entityToBean(statusDAO.findAll());

		return list;
	}
}