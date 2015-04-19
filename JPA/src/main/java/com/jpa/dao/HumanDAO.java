package com.jpa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.jpa.model.Human;

public class HumanDAO extends GenericHibernateDAO<Human, Serializable> {

	//private Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class); 
	
	public Human getAUserByID(long userID){
		return findByCriteria( Restrictions.eq("id", userID) ).get(0);
	}
	
	public List<Human> getAllusers(){
		return findAll();
	}
	
	public List<Human> findByExample(Human exampleInstance) {
		return null;
	}


}