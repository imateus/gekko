package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.ProjectBean;
import com.gekkobt.dao.ProjectDAO;
import com.gekkobt.dao.db.entity.parser.ProjectEntityParse;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public List<ProjectBean> findAll() {
		List<ProjectBean> list;

		list = new ProjectEntityParse().entityToBean(projectDAO.findAll());

		return list;
	}
	
	public ProjectBean findProjectId(Long id)
			throws Exception {
		ProjectBean bean = new ProjectEntityParse().entityToBean(projectDAO.findById(id));

		return bean;
	}
}