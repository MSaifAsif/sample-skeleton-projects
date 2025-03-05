package com.sample.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * A simple tag class that just prints the hello message to the stream
 *
 * @author saifasif
 */
public class GreetingsTag extends SimpleTagSupport {

    // This will contain what-ever we put in the tag body
    StringWriter sw = new StringWriter();
    // Will contain the 'username' attribute
    private String username;

    public void doTag() throws JspException, IOException {

        // invoke it on the StringWriter
        getJspBody().invoke(sw);

        // Get the writer to the JSP
        JspWriter jspWriter = getJspContext().getOut();
        String greetingsMessage = String.valueOf(sw).concat(username).toUpperCase();

        jspWriter.println(greetingsMessage);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
