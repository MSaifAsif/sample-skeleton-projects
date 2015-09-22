package com.sample.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * A simple tag class that just prints the hello message to the stream
 * @author saifasif
 *
 */
public class GreetingsTag extends SimpleTagSupport{

    public void doTag() throws JspException, IOException{
        JspWriter jspWriter = getJspContext().getOut();
        jspWriter.println("Greetings from a custom tag");
    }

}
