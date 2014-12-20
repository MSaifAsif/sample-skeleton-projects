package com.jpa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.jpa.model.Human;
import com.jpa.util.HibernateUtil;

public class HumanDAO extends GenericHibernateDAO<Human, Serializable> {

	//private Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class); 
	
	public Human getAUserByID(long userID){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class);
		criteria.add(Restrictions.eq("id", userID));
		return (Human) criteria.list().get(0);
	}
	
	public List<Human> getAllusers(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class);
		return findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Human> getAll(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class);
		return ((List<Human>)criteria.list());
	}
	
	
	public List<Human> findByExample(Human exampleInstance) {
		return null;
	}


}