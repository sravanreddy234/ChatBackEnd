package com.niit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Event extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 * declare the database column names for User... 
	 */
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String e_id;
	
	private String e_name;
	
	private String e_venue;
	
	private String e_description;
	
	@Column(name = "event_date")
	private Date date;
	
	/**
	 *  getters/setters for all the fields taken... 
	 */

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_venue() {
		return e_venue;
	}
	public void setE_venue(String e_venue) {
		this.e_venue = e_venue;
	}
	public String getE_description() {
		return e_description;
	}
	public void setE_description(String e_description) {
		this.e_description = e_description;
	}
		
}
