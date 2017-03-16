package com.skeleton.rest;

import org.apache.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

/**
 * The REST api class. This will serve as entry point for all rest calls to the {@link EmployeeBean} resource
 * <br><br>
 * Sample requests are <br>
 * <ul>
 * <li><code>http://localhost:8080/Struts2HelloWorld/rest/employee.xml</code></li>
 * <li><code>http://localhost:8080/Struts2HelloWorld/rest/employee/1.xml</code></li>
 * </ul>
 *
 * @author saifasif
 */
public class EmployeeBeanController implements ModelDriven<Object> {

    private static final Logger log = Logger.getLogger(EmployeeBeanController.class);
    /*
     * Model is kept as an object since we may be returning either a single entity
     * or a json of entities or even an xml
     */
    private Object model;
    /*
     * Keep it as wrapped object
     */
    private Integer id;

    /**
     * The index method implementation to fetch all values
     *
     * @return
     */
    public HttpHeaders index() {
        model = EmployeeBeanDAO.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    /**
     * Attempt to fetch en employee via its id
     *
     * @return
     */
    public HttpHeaders show() {
        log.debug("Fetching employee with ID:" + getId());
        model = EmployeeBeanDAO.findById(String.valueOf(getId()));
        return new DefaultHttpHeaders("show").disableCaching();
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
