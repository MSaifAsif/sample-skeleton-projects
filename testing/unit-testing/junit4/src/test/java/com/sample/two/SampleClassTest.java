package com.sample.two;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class SampleClassTest {

    private static final Logger log = Logger.getLogger(SampleClassTest.class);

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    @Test
    public void testContant() {
        assertEquals(4, SampleClass.NUMBER_FOUR);
        assertNotEquals(3, SampleClass.NUMBER_FOUR);
    }

    @Test
    public void testRandomInt() {
        SampleClass object = new SampleClass();
        double d = object.getRandomInt();
        assertNotNull(d);
    }

    @Test
    public void testGreetMessage() {
        assertNotNull(SampleClass.getGreetMessage());
        assertEquals("Hello, world !", SampleClass.getGreetMessage());
    }

    @Test
    public void testPrivateLargeIntegerNoArg() {
        try {
            // Get the zero arg constructor
            Constructor<SampleClass> zeroArgCons = SampleClass.class.getConstructor();
            // call the contructor
            SampleClass classRef = zeroArgCons.newInstance();
            // get the method
            Method intPrivateMethod = SampleClass.class.getDeclaredMethod("getLargerInteger", java.lang.Integer.class, java.lang.Integer.class);
            // set it TRUE
            intPrivateMethod.setAccessible(Boolean.TRUE);
            // and now, invoke the method
            Object result = intPrivateMethod.invoke(classRef, 2, 3);
            assertNotNull(result);
            assertEquals(result, 2);

            result = intPrivateMethod.invoke(classRef, 3, 2);
            assertNotNull(result);
            assertEquals(result, 2);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void testPrivateLargeIntegerArg() {
        try {
            // Get the argument constructor
            Constructor<SampleClass> zeroArgCons = SampleClass.class.getConstructor(int.class);
            // call the contructor with the arguement
            SampleClass classRef = zeroArgCons.newInstance(1);
            // get the method
            Method intPrivateMethod = SampleClass.class.getDeclaredMethod("getLargerInteger", java.lang.Integer.class, java.lang.Integer.class);
            // set it TRUE
            intPrivateMethod.setAccessible(Boolean.TRUE);
            // and now, invoke the method with the params
            Object result = intPrivateMethod.invoke(classRef, 2, 3);
            assertNotNull(result);
            assertEquals(result, 2);

            result = intPrivateMethod.invoke(classRef, 3, 2);
            assertNotNull(result);
            assertEquals(result, 2);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            log.error(e.getMessage(), e);
        }
    }
}
