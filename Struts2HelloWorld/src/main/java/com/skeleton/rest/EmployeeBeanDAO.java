package com.skeleton.rest;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBeanDAO {

    private static Map<String, EmployeeBean> employeeRepository = getEmployeesList(); 

    @SuppressWarnings("serial")
    private static Map<String, EmployeeBean> getEmployeesList() {
        return new HashMap<String, EmployeeBean>(){{
            put("0", new EmployeeBean(0, "Admin", 'M', 200));
            put("1", new EmployeeBean(1, "John", 'M', 25));
            put("2", new EmployeeBean(2, "Cena", 'M', 32));
            put("3", new EmployeeBean(3, "Marie", 'F', 23));
            put("4", new EmployeeBean(4, "Cal", 'M', 19));
        }};
    }

    public static EmployeeBean findById(String id){
        return employeeRepository.get(id);
    }

    public static Map<String, EmployeeBean> findAll(){
        return employeeRepository;
    }

}
