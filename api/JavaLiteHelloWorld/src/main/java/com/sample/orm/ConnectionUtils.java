package com.sample.orm;

import org.apache.log4j.Logger;
import org.javalite.activejdbc.Base;

/**
 * Set of utility functions to interact with the database
 *
 * @author saifasif
 */
public class ConnectionUtils {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String connString = "jdbc:mysql://192.168.1.106/test";
    private static final String userName = "udb";
    private static final String passWord = "udb";

    private static final Logger log = Logger.getLogger(ConnectionUtils.class);

    private ConnectionUtils() {

    }

    /**
     * Open a connection to the underlying database
     */
    public static void openConnection() {
        log.debug("Attempting to get connection ... ");
        Base.open(driver, connString, userName, passWord);
        log.debug("Got connection ... ");
    }

    /**
     * Create an entity and persist it into the database
     *
     * @param name
     * @param age
     * @param gender
     */
    public static void createEntity(String name, int age, String gender) {
        log.debug("Attempting to create a Person entity");
        PersonModel personModel = new PersonModel();
        personModel.set("name", name);
        personModel.set("age", age);
        personModel.set("gender", gender);
        personModel.saveIt();
        log.debug("Saved entity .... ");
    }

    /**
     * Find by name
     *
     * @param name
     * @return {@link PersonModel} matching the criterea
     */
    public static PersonModel selectPersonByName(String name) {
        return PersonModel.findFirst("name = ?", name);
    }
}
