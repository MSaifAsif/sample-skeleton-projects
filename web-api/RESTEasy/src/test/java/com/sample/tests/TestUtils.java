package com.sample.tests;

import com.sample.utilities.TransformationUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
