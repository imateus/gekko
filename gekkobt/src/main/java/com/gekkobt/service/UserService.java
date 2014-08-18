package com.gekkobt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.UserBean;
import com.gekkobt.dao.UserDao;
import com.gekkobt.dao.db.entity.parser.UserEntityParse;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<UserBean> findAll() {
		List<UserBean> list;

		list = new UserEntityParse().entityToBean(userDao.findAll());

		return list;
	}

	public UserBean findUserId(Long id) throws Exception {
		UserBean bean = new UserEntityParse()
				.entityToBean(userDao.findById(id));

		return bean;
	}
}