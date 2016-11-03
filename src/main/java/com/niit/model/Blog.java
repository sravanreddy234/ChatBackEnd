package com.niit.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Blog extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for Blog... 
	 */
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String b_id;
	
	private String b_title;
	
	private String b_reason;
	
	private String b_content;
	
	@Column(name = "post_date")
	private Timestamp postDate;
	
	private String b_userId;
		
	private String b_status;
	
	/**
	 *  getters/setters for all the fields taken... 
	 */

	
	
	public Date getPostDate() {
		Date date = new Date();
		date.toString();
		return postDate;
	}
	/*public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}*/

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_reason() {
		return b_reason;
	}

	public void setB_reason(String b_reason) {
		this.b_reason = b_reason;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_userId() {
		return b_userId;
	}

	public void setB_userId(String b_userId) {
		this.b_userId = b_userId;
	}

	public String getB_status() {
		return b_status;
	}

	public void setB_status(String b_status) {
		this.b_status = b_status;
	}

	
	
}
