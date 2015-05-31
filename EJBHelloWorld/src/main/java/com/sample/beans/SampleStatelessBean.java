package com.sample.beans;

import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;
/**
 * A sample stateless bean that will not maintain its values at all
 * @author saifasif
 *
 */
@Stateless
public class SampleStatelessBean implements SampleBean {

	private List<String> entityList;

	public SampleStatelessBean() {
		System.out.println("Creating entityList for stateless bean");
		entityList = new Vector<String>();
	}

	@Override
	public void addEntity(String o) {
		System.out.println("Adding entity to stateless bean" + o.toString());
		entityList.add(o);
	}

	@Override
	public List<String> getEntity() {
		System.out.println("Retreiving values for stateless bean from list of : " + entityList.size());
		return entityList;
	}

}
