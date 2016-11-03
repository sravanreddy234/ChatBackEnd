package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;



public class BlogJUnitTestCase {
	
	Logger log =  Logger.getLogger(BlogJUnitTestCase.class);
	
	@Autowired
	BlogDAO blogDAO;	//instance of BlogDAO created...
	
	@Autowired
	Blog blog;		//instance of Blog created...
	
	AnnotationConfigApplicationContext context;		//instance created successfully...
	
	//Initialize test case...
	@Before
	public void init() {	//init is just a method to initialize the instances...
		context = new AnnotationConfigApplicationContext();	//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");	//scan base package of the application...
		context.refresh();		//referesh the application...
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
		
	}
	
	//@Test
	public void listBlog() {
		log.debug("Entered in listBlog method.........");
		assertEquals(blogDAO.list().size(), 1);
	}
		
	//@Test
	public void addBlog() {
		blog.setB_id("blog001");
		blog.setB_title("#1 Blog");
		blog.setB_reason("Testing purpose");
		blog.setB_content("This is my first blog...");
		blog.setB_userId("sovan001");
		blog.setB_status("approved");
		
		assertEquals(blogDAO.save(blog), true);
	}
	
	//@Test
	public void updateBlog() {
		blog.setB_id("arpan001");
		blog.setB_title("#1 Blog");
		blog.setB_content("This is my first blog...");
		blog.setB_userId("sovan001");
		blog.setB_status("approved");
		
		assertEquals(blogDAO.update(blog), true);
	}
	
	//@Test
	public void deleteBlog() {
		blog.setB_id("blog002");
		
		assertEquals(blogDAO.delete(blog), true);
	}
	
	//@Test
	public void getBlog() {
		
		assertEquals(blogDAO.get("blog001").getB_title(), "#1 Blog");
	}
}
