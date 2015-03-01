package com.skeleton.user;

import org.apache.log4j.Logger;



public class Main {
	
	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(Main.class);
		log.info("Informational");
		log.debug("debuggable");
		log.warn("Warning");
		log.error("Error prone");
		
	}

}
