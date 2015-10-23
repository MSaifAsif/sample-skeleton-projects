package com.skeleton.rest;

import org.apache.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

public class EmployeeBeanController implements ModelDriven<EmployeeBean> {

    private EmployeeBean model;
    private static final Logger log = Logger.getLogger(EmployeeBeanController.class);

    private int id;

    public HttpHeaders index() {
        log.info("calling index");
        model = new EmployeeBean(42).getEmployeeById(42);
        return new DefaultHttpHeaders("index").disableCaching();
    }

    @Override
    public EmployeeBean getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
