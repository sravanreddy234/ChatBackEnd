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
public class Forum extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for User... 
	 */
	
	@Id
	private String f_id;
	
	private String f_description;
	
	@Column(name = "post_date")
	private Date postDate;
	
	private String f_userId;
	
	/**
	 *  getters/setters for all the fields taken... 
	 */
	
	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

	public String getF_description() {
		return f_description;
	}

	public void setF_description(String f_description) {
		this.f_description = f_description;
	}

	public String getF_userId() {
		return f_userId;
	}

	public void setF_userId(String f_userId) {
		this.f_userId = f_userId;
	}
	
}
