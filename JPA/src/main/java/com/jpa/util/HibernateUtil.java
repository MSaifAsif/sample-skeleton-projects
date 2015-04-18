package com.jpa.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final Logger log = Logger.getLogger(HibernateUtil.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private static final List<Class<?>> classList = new ArrayList(){{
		add(com.jpa.model.Human.class);
	}};
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		for (Class<?> pojoClass : classList) {
			log.info("Adding annotated class : " + pojoClass.getCanonicalName());
			configuration.addAnnotatedClass(pojoClass);
		}
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
	
	/**
	 * The main utility method to be used to retreive the transaction.
	 * 
	 * @return {@link Transaction} The transaction of the current session
	 */
	public static Transaction getTransaction() throws Exception{
		Session s = getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		tx.setTimeout(10);
		return tx;
		//return getSessionFactory().getCurrentSession().beginTransaction();;
	}
	

	/**
	 * Conveniance method to call by the startup servlet
	 * 
	 */
	public static void initSessionFactory(){
		buildSessionFactory();
	}

}
