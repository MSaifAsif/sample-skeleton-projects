package com.sample.http;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleRequestsGetTest {

    private static final Logger log = Logger.getLogger(SimpleRequestsGetTest.class);

    @BeforeClass
    public static void init(){
        BasicConfigurator.configure();
        log.debug("Log ready ... ");
    }

    @Test
    public void testGetTitlesTest(){
        String res = SimpleRequests.getPageText("http://www.google.com");
        assertNotNull(res);
        assertNotNull(res.length());
    }

    @Test
    public void testGetTitlesTest2(){
        String res = SimpleRequests.getPageText("http://www.yahoo.com");
        assertNotNull(res);
        assertNotNull(res.length());
    }

    @Test
    public void testGetTitlesTest3(){
        String res = SimpleRequests.getPageText("http://www.google2.com");
        assertNull(res);
    }

    @Test
    public void testGetTitlesTest4(){
        String res = SimpleRequests.getPageText("");
        assertNull(res);
    }

}
