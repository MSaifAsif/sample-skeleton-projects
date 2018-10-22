package com.main;

/**
 * refer to {@link HibernateJPATest} for sample test cases
 */


//
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.jpa.dao.HumanDAO;
//import com.jpa.model.Human;
//import com.jpa.util.HibernateUtil;
//
//public class MainRunner {
//
//	public static void main(String[] args) throws Exception {
//
//		final Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//
//			HumanDAO humanDAO = new HumanDAO();
//			humanDAO.setSession(session);
//			Human human = new Human();
//
//			human.setUserID(0);
//			human.setFirstName("Changed Name");
//			human.setLastName("Changed last name");
//			human.setAge(42);
//			human.setGender("Female");
//			System.out.println("Got name with credentials " + human.getUserID());
//
//			humanDAO.makePersistent(human);
//			Human human2 = humanDAO.getAUserByID(0);
//			System.out.println(human2.getFirstName());
//
//		} catch (HibernateException e){
//			e.printStackTrace();
//		} catch (Exception e){
//			e.printStackTrace();
//		} finally {
//			System.out.println("Done !");
//		}
//
//	}
//}