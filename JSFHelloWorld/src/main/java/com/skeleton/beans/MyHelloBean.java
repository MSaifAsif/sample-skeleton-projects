package com.skeleton.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

/**
 * A {@link ManagedBean} is a normal JavaBean that is contains fields and
 * some getter/setters that will be used to display the values on our JSF page
 * <br>
 * Values will be referred on the jsf page as myHelloBean#greetMessage and it will
 * fetch the values using the correct setter method
 *
 * @author saifasif
 */
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
