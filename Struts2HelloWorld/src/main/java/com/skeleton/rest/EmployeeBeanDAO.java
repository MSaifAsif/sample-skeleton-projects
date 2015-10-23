package com.skeleton.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * A static DAO class
 * @author saifasif
 *
 */
public class EmployeeBeanDAO {

    // Map of all the employees that exist
    private static Map<String, EmployeeBean> employeeRepository = getEmployeesList(); 

    @SuppressWarnings("serial")
    private static Map<String, EmployeeBean> getEmployeesList() {
        /*
         * Populate a dummy list of employees like they exist in a table
         */
        return new HashMap<String, EmployeeBean>(){{
            put("0", new EmployeeBean(0, "Admin", 'M', 200));
            put("1", new EmployeeBean(1, "John", 'M', 25));
            put("2", new EmployeeBean(2, "Cena", 'M', 32));
            put("3", new EmployeeBean(3, "Marie", 'F', 23));
            put("4", new EmployeeBean(4, "Cal", 'M', 19));
        }};
    }

    /**
     * Retrieve an employee by its ID
     * @param id
     * @return
     */
    public static EmployeeBean findById(String id){
        return employeeRepository.get(id);
    }

    /**
     * Get all employees
     * @return
     */
    public static Map<String, EmployeeBean> findAll(){
        return employeeRepository;
    }

}
