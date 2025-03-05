package com.sample.beans;

import javax.ejb.Remote;
import java.util.List;

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
