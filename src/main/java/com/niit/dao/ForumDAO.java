package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Forum;
import com.niit.model.ForumComment;



@Repository		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public interface ForumDAO {

	/**
	 * Declare all CRUD Operations...
	 * 
	 */
	
	public boolean save(Forum forum);	
	public boolean saveComment(ForumComment forumComment);		//forumComment
	
	public boolean update(Forum forum);
		
	public boolean delete(Forum forum);
		
	public Forum get(int id);
	public ForumComment getComment(int id);			//forumComment
	
	public List<Forum> list();	
	public List<ForumComment> listComment(String id);		//forumComment
	
	//public Forum getLike(int id);
	//public Forum getCountComment(int id);
}