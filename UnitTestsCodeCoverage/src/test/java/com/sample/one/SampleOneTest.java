package com.sample.one;

import org.junit.Test;

import com.sample.one.SampleOne.InnerSample;

public class SampleOneTest {

	@Test
	public void testOne(){
		SampleOne one = new SampleOne();
		one.getSum(1, 0);
	}

	@Test
	public void testTwo(){
		SampleOne one = new SampleOne();
		one.getSum(0, 1);
	}

	@Test
	public void testThree(){
		SampleOne one = new SampleOne();
		one.getSum(0, 0);
	}

	@Test
	public void testFour(){
		SampleOne one = new SampleOne();
		one.getSum(1, 1);
	}

//	@Test
//	public void testFive(){
//		SampleOne.InnerSample innerSample = new SampleOne.InnerSample(1);
//		innerSample.getSquare();
//	}


}
