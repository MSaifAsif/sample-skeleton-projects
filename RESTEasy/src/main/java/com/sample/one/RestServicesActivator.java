package com.sample.one;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestServicesActivator extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RestServicesActivator() {
		this.singletons.add(new GreetRestService());
	}

	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	public Set<Object> getSingletons(){
		return this.singletons;
	}
}
