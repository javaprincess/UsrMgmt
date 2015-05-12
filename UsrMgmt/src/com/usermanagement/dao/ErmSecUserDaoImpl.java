package com.usermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.usermanagement.model.ErmSecUser;
import com.usermanagement.model.ErmSecUserRole;

@Repository
public class ErmSecUserDaoImpl implements ErmSecUserDao {

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	@Override
	public ErmSecUser findUserByFullNm(String fullName) {
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 ErmSecUser user = entityManager.createQuery("Select u from ErmSecUser u where u.fullNm=:fullName or u.fullNm=:capsFullName", ErmSecUser.class)
				.setParameter("fullName", fullName)
				.setParameter("capsFullName", fullName.toUpperCase())
				.getSingleResult();
		 
		 entityManager.close();
	
		return user;
	}
	
	@Override
	public boolean deleteByLoginId(Integer userId) {
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 
		 try {
			 entityManager.getTransaction().begin();
			 
			 ErmSecUser user = entityManager.createQuery("select u from ErmSecUser u where u.userId=:userId", ErmSecUser.class)
				.setParameter("userId", userId)
				.getSingleResult();
		 
			 ErmSecUserRole userRole = entityManager.createQuery("select u from ErmSecUserRole u where u.userId=:userId", ErmSecUserRole.class)
						.setParameter("userId", userId)
						.getSingleResult();
			 
			 entityManager.remove(user);
			 entityManager.remove(userRole);
			 
			 entityManager.getTransaction().commit();
			
		 
		 } catch (Exception e) {
			 
		 }
		 entityManager.close();
	
		return isUserValid();
	}
	
	private boolean isUserValid() {
		return false;
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
