package com.sample.one;

import play.*;
import play.mvc.*;
import views.html.*;

public class MyHelloWorld extends Controller {

    public static Result greet() {
        return ok(("Hello World from " + MyHelloWorld.class.getCanonicalName()));
    }

}
