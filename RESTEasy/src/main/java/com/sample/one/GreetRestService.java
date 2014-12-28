package com.sample.one;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/greet")
public class GreetRestService extends Application {
	
	private static final Logger log = Logger.getLogger(GreetRestService.class);

	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getGreetings(@PathParam("name") String name){
		log.info("Service requests... Getting response");
		return "Greetings " + name + " to Rest service.";
	}
}
