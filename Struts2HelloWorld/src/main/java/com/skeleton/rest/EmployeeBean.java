package com.skeleton.rest;

public class EmployeeBean {

    private int id;

    public EmployeeBean(int id){
        this.id = id;
    }
    
    public EmployeeBean getEmployeeById(int id){
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
