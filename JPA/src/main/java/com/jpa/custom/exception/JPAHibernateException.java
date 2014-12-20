package com.jpa.custom.exception;

import org.hibernate.HibernateException;


public class JPAHibernateException extends HibernateException {

	private static final long serialVersionUID = 4665648779893234197L;
	
	
	public JPAHibernateException(String message, Throwable t){
		super(message);
		System.out.println("Catching custom JPA exception : " + message);
	}
	
	
	
	
	public static void main(String[] args) {
		throw new JPAHibernateException("Custom Exception", new Throwable("Throw it"));
	}

}
