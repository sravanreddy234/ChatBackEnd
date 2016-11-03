package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Event;



@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface EventDAO {

	/**
	 *  Declare all CRUD Operations...
	 */
	
		public boolean save(Event event);
		
		public boolean update(Event event);
		
		public boolean saveOrUpdate(Event event);
		
		public boolean delete(Event event);
		
		public Event get(String id);
		
		public List<Event> list();
}
