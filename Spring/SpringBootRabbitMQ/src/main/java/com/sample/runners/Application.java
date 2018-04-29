package com.sample.runners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sample")
public class Application {

    public static void main(String[] args) {

        // Fire the controller
        SpringApplication.run(Application.class, args);
    }

}
