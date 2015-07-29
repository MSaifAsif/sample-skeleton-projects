package com.sample.runners;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;

import com.sample.services.MyRestServices;

/**
 * Standalone runner. Will be responsible for exposing the web services in an embedded jetty 
 * server. <br><br>This will serve as the entry point of the application when<br> <code>[~]$ mvn spring-boot:run</code>
 * @author saifasif
 *
 */
public class StandAloneClient {
    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(MyRestServices.class, args);
    }

}
