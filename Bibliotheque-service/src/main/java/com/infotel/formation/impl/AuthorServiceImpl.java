package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDAO authorDAO;

	public Author getAuthorById(long authorId) {
		return authorDAO.getAuthorById(authorId);
	}

}
