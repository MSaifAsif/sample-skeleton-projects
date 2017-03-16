package com.sample.integrations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.sample.one.GreetRestService;

/**
 * Integration tests for {@link GreetRestService}
 *
 * @author saifasif
 */
public class ITRestService {

    private static final Logger log = Logger.getLogger(ITRestService.class);
    private static final String greetEndPoint = "http://localhost:8080/RESTEasy/rest/greet/hello/{name}";
    private static final String jsonEndPoint = "http://localhost:8080/RESTEasy/rest/greet/get_sample/{caller}";
    private static final String emptyEndPoint = "http://localhost2:8080/null";

    @Test
    public void testEndpoint() {
        Response response = RestAssured.get(greetEndPoint, "Tenka");
        log.info("Extracting response message ... ");
        assertNotNull(response.body().asString());
    }

    @Test(expected = java.net.UnknownHostException.class)
    public void testEndpoint2() {
        Response response = RestAssured.get(emptyEndPoint);
        log.info("Extracting response message ... ");
        assertNotNull(response.body().asString());
    }

    @Test
    public void testGetService() {
        Response response = RestAssured.get(greetEndPoint, "Tenka");
        log.info("Extracting response message ... ");
        assertEquals("Greetings Tenka to Rest service.", response.body().asString());
    }

    @Test
    public void testGetJson() {
        Response response = RestAssured.get(jsonEndPoint, "Tenka");
        log.info("Extracting response message ... ");
        assertNotNull(response.body().asString());
    }

    @Test
    public void testGetJson2() {
        Response response = RestAssured.get(jsonEndPoint, "Tenka");
        log.info("Extracting response message ... ");
        String responseBody = response.body().asString();
        assertNotNull(responseBody);
        assertEquals("{\"index\":1,\"name\":\"Tenka\",\"epoch\":0,\"gender\":\"m\"}", responseBody);
    }
}
