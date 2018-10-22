package com.pack.one;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * A calculator web service that will perform basic calculation. Annotated with the {@link WebService}
 * so that it can be classified as a webservice
 *
 * @author saifasif
 */
@WebService
public class Calculator {

    /**
     * A simple sum function
     *
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public float sum(float a, float b) {
        return a + b;
    }

    /**
     * A division function. Divide by zero is not allowed ...
     *
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public float div(float a, float b) {
        if (b == 0.0F) throw new ArithmeticException("Divide by zero not allowed ... Bailing out!");
        return a / b;
    }

    /**
     * Floating point multiplication
     *
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public float mul(float a, float b) {
        return a * b;
    }

    /**
     * Subtraction function
     *
     * @param a
     * @param b
     * @return
     */
    @WebMethod
    public float sub(float a, float b) {
        return a - b;
    }


}
