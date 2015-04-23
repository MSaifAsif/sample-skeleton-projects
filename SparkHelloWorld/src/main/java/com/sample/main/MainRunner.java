package com.sample.main;
import static spark.Spark.*;

import org.apache.log4j.Logger;

import spark.Request;
import spark.Response;
import spark.Route;


public class MainRunner {

	private static final Logger log = Logger.getLogger(MainRunner.class);

	public static void main(String[] args) {
		get("/helloWorld", new Route() {

			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				log.info("Init get .... ");
				return "Get done";
			}
		});

		post("/post1", (req, res) -> {
			log.info("Init post ....");
			return "Getting from post";
		});

	}

}
