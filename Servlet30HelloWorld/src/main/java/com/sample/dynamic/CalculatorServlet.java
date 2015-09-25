package com.sample.dynamic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CalculatorServlet extends HttpServlet{
    private static final long serialVersionUID = -2237206745594453412L;
    private static final Logger log = Logger.getLogger(CalculatorServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] inputVals = request.getParameterValues("inputVals");
        double result = 0.0d;
        int index = 0;
        for(index = 0; index < inputVals.length; index++){
            try{
                result += Double.valueOf(inputVals[index]);
            } catch (NumberFormatException nfe){
                log.warn("Could not parse value:" + inputVals[index]);
            }
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("/dynamic_pages/calc_result.jsp").forward(request, response);
    }
}
