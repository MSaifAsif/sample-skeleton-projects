package com.sample.services;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyRestServices {
    
    private static final Logger log = Logger.getLogger(MyRestServices.class);
    
    @RequestMapping("/")
    public String greet(){
        log.info("Initializing call from greet() message .... ");
        return "Greetings, from " + MyRestServices.class.getCanonicalName();
    }

}
