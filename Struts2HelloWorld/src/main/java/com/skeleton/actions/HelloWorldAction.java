package com.skeleton.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The HelloWorld action class that does nothing but logs and returns "success"
 * @author saifasif
 *
 */
public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 2803230740790812000L;
	private static final Logger log = Logger.getLogger(HelloWorldAction.class);
	
	/**
	 * The overriden method. Should always return a string
	 * @return {@link ActionSupport} SUCCESS constant
	 */
	public String execute(){
		log.info("Sample log coming from the action class ...");
		return SUCCESS;
	}

}
