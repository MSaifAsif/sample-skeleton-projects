package com.sample.entity;

import javax.ejb.SessionBean;
import javax.ejb.Stateless;
/**
 * This is the implementation of a {@link Stateless} {@link SessionBean}
 * @author saifasif
 *
 */
@Stateless
public class BeanOneImpl implements IBeanOne {

    @Override
    public void greet(String name) {
        System.out.println("Hello " + name + " from EJB BeanOne");
    }

}
