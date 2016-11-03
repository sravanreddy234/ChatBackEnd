package com.niit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/* declare the database column names for User... */
	
	@Id
	@Length(min = 6, max = 11, message = "Id should contain 6-11 characters")
	private String userId;
	
	@NotBlank(message = "Name field can not be blank")
	@Length(min = 3 , message = "Name contains atleast 3 character")
	private String userName;
	
	@NotBlank(message="Please select a password")
	@Length(min=5, max=15, message="Password should be between 5 - 15 charactes")
	private String userPassword;
	
	@NotBlank
	private String UserGender;
	
	@Email(message="Please provide a valid email address")
	private String UserEmail;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "Please provide a valid phone no.")
	private String UserContact;
	
	private String UserRole;
	
	private String u_image;
	
	private String u_pics;
	
	@Transient
	private MultipartFile file;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	Set<Blog> blog;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	Set<Forum> forum;

	/* getters/setters for all the fields taken... */
		
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return UserGender;
	}

	public void setUserGender(String userGender) {
		UserGender = userGender;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserContact() {
		return UserContact;
	}

	public void setUserContact(String userContact) {
		UserContact = userContact;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}

	public String getU_pics() {
		return u_pics;
	}

	public void setU_pics(String u_pics) {
		this.u_pics = u_pics;
	}

	
	
}
