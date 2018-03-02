package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Author;

public interface AuthorDAO {
	void insertAuthor(Author author);

	public Author getAuthorById(int authorId);

	Author getAuthor(String authorName);

	List<Author> getAuthors();

}
