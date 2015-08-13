package com.sample.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.sample.utilities.TransformationUtils;

public class TestUtils {
    
    @Test
    public void testRandomMethod(){
        assertNotNull(TransformationUtils.getSumOfBytes());
    }

}
