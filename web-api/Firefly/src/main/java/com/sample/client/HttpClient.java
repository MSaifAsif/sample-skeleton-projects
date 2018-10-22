package com.sample.client;

import com.firefly.$;

/**
 * @author saifasif
 */
public class HttpClient {
    public static void main(String[] args) {
        $.httpClient().get("http://localhost:8080/").submit()
                .thenAccept(res -> System.out.println(res.getStringBody()));
    }
}
