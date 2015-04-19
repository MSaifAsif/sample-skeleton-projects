package com.test;


import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jpa.util.HibernateUtil;

public class TestRunner {
	
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