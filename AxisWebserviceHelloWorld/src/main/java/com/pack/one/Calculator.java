package com.pack.one;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculator {

	@WebMethod
	public float sum(float a, float b){
		return a + b;
	}

	@WebMethod
	public float div(float a, float b){
		if (b == 0.0F) throw new ArithmeticException("Divide by zero not allowed ... Bailing out!");
		return a / b;
	}

	@WebMethod
	public float mul(float a, float b){
		return a * b;
	}

	@WebMethod
	public float sub(float a, float b){
		return a - b;
	}


}
