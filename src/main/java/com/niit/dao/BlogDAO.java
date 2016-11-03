package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Blog;



@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface BlogDAO {

	/**
	 *  Declare all CRUD Operations...
	 */	
	public boolean save(Blog blog);
	
	public boolean update(Blog blog);
	
	public boolean saveOrUpdate(Blog blog);
	
	public boolean delete(Blog blog);
	
	public Blog get(String id);
	
	public List<Blog> list();
}
