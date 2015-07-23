package com.skeleton.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

    @Test
    public void propertyFileTest() {
        FileReader file;
        try {
            file = new FileReader("./src/main/resources/log4j.properties");
            assertTrue(file.getEncoding() != null);
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void initiateLogger() {
        Logger log = Logger.getLogger(LogTest.class);
        log.debug("These are coming from the test class");
    }

}
