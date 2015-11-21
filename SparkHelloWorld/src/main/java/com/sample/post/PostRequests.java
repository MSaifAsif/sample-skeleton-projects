package com.sample.post;
import static spark.Spark.post;

import org.apache.log4j.Logger;

public class PostRequests {

    private static final Logger log = Logger.getLogger(PostRequests.class);

    /**
     * Dummy post request
     * 
     */
    public static void postTest(){
        post("/post1", (req, res) -> {
            log.info("Init post ....");
            return "Getting from post";
        });



    }

}
