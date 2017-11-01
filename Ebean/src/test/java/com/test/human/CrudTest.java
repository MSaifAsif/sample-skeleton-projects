package com.test.human;

import com.ebean.model.Human;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author saifasif
 */
public class CrudTest {


    @Test
    public void insert_via_server() {
        BasicConfigurator.configure();
        Human being;

        being = new Human();
        being.setAge(12);
        being.setFirstName("I");
        being.setLastName("be human");
        being.setGender("m");

        EbeanServer server = Ebean.getDefaultServer();
        server.save(being);

        assertNotNull(being.getUserId());
    }

}
