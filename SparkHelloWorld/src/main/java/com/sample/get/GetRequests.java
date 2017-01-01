package com.sample.get;

import com.sample.interfaces.SumFunctionalI;
import org.apache.log4j.Logger;

import java.util.Map;

import static spark.Spark.get;

public class GetRequests {

    private static final Logger log = Logger.getLogger(GetRequests.class);

    /**
     * Sample get request to print a greeting on the browser
     */
    public static void greet() {
        get("/helloWorld", (arg0, arg1) -> "This is from the Get method. Hello world");
    }

    /**
     * Get request to print the query parameters passed
     * Sample request can look like <code>http://localhost:4567/helloWorld2?a=1,2&b=a&a=5</code>
     */
    public static void getQueryParams() {
        String result = "";
        get("/helloWorld2", (req, res) -> {
            Map<String, String[]> queryParamsMap = req.queryMap().toMap();
            for (String p : queryParamsMap.keySet()) {
                String[] vals = queryParamsMap.get(p);
                for (String val : vals) {
                    log.info(p + "::" + val);
                }

            }
            return result;
        });
    }

    public static void add() {
        get("/sumop", (req, res) -> {
            SumFunctionalI functionalI = (String tokenA, String tokenB) -> tokenA + tokenB;
            return functionalI.concatStrings("Hello", "World");
        });

    }

}
