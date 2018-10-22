package com.sample.main;

import com.sample.get.GetRequests;
import com.sample.post.PostRequests;

/**
 * Main runner to deploy the individual services
 *
 * @author saifasif
 */
public class MainRunner {

    public static void main(String[] args) {

        // Deploy the get requests
        GetRequests.greet();
        // Deploy the post requests
        PostRequests.postTest();

    }

}
