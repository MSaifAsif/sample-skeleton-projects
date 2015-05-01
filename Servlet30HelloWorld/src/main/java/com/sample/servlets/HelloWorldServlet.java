package com.sample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/helloServlet")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = -3357643586829568349L;
	private static final Logger log = Logger.getLogger(HelloWorldServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		log.info("Initializing Get call ... ");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
}
