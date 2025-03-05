package com.sample.listeners;

import com.sample.dynamic.CalculatorServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 */
@WebListener
public class SessionListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(SessionListener.class);

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Destroying context .... ");
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Initiating context ... ");
        ServletContext sc = sce.getServletContext();
        ServletRegistration registrar = sc.addServlet("calc", CalculatorServlet.class);
        registrar.addMapping("/calc");
        log.info(CalculatorServlet.class.getName() + " loaded");
    }

}
