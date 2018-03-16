package com.infotel.formation.impl;

import java.util.List;

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

	@Override
	public void insertAuthor(Author author) {
		authorDAO.insertAuthor(author);

	}

	@Override
	public void updateAuthor(Author author) {
		authorDAO.updateAuthor(author);

	}

	@Override
	public void deleteAuthor(Author author) {
		authorDAO.deleteAuthor(author);

	}

	@Override
	public List<Author> getAuthors() {
		return authorDAO.getAuthors();
	}

}
