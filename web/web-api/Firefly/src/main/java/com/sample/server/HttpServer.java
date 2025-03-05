package com.sample.server;

import com.firefly.$;

/**
 * @author saifasif
 */
public class HttpServer {

    public static void main(String[] args) {
        $.httpServer()
                .router().get("/").handler(ctx -> ctx.end("hello world!"))
                .listen("localhost", 8080);
    }
}
