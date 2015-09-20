package com.sample.get;

import static spark.Spark.get;

import java.util.Map;

import org.apache.log4j.Logger;

import spark.Request;
import spark.Response;
import spark.Route;

public class GetRequests {

    private static final Logger log = Logger.getLogger(GetRequests.class);

    /**
     * Sample get request to print a greeting on the browser
     */
    public static void greet(){
        get("/helloWorld", new Route() {
            @Override
            public Object handle(Request arg0, Response arg1) throws Exception {
                return "This is from the Get method. Hello world";
            }
        });
    }

    /**
     * Get request to print the query parameters passed
     * Sample request can look like <code>http://localhost:4567/helloWorld2?a=1,2&b=a&a=5</code>
     */
    public static void getQueryParams(){
        String result = "";
        get("/helloWorld2", (req, res) -> {
            Map<String, String[]> queryParamsMap = req.queryMap().toMap();
            for( String p : queryParamsMap.keySet() ) {
                String key = p;
                String[] vals = queryParamsMap.get(p);
                for ( String val : vals ) {
                    log.info(key + "::" + val);
                }

            }
            return result;
        });
    }

}
