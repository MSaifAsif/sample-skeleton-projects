package com.skeleton.rest;

import java.io.Serializable;

/**
 * An employee bean mapped with the {@link EmployeeBeanDAO} class
 * @author saifasif
 *
 */
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 176619359775474272L;

    private long id;
    private String name;
    private char gender;
    private int age;

    public EmployeeBean(long id, String name, char gender, int age){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    private String company;


}
