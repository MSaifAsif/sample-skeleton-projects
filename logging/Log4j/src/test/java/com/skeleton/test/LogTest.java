package com.skeleton.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LogTest {

    @Before
    public void init() {
        _empty_file();
    }

    @After
    public void destroy() {
        _empty_file();
    }

    private void _empty_file() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("./logs/myApp.log");
            pw.write("");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
