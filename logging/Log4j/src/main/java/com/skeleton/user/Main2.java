package com.skeleton.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main2 {

    // class level logger
    private static final Logger logger = LogManager.getLogger(Main2.class);

    public static void main(String[] args) {
        logger.debug("This is another message");
    }
}
