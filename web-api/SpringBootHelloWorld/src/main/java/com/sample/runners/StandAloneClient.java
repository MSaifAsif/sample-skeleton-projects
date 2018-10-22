package com.sample.runners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Standalone runner. Will be responsible for exposing the web services in an embedded jetty
 * server. <br><br>This will serve as the entry point of the application when the command<br> <code>[~]$ mvn spring-boot:run</code>
 * will be executed
 *
 * @author saifasif
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = com.sample.services.MyRestServicesController.class)
public class StandAloneClient {

    public static void main(String[] args) {

        // Fire the controller
        SpringApplication.run(StandAloneClient.class, args);
    }

}
