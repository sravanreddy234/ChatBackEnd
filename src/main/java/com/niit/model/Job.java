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
public class Job extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	/**
	 *  declare the database column names for Job... 
	 */

	@Id
	private String jobId;
	
	@Column(name = "company_name")
	private String companyName;
	
	private String location;
	
	private String description;
	
	@Column(name = "post_date")
	private Date date;
	
	/**
	 *  
	 *  getters/setters for all the fields taken... 
	 *  
	 */

	
	public String getCompanyName() {
		return companyName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
		
}
