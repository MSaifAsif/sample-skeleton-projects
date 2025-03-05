package com.skeleton.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class ProcessFormAction extends ActionSupport {

    private static final long serialVersionUID = -8580815860863183369L;

    private static final Logger log = Logger.getLogger(ProcessFormAction.class);

    private String firstName;
    private String gender;
    private Integer age;
    private String theErrorMessage;

    public String execute() {
        log.info(getFirstName());
        log.info(getGender());
        log.info(getAge());
        if (getAge() < 1) {
            setTheErrorMessage("0 age is not allowed");
            return ERROR;
        }
        return SUCCESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTheErrorMessage() {
        return theErrorMessage;
    }

    public void setTheErrorMessage(String theErrorMessage) {
        this.theErrorMessage = theErrorMessage;
    }

}
