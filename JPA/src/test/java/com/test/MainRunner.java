package com.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.jpa.dao.HumanDAO;
import com.jpa.model.Human;
import com.jpa.util.HibernateUtil;

import static org.junit.Assert.*;

public class MainRunner {
	

	@Before
	public void insertRecord() {

		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			HumanDAO humanDAO = new HumanDAO();
			humanDAO.setSession(session);
			Human human = new Human();

			human.setUserID(0);
			human.setFirstName("Changed Name");
			human.setLastName("Changed last name");
			human.setAge(42);
			human.setGender("Female");

			humanDAO.makePersistent(human);

		} catch (HibernateException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	@Test
	public void testRetrieve() {

		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			HumanDAO humanDAO = new HumanDAO();
			humanDAO.setSession(session);

			Human human2 = humanDAO.getAUserByID(0);
			System.out.println(human2.getFirstName());

		} catch (HibernateException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			HumanDAO humanDAO = new HumanDAO();
			humanDAO.setSession(session);

			Human human2 = humanDAO.getAUserByID(0);
			
			humanDAO.makeTransient(human2);

		} catch (HibernateException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHSQLcon(){
		try{
			final Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			tx.rollback();
		} catch( Exception e ){
			fail(e.getMessage());
		}
	}

}