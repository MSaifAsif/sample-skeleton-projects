package com.sample.runners;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;

import com.sample.services.MyRestServices;

public class StandAloneClient {
    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(MyRestServices.class, args);
    }

}
