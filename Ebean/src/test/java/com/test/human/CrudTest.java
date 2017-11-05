package com.test.human;

import com.ebean.model.Human;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Query;

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
        Human being = null;

        being = new Human();
        being.setAge(12);
        being.setFirstName("I");
        being.setLastName("be human");
        being.setUserId(1L);
        being.setGender("m");

        EbeanServer server = Ebean.getDefaultServer();
        server.beginTransaction();

        server.save(being);
        server.commitTransaction();

        assertNotNull(being.getAge());
        
        Query<Human> find = server.find(Human.class);
        Human findOne = find.findOne();
        System.out.println(findOne.getAge());
    }

}
