package com.sample.one;

import com.sample.one.SampleOne.InnerSample;
import org.junit.Test;

/**
 * Test cases for the utility methods
 */
public class SampleOneTest {

    @Test
    public void testOne() {
        SampleOne one = new SampleOne();
        one.getSum(1, 0);
    }

    @Test
    public void testTwo() {
        SampleOne one = new SampleOne();
        one.getSum(0, 1);
    }

    @Test
    public void testThree() {
        SampleOne one = new SampleOne();
        one.getSum(0, 0);
    }

    @Test
    public void testFour() {
        SampleOne one = new SampleOne();
        one.getSum(1, 1);
    }

    @Test
    public void testFive() {
        InnerSample inner = new InnerSample(1);
        inner.getSquare();
    }

    @Test
    public void testSix() {
        InnerSample inner = new InnerSample(-1);
        inner.getSquare();
    }

}
