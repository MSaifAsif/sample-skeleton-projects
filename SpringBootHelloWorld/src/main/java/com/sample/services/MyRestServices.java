package com.sample.services;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest service implementation class.
 * @author saifasif
 *
 */
@RestController
@EnableAutoConfiguration
public class MyRestServices {
    
    private static final Logger log = Logger.getLogger(MyRestServices.class);
    
    /**
     * The first rest service method exposed. Basic level web service method. Only 
     * returns a sample string in the response and logs message to server as well
     * Mapped at <code>http://domain:port/applicationName/</code>
     * @return {@link String} Message
     */
    @RequestMapping("/")
    public String greet(){
        log.info("Initializing call from greet() message .... ");
        return "Greetings, from " + MyRestServices.class.getCanonicalName();
    }

}
