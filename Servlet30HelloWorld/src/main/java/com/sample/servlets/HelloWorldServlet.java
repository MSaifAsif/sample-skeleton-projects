package com.sample.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * Servlet class that extends {@link HttpServlet}. A simple get call that adds some values to the request and then forwards request 
 * to a jsp page
 * 
 * @author saifasif
 *
 */
@WebServlet(urlPatterns="/helloServlet")
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = -3357643586829568349L;
    private static final Logger log = Logger.getLogger(HelloWorldServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.debug("Initializing Get call ... ");
        List<Double> listOfDoubles = new ArrayList<>();
        for (int i = 0; i < 25; i++){
            listOfDoubles.add(Math.random());
        }
        log.info("session id " + request.getServletContext().getAttribute("sessionID"));
        request.setAttribute("numberList", listOfDoubles);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}
