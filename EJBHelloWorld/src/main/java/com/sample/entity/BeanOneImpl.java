package com.sample.entity;

import javax.ejb.Stateless;

@Stateless
public class BeanOneImpl implements IBeanOne {

	@Override
	public void greet(String name) {
		System.out.println("Hello " + name + " from EJB BeanOne");
	}

}
