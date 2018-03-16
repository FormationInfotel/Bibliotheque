package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Author;

public interface AuthorService {

	public Author getAuthorById(long authorId);

	public void insertAuthor(Author author);

	public void updateAuthor(Author author);

	public void deleteAuthor(Author author);

	public List<Author> getAuthors();
}
