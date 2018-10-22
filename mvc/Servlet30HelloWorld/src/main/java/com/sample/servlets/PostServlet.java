package com.sample.servlets;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/postServlet")
public class PostServlet extends HttpServlet {

    private static final long serialVersionUID = -4438793421148760885L;
    private static final Logger log = Logger.getLogger(PostServlet.class);

    // Over-ridding service is not recommended. we should just implement any one of the HTTP methods
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        log.info("Servicing request for" + PostServlet.class.getName());
        /*
         * When the service method is implemented, the request will terminate at this point
         * if we still want to call the post method, then we will need to call it
         * seprately before response is commited
         */
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        log.info("Initializing POST .... ");
    }

}
