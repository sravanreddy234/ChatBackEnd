package com.niit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.EventDAO;
import com.niit.model.Event;



@RestController
public class EventController {
	
	Logger log = Logger.getLogger(EventController.class);
	
	@Autowired
	EventDAO eventDAO;
	
	/**
	 * ----- url's related to event -----
	 * 
	 *	a. fetch all events : http://localhost:8081/Binder/events				//-----Y-----
	 *	b. save event : http://localhost:8081/Binder/event/						//-----N-----(500 internal server error)
	 *	c. update existing event : http://localhost:8081/Binder/event/{id}		//-----Y-----
	 * 	d. delete event : http://localhost:8081/Binder/event/{id}				//-----Y-----
	 * 	e. fetch event by id : http://localhost:8081/Binder/event/{id}			//-----Y-----
	 * 
	 */
	
	/**
	 * 	http://localhost:8081/Binder/events
	 * @return
	 */
	@GetMapping(value = "/events")
	public ResponseEntity<List<Event>> listEvents() {
		log.debug("**********Starting of listEvents() method.");
		List<Event> event = eventDAO.list();
		if(event.isEmpty()) {
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		log.debug("**********End of listEvents() method.");
		return new ResponseEntity<List<Event>>(event, HttpStatus.OK);
	}
	
	/**
	 * 	http://localhost:8081/Binder/event/
	 * @param event
	 * @return
	 */
	@PostMapping(value = "/event/")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		log.debug("**********Starting of createEvent() method.");
		if(eventDAO.get(event.getE_id()) == null) {
			eventDAO.save(event);
			log.debug("**********End of createEvent() method.");
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		}
		event.setErrorMessage("Event already exist with id : " +event.getE_id());
		log.error("Event already exist with id : " +event.getE_id());
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
	
	/**
	 * 	http://localhost:8081/Binder/event/{id}
	 * @param id
	 * @param event
	 * @return
	 */
	@PutMapping(value = "/event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") String id, @RequestBody Event event) {
		log.debug("**********Starting of updateEvent() method.");
		if(eventDAO.get(id) == null) {
			event = new Event();
			event.setErrorMessage("No event exist with id : " +event.getE_id());
			log.error("No event exist with id : " +event.getE_id());
			return new ResponseEntity<Event>(event, HttpStatus.NOT_FOUND);
		}
		eventDAO.update(event);
		log.debug("**********End of updateEvent() method.");
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	/**
	 * 	http://localhost:8081/Binder/event/{id}
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/event/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") String id) {
		log.debug("**********Starting of deleteEvent() method.");
		Event event = eventDAO.get(id);
		if(event == null) {
			event = new Event();
			event.setErrorMessage("No event exist with id : " + id);
			log.error("No event exist with id : " + id);
			return new ResponseEntity<Event>(event, HttpStatus.NOT_FOUND);
		}
		eventDAO.delete(event);
		log.debug("**********End of deleteEvent() method.");
		return new ResponseEntity<Event>(HttpStatus.OK);		
	}
	
	/**
	 * 	http://localhost:8081/Binder/event/{id}
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/event/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {
		log.debug("**********Starting of getEvent() method.");
		Event event = eventDAO.get(id);
		if(event == null) {
			event = new Event();
			event.setErrorMessage("No event exist with id : " + id);
			log.error("No event exist with id : " + id);
			return new ResponseEntity<Event>(event, HttpStatus.NOT_FOUND);
		}
		log.debug("**********End of getEvent() method.");
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
}
