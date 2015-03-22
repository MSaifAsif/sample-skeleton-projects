package com.pack.one;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculator {
	
	@WebMethod
	public float sum(float a, float b){
		return a + b;
	}

}
