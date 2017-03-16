package com.sample.beans;

import java.util.List;

import javax.ejb.Remote;

/**
 * THe bean interface.
 *
 * @author saifasif
 */
@Remote
public interface SampleBean {

    void addEntity(String o);

    List<String> getEntity();

}
