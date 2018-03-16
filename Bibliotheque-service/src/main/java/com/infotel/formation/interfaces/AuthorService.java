package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Author;

public interface AuthorService {

	public Author getAuthorById(long authorId);

	public void insertAuthor(Author author) throws Exception;

	public void updateAuthor(Author author) throws Exception;

	public void deleteAuthor(Author author) throws Exception;

	public List<Author> getAuthors();
}
