package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Author;

public interface AuthorDAO extends _GenericDAO<Author>{
	void insertAuthor(Author author);

	public Author getAuthorById(long authorId);

	Author getAuthor(String authorName);

	List<Author> getAuthors();

	List<Author> getListAuthorByKeyword(String authorname);

}
