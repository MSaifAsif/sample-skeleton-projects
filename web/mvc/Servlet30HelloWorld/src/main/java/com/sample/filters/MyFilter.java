package com.sample.filters;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    private static final Logger log = Logger.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Starting filter .... ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getRequestURL().toString().endsWith(".jsp")) {
            // This was a direct JSP attempt, shut it down ! Don't let it pass
            log.info("Attempt for opening JSP directly stopped .... ");
        } else {
            // Let other requests forward without disrupting the request, response object
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        log.warn("Filter is getting destroyed .... ");
    }

}
