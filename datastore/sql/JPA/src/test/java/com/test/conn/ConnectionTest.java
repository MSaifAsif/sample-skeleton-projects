package com.test.conn;

import com.jpa.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ConnectionTest {

    @BeforeClass
    public static void init() {
        // For full DEBUG mode, uncomment the following line
        // BasicConfigurator.configure();
    }

    @Test
    public void testHSQLcon() {
        try {
            final Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            tx.rollback();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}