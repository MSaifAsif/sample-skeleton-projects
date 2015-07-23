package com.sample.client;

import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

import com.sample.beans.SampleBean;
import com.sample.entity.IBeanOne;

/**
 * StandALone client to fetch and call methods on the {@link Remote} {@link EJB} objects deployed in the container
 * 
 * @author saifasif
 *
 */
public class StandAloneClient {

	public static void main(String[] args){

		BasicConfigurator.configure();

		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "admin");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "admin");
		jndiProperties.put("jboss.naming.client.ejb.context", true);

		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);

			getStatefulBeans(ctx);
			getStatelessBeans(ctx);

			IBeanOne bean = (IBeanOne) ctx.lookup("/EJBHelloWorld/BeanOneImpl!com.sample.entity.IBeanOne");
			bean.greet("'Saif Asif'");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Attempts to fetch the stateless bean.<br>
	 * For each call to <code>addEntity</code>, a new object will be created by calling the constructor and the state of the 
	 * previous one will be lost. Thus the name 'stateless'
	 * 
	 * @param ctx
	 * @throws NamingException
	 */
	private static void getStatelessBeans(Context ctx) throws NamingException {
		SampleBean statelessBean = (SampleBean) ctx.lookup("/EJBHelloWorld/SampleStatelessBean!com.sample.beans.SampleBean");
		statelessBean.addEntity("111");
		/*
		 * since another operation is attempted, call to constructor will take place and previous object's state will be lost 
		 * at this point
		 */
		statelessBean.addEntity("222");
		/*
		 * Since getEntity is also an operation, this will be another call to contructor and the size of list will always return
		 * as 0
		 */
		statelessBean.getEntity();

		SampleBean statelessBean2 = (SampleBean) ctx.lookup("/EJBHelloWorld/SampleStatelessBean!com.sample.beans.SampleBean");
		statelessBean2.addEntity("333");
		statelessBean2.addEntity("444");
		statelessBean2.getEntity();

	}

	/**
	 * Attempts to fetch the stateful bean. A new object will not be created for each subsequent call to <code>addEntity</code>.
	 * The state of the previous object will be retained untill another lookup is performed. So the state remains untill the
	 * session remains. Thus the name 'stateful'
	 * 
	 * @param ctx
	 * @throws NamingException
	 */
	private static void getStatefulBeans(Context ctx) throws NamingException {
		SampleBean statefulBean = (SampleBean) ctx.lookup("/EJBHelloWorld/SampleStatefulBean!com.sample.beans.SampleBean");
		statefulBean.addEntity("111");
		statefulBean.addEntity("222");
		/*
		 * Since this is a stateful bean, it will retain the object's state the following call return 2
		 */
		statefulBean.getEntity();

		/*
		 * But now this is another lookup, so at this point a call to the constructor will be made
		 */
		SampleBean statefulBean2 = (SampleBean) ctx.lookup("/EJBHelloWorld/SampleStatefulBean!com.sample.beans.SampleBean");
		statefulBean2.addEntity("333");
		statefulBean2.addEntity("444");
		/*
		 * and thus, this will again give size as 2
		 */
		statefulBean2.getEntity();
	}
}
