package com.sample.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.entity.IBeanOne;


public class StandAloneClient {

	public static void main(String[] args){
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "admin");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "admin");
		jndiProperties.put("jboss.naming.client.ejb.context", true);

		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);
			IBeanOne bean = (IBeanOne) ctx.lookup("/EJBHelloWorld/BeanOneImpl!com.sample.entity.IBeanOne");
			bean.greet("'EJB Bean'");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
