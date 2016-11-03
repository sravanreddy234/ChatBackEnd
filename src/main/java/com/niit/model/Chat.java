package com.niit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Chat extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	/**
	 *  declare the database column names for User... 
	 */

	@Id
	private String c_id;
	
	private String senderId;
	
	private String receiverId;
	
	private String c_content;
	
	private Date c_dateTime;

	/**
	 *  getters/setters for all the fields taken... 
	 */
	
	public String getSenderId() {
		return senderId;
	}
	
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public Date getC_dateTime() {
		return c_dateTime;
	}

	public void setC_dateTime(Date c_dateTime) {
		this.c_dateTime = c_dateTime;
	}
	
}
