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
public class ForumComment extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for User... 
	 */
	
	@Id
	private String fc_id;
	
	private String forumId;
		
	@Column(name = "forum_comment")
	private String comment;
	
	private String fc_userId;
	
	@Column(name = "commented_date")
	private Date commentDate;
	
	/**
	 *  getters/setters for all the fields taken... 
	 */
	
	
	public String getForumId() {
		return forumId;
	}
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getFc_id() {
		return fc_id;
	}
	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}
	public String getFc_userId() {
		return fc_userId;
	}
	public void setFc_userId(String fc_userId) {
		this.fc_userId = fc_userId;
	}
	
}
