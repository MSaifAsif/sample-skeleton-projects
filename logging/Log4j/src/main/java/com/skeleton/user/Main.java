package com.skeleton.user;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {

        // logger can be initialized inside method
        Logger log = LogManager.getLogger(Main.class);
        log.info("Informational");
        log.debug("debuggable");
        log.warn("Warning");
        log.error("Error prone");

    }

}
