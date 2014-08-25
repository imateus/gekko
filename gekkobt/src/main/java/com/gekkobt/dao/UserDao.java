package com.gekkobt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gekkobt.bean.UserBean;
import com.gekkobt.entity.UserEntity;

@Repository
public class UserDao extends GenericDAO<UserEntity, Long>{

	public UserEntity returnUser(UserBean usuario) {

		if (usuario == null) {
			throw new IllegalArgumentException("Email nÃ£o deve ser nulo");
		}

			TypedQuery<UserEntity> query = em.createQuery(
					"from UserEntity user where user.userLogin = ? and user.userPassword = ?", UserEntity.class);

			query.setParameter(1, usuario.getUserLogin());
			query.setParameter(2, usuario.getUserPassword());
			UserEntity user = null;
			try {
				user = query.getSingleResult();
			} catch (Exception e) {
				return null;
			}
			
			
			return user;
	}

	public UserEntity returnUserById(Long usuario) {
			TypedQuery<UserEntity> query = em.createQuery(
					"from UserEntity user where user.id= ?", UserEntity.class);

			query.setParameter(1, usuario);
			
			return query.getSingleResult();
	}

	public List<UserEntity> returnPassword(UserEntity userEmail) {

		if (userEmail == null) {
			throw new IllegalArgumentException("Email nÃ£o deve ser nulo");
		}

			TypedQuery<UserEntity> query = em.createQuery(
					"from UserEntity user where user.userEmail = ?", UserEntity.class);

			query.setParameter(1, userEmail.getUserEmail());

			return query.getResultList();
	}

}
