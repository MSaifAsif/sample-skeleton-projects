package com.sample.beans;

import java.util.List;
import java.util.Vector;

import javax.ejb.Stateful;
/**
 * A stateful bean that will maintain its values until the end of the application run
 * @author saifasif
 *
 */
@Stateful
public class SampleStatefulBean implements SampleBean {

    private List<String> entityList;

    public SampleStatefulBean() {
        System.out.println("Creating entityList for stateful bean");
        entityList = new Vector<String>();
    }

    @Override
    public void addEntity(String o) {
        System.out.println("Adding entity to stateful bean" + o.toString());
        entityList.add(o);
    }

    @Override
    public List<String> getEntity() {
        System.out.println("Retreiving values for stateful bean from list of : " + entityList.size());
        return entityList;
    }

}
