package com.skeleton.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 2803230740790812000L;
	private static final Logger log = Logger.getLogger(HelloWorldAction.class);
	
	public String execute(){
		log.info("Sample log coming from the action class ...");
		return SUCCESS;
	}

}
