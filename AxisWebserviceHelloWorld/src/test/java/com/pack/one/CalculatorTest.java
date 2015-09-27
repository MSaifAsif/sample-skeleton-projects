package com.pack.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Junit cases for the {@link Calculator} web service
 * @author saifasif
 *
 */
public class CalculatorTest {

    @Test
    public void testMul(){
        Calculator calculator = new Calculator();
        assertEquals(0.0F, (float)calculator.mul(1, 0), -1);
    }

    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.sum(5, 5), -1);

    }

    @Test(expected=java.lang.ArithmeticException.class)
    public void testDiv(){
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.div(1, 0), -1);
    }

    @Test
    public void testSub(){
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.sub(15, 5), -1);

    }


}
