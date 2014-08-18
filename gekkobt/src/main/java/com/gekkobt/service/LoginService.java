package com.gekkobt.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gekkobt.bean.UserBean;
import com.gekkobt.dao.UserDao;
import com.gekkobt.dao.db.entity.parser.UserEntityParse;
import com.gekkobt.entity.UserEntity;
import com.gekkobt.util.Mail;

@Component
public class LoginService {

	@Autowired
	private UserDao userDao;

	UserEntityParse userEntityParse = new UserEntityParse();
	
	String message;
	
	public UserBean searchUser(UserBean userLogin) {
		return userEntityParse.entityToBean(userDao.returnUser(userLogin));
	}
	public UserEntity searchUserById(UserBean userLogin) {
		return userDao.returnUserById(userLogin.getId());
	}
	
	public boolean sendEmail(UserBean userEmail) {

		Mail mail = new Mail();
		List<UserEntity> list = userDao.returnPassword(userEntityParse.beanToEntity(userEmail));
		if (list.size()<1) {
			return false;
		}else {
			mail.sendMail(list.get(0).getUserPassword(), userEmail.getUserEmail());
			return true;
		}
		
	}
	
	
	public String Encryption(String password) {
		String passwordEncryption = null;

		if (null == password)
			return null;

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");

			digest.update(password.getBytes(), 0, password.length());

			passwordEncryption = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordEncryption;
	}
}
