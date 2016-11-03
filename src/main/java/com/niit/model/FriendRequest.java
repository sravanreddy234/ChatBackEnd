package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class FriendRequest extends BaseDomain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for User... 
	 */
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String fr_id;
	
	@Column(name = "request_to")
	private String requestTo;
	
	@Column(name = "request_from")
	private String requestFrom;
	
	/**
	 *  getters/setters for all the fields taken... 
	 */

	
	public String getRequestTo() {
		return requestTo;
	}
	public String getFr_id() {
		return fr_id;
	}
	public void setFr_id(String fr_id) {
		this.fr_id = fr_id;
	}
	public void setRequestTo(String requestTo) {
		this.requestTo = requestTo;
	}
	public String getRequestFrom() {
		return requestFrom;
	}
	public void setRequestFrom(String requestFrom) {
		this.requestFrom = requestFrom;
	}	
}
