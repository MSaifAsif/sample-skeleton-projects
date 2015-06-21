package com.sample.applets;

import java.applet.Applet;
import java.awt.Graphics;

public class MyFirstApplet extends Applet {

	private static final long serialVersionUID = -3783584337636720597L;
	
	public void init(){
		System.out.println("This is being initialized");
	}
	
	public void draw(Graphics g){
		g.drawString("Greetings", 10, 100);
	}

}
