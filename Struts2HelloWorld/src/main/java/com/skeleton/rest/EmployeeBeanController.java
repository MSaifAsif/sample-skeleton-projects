package com.skeleton.rest;

import org.apache.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

public class EmployeeBeanController implements ModelDriven<Object> {

    private Object model;
    private static final Logger log = Logger.getLogger(EmployeeBeanController.class);

    private Integer id;

    public HttpHeaders index() {
        model = EmployeeBeanDAO.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders show() {
        log.info("Fetching employee with ID:" + getId());
        model = EmployeeBeanDAO.findById(String.valueOf(getId()));
        return new DefaultHttpHeaders("index").disableCaching();
    }

    @Override
    public Object getModel() {
        return model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
