package com.skeleton.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyHelloBean implements Serializable {

	private static final long serialVersionUID = -1042851273678383131L;
	private String greetMessage;

	public String getGreetMessage() {
		return greetMessage;
	}
	public void setGreetMessage(String greetMessage) {
		this.greetMessage = greetMessage;
	}

}
