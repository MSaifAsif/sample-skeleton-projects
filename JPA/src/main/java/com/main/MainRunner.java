package com.main;


import java.util.List;

import com.jpa.dao.HumanDAO;
import com.jpa.model.Human;
import com.jpa.util.HibernateUtil;

public class MainRunner {

	public static void main(String[] args) {

		HibernateUtil.beginTransaction();

		HumanDAO humanDAO = new HumanDAO();
		Human human = new Human();
		
		human.setUserID(0);
		human.setFirstName("Changed Name");
		human.setLastName("Changed last name");
		human.setAge(42);
		human.setGender("Female");
		System.out.println("Got name with credentials " + human.getUserID());
		
//		List<Human> ls = humanDAO.getAll();
//		System.out.println(ls.size());
		humanDAO.makePersistent(human);
		HibernateUtil.commitTransaction();
		
	}
}