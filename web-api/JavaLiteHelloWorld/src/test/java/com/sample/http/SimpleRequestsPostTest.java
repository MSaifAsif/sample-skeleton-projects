package com.sample.http;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SimpleRequestsPostTest {

    private static final Logger log = Logger.getLogger(SimpleRequestsPostTest.class);

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
        log.debug("Log ready ... ");
    }

    @Test
    public void testPost1() {
        String res = SimpleRequests.performPostOnPage("http://www.google.com", new byte[100]);
        assertNotNull(res);
        assertNotNull(res.length());
    }

    @Test
    public void testPost2() {
        String res = SimpleRequests.performPostOnPage("http://www.yahoo.com", new byte[100]);
        assertNotNull(res);
        assertNotNull(res.length());
    }

    @Test
    public void testPost3() {
        String res = SimpleRequests.performPostOnPage("localhost", new byte[100]);
        assertNull(res);
    }
}
