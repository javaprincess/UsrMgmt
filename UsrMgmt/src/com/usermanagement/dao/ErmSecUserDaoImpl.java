package com.usermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.usermanagement.model.ErmSecUser;

@Repository
public class ErmSecUserDaoImpl implements ErmSecUserDao {

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	@Override
	public ErmSecUser findUserByFullNm(String fullName) {
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 ErmSecUser user = entityManager.createQuery("Select u from ErmSecUser u where u.fullNm=:fullName or u.fullNm:capsFullName", ErmSecUser.class)
				.setParameter("fullName", fullName)
				.setParameter("capsFullName", fullName.toUpperCase())
				.getSingleResult();
		 
		 entityManager.close();
	
		return user;
	}
	
	  public void setEntityManagerFactory(EntityManagerFactory eMF) {
	    	this.entityManagerFactory = eMF;
	    }
		
	    public EntityManagerFactory getEntityManagerFactory() {
	    	return this.entityManagerFactory;
	    }
	    
		public EntityManager getEntityManager() {
			return this.entityManager;

		}
		
		public void setEntityManager(EntityManager eM) {
			this.entityManager = eM;
		}

}
