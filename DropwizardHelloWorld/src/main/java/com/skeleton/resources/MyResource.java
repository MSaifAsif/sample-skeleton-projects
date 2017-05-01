package com.skeleton.resources;

import com.codahale.metrics.annotation.Timed;
import com.skeleton.beans.MyBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The resource class that is mapped to a URL
 *
 * @author saifasif
 */
@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MyResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public MyBean sayHello(@QueryParam("name") Optional<String> name) {
        // the variable name may or maynot exist, thats why optional
        final String value = String.format(template, name.orElse(defaultName));
        return new MyBean(counter.incrementAndGet(), value);
    }
}
