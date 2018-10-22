package com.sample.one;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Activator to register our rest service implementations
 *
 * @author saifasif
 */
public class RestServicesActivator extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public RestServicesActivator() {
        this.singletons.add(new GreetRestService());
    }

    public Set<Class<?>> getClasses() {
        return this.empty;
    }

    public Set<Object> getSingletons() {
        return this.singletons;
    }
}
