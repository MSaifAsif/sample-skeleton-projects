package com.test.insertion;

import com.jpa.dao.HumanDAO;
import com.jpa.model.Human;
import com.jpa.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class InsertionTest {

    private static final Logger log = Logger.getLogger(InsertionTest.class);

    @BeforeClass
    public static void init() {
        // For full DEBUG mode, uncomment the following line
        // BasicConfigurator.configure();
    }

    @Test
    public void testInsertFetch() {
        try {
            final Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            HumanDAO humanDAO = new HumanDAO();
            humanDAO.setSession(session);
            Human aPerson = new Human();

            aPerson.setUserID(0);
            aPerson.setFirstName("Frank");
            aPerson.setLastName("Bob");
            aPerson.setAge(42);
            aPerson.setGender("Male");
            humanDAO.makePersistent(aPerson);
            log.info("Inserted human into table ..... ");

            // Now attempt to fetch this record with ID
            log.info("Fetching inserted user record from DB ...... ");
            Human human2 = humanDAO.getAUserByID(0);
            log.info("Got user with name " + human2.getFirstName());

            tx.rollback();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiInsertFetchSameTransaction() {
        try {
            final Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            HumanDAO humanDAO = new HumanDAO();

            for (int i = 0; i < 15; i++) {
                humanDAO.setSession(session);
                Human aPerson = new Human();
                aPerson.setUserID(i);
                aPerson.setFirstName("Frank" + i);
                aPerson.setLastName("Bob" + i);
                aPerson.setAge(42);
                aPerson.setGender("Male");
                humanDAO.makePersistent(aPerson);
                log.info("Inserted human into table ..... ");
            }

            // Now attempt to fetch this record with ID
            log.info("Fetching inserted user record from DB ...... ");
            Human human2 = humanDAO.getAUserByID(0);
            log.info("Got user with name " + human2.getFirstName());

            tx.rollback();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultiInsertFetchUniqueTransaction() {
        for (int i = 0; i < 15; i++) {
            try {
                final Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                HumanDAO humanDAO = new HumanDAO();
                humanDAO.setSession(session);
                Human aPerson = new Human();
                aPerson.setUserID(i);
                aPerson.setFirstName("Frank" + i);
                aPerson.setLastName("Bob" + i);
                aPerson.setAge(42);
                aPerson.setGender("Male");
                humanDAO.makePersistent(aPerson);
                log.info("Inserted human into table ..... ");

                // Now attempt to fetch this record with ID
                log.info("Fetching inserted user record from DB ...... ");
                Human human2 = humanDAO.getAUserByID(i);
                log.info("Got user with name " + human2.getFirstName());

                tx.rollback();
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }

}
