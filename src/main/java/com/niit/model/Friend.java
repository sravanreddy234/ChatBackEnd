package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "b_friend")
@Component
public class Friend extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for User... 
	 */
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int f_id;
	
	private String f_userId;
	
	private String f_friendId;
	
	private String f_name;
	
	private String f_status;	//  new / accepted / rejected

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_userId() {
		return f_userId;
	}

	public void setF_userId(String f_userId) {
		this.f_userId = f_userId;
	}

	public String getF_friendId() {
		return f_friendId;
	}

	public void setF_friendId(String f_friendId) {
		this.f_friendId = f_friendId;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_status() {
		return f_status;
	}

	public void setF_status(String f_status) {
		this.f_status = f_status;
	}

	/**
	 *  getters/setters for all the fields taken... 
	 */
	
	
}
