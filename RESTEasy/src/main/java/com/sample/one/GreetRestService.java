package com.sample.one;

import com.sample.utilities.MyBean;
import com.sample.utilities.TransformationUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * The actual rest service that will be exposed to the user with /greet in the URL
 *
 * @author saifasif
 */
@Path("/greet")
public class GreetRestService extends Application {

    private static final Logger log = Logger.getLogger(GreetRestService.class);

    /**
     * A sample rest method exposed at URL '/greet/hello/{insert_name_here}'
     *
     * @param name A sample String text
     * @return {@link String} text format string that will be displayed on the page
     */
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreetings(@PathParam("name") String name) {
        log.info("Service requests... Getting response");
        return "Greetings " + name + " to Rest service.";
    }

    /**
     * A sample rest method exposed at URL '/greet/get_sample/{caller}'
     *
     * @param caller A sample String text
     * @return {@link String} json format string that will be displayed on the page
     */
    @GET
    @Path("/get_sample/{caller}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyBean getJsonObj(@PathParam("caller") String caller) {
        log.info("Service requests... Getting response");
        return TransformationUtils.getObj(caller);
    }
}
