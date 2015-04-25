package com.sample.main;
import static spark.Spark.*;

import org.apache.log4j.Logger;

import spark.Request;
import spark.Response;
import spark.Route;


public class MainRunner {

	private static final Logger log = Logger.getLogger(MainRunner.class);

	public static void main(String[] args) {

		log.info("INit server ...");
		
		get("/helloWorld", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				log.info("Init get .... ");
				return "This is from the Get method. Hello world";
			}
		});

		post("/post1", (req, res) -> {
			log.info("Init post ....");
			return "Getting from post";
		});

		get("/helloWorld2", (req, res) -> {
			log.info(req.queryParams());
			return "";
		});

	}

}
