package com.sample.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.sample.utils.ServletConstants;

/**
 * A startup servlet that will have its init method
 * called as soon as the container attempts to load the application
 * <p>
 * The purpose of this servlet is to add a few params to the
 * application context
 *
 * @author saifasif
 */
@WebServlet(loadOnStartup = 1, value = "/startup")
public class StartupServlet extends HttpServlet {

    private static final long serialVersionUID = 114128950806179598L;
    private static final Logger log = Logger.getLogger(StartupServlet.class);

    @Override
    public void init() throws ServletException {
        log.info("Initiating startup servlet");
        getServletConfig().getServletContext().setAttribute("applicationName", "Test-App");
        getServletConfig().getServletContext().setAttribute("applicationVersion", "1.0.0");
        getServletConfig().getServletContext().setAttribute("sessionID", ServletConstants.getNewSessionID());

    }

}
