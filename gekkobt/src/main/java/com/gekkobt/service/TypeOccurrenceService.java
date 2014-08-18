package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.TypeOccurrenceBean;
import com.gekkobt.dao.TypeOccurrenceDAO;
import com.gekkobt.dao.db.entity.parser.TypeOccurrenceEntityParse;


@Service
@Transactional
public class TypeOccurrenceService {

	@Autowired
	private TypeOccurrenceDAO typeOccurrenceDAO;

	public List<TypeOccurrenceBean> findAll() {
		List<TypeOccurrenceBean> list;

		list = new TypeOccurrenceEntityParse().entityToBean(typeOccurrenceDAO.findAll());

		return list;
	}
	
	public TypeOccurrenceBean findTypeOccurrenceId(Long id)
			throws Exception {
		TypeOccurrenceBean bean = new TypeOccurrenceEntityParse().entityToBean(typeOccurrenceDAO.findById(id));

		return bean;
	}
}