package com.usermanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.usermanagmenet.model.ErmSecUser;

public class ErmSecUserDaoImpl implements ErmSecUserDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	EntityManager eM;
	

	@Override
	public ErmSecUser findUserByFullNm(String fullName) {
		 EntityManager eM = entityManagerFactory.createEntityManager();
		 
		 ErmSecUser user = eM.createQuery("Select u from ErmSecUser u where u.fullNm=:fullName or u.fullNm:capsFullName", ErmSecUser.class)
				.setParameter("fullName", fullName)
				.setParameter("capsFullName", fullName.toUpperCase())
				.getSingleResult();
	
		return user;
	}

}
