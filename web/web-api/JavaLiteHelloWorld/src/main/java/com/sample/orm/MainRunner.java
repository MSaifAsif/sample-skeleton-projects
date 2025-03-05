package com.sample.orm;

import org.apache.log4j.BasicConfigurator;

public class MainRunner {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        ConnectionUtils.openConnection();
        ConnectionUtils.createEntity("John", 23, "m");
        PersonModel model = ConnectionUtils.selectPersonByName("John");
        System.out.println("Fetched:" + model.get("name"));
    }
}
