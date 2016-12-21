package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.Users;


public class UserJUnitTestCase {
	
	Logger log =  Logger.getLogger(UserJUnitTestCase.class);
			
	@Autowired
	UserDAO userDAO;	//instance of UserDAO created...
	
	@Autowired
	Users users;		//instance of User created...
	
	AnnotationConfigApplicationContext context;		//instance created successfully...
	
	//Initialize test case...
	@Before
	public void init() {	//init is just a method to initialize the instances...
		context = new AnnotationConfigApplicationContext();	//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");	//scan base package of the application...
		context.refresh();		//referesh the application...
		
		userDAO = (UserDAO) context.getBean("userDAO");
		users = (Users) context.getBean("users");
		
	}
	
	//@Test
	public void listUser() {
		log.debug("Entered in listUser method...........");
		//System.out.println(userDAO.list()+"..............................................");
		assertEquals(userDAO.list().size(), 5);
	}
	
	
	
	@Test
	public void addUser() {
		users.setId("abc002");
		users.setName("sravan");
		users.setPassword("sravan");
		users.setGender("male");
		users.setEmail("sravan@gmail.com");
		users.setPhone("8350078895");
		users.setRole("student");
		//users.setImage(null);
		//users.setPhotos(null);
		
		assertEquals(userDAO.save(users), true);
	}
	
	/*//@Test
	public void updateUser() {
		users.setId("arpan001");
		users.setName("Sudipta");
		users.setPassword("jijo001");
		users.setGender("male");
		users.setEmail("sudiptajijo@gmail.com");
		users.setPhone("8350054367");
		users.setRole("EMPLOYEE");
		
		assertEquals(userDAO.update(users), true);
	}
	
	
	//@Test
	public void getUser() {
		
		assertEquals(userDAO.get("sovan001").getName(), "Sravan");
	}*/
}
