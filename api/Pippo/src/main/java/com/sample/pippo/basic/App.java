package com.sample.pippo.basic;

import ro.pippo.core.Application;

public class App extends Application {

    @Override
    protected void onInit() {
        GET("/", routeContext -> {
            routeContext.send("Hello World");
        });
    }

}
