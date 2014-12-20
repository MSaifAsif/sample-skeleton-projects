package com.jpa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jpa.model.Human;

/**
 * 
 * @author msaif
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Get hte session Factory object from configuration. Use annotation in classes to avoid XML
	 * @author msaif
	 * @return {@link SessionFactory}
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			/*SessionFactory sessionFactory = new AnnotationConfiguration()
        	.addAnnotatedClass(com.jpa.model.Human.class)
        	.buildSessionFactory();
        	return sessionFactory;*/
			System.out.println("Creating session Factory");
			//MemoryHSQLDB.getInstance();
			Configuration configuration = new Configuration();    
			configuration.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()    
			.applySettings(configuration.getProperties())
			.buildServiceRegistry();    
			return configuration
					.addPackage("com.jpa.model")
					.addAnnotatedClass(Human.class)
					.buildSessionFactory(serviceRegistry);

		}
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session beginTransaction(){
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		System.out.println("[ =============================================== ]");
		System.out.println("[ ============== Begin Transaction ============== ]");
		System.out.println("[ =============================================== ]");
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
		System.out.println("[ =============================================== ]");
		System.out.println("[ ============== Commit Transaction ============= ]");
		System.out.println("[ =============================================== ]");
	}

	public static void rollbackTransaction(){
		HibernateUtil.getSession().getTransaction().rollback();
		System.out.println("[ =============================================== ]");
		System.out.println("[ ============== Rollback Transaction =========== ]");
		System.out.println("[ =============================================== ]");
	}

	public static void closeSession() {
		HibernateUtil.getSession().close();
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.getCurrentSession();
		return hibernateSession;
	}
}