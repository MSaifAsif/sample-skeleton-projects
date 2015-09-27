package com.jpa.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO implmentation interface
 * @author MuhammadSaif
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {  

    T findById(ID id, boolean lock);  

    List<T> findAll();  

    List<T> findByExample(T exampleInstance);  

    T makePersistent(T entity);  

    void makeTransient(T entity);  
}  
