package com.skeleton.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class DefaultErrorAction extends ActionSupport {

    private static final long serialVersionUID = 3794058398079142516L;
    private static final Logger log = Logger.getLogger(DefaultErrorAction.class);

    private String theError;

    public String getErrorMessage() {
        log.info(getTheError());
        return SUCCESS;
    }

    public String getTheError() {
        return theError;
    }

    public void setTheError(String theError) {
        this.theError = theError;
    }

}
