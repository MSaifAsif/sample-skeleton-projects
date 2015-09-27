package com.sample.entity;

import javax.ejb.Remote;
/**
 * Interface for the bean that we will implement
 * @author saifasif
 *
 */
@Remote
public interface IBeanOne {

    /**
     * Greet message method
     * @param name
     */
    public void greet(String name);

}
