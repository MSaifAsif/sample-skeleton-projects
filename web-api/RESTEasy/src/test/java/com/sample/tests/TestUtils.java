package com.sample.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sample.utilities.TransformationUtils;

public class TestUtils {

    @Test
    public void testRandomMethod() {
        assertNotNull(TransformationUtils.getSumOfBytes());
    }

    @Test
    public void testRandomMethod2() {
        assert Float.valueOf(TransformationUtils.getSumOfBytes()) > 0.0F;
    }

}
