package com.infotel.formation.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	 @Autowired
	 private AuthorDAO dao;
	 
	 
	 
	 
	public void insertAuthor(String firstNme, String lastName){
		 Author author = new Author(firstNme,lastName);
		 dao.insert(author);
	 }
	
		
	
	
}
