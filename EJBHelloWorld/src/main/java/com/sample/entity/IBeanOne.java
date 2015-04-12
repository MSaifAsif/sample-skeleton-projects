package com.sample.entity;

import javax.ejb.Remote;

@Remote
public interface IBeanOne {
	
	public void greet(String name);

}
