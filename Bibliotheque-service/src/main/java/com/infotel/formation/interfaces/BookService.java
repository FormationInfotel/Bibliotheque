package com.infotel.formation.interfaces;

import java.util.List;
import java.util.Set;

import com.infotel.formation.entity.Book;

public interface BookService {
	
	public Set<Book> getBooksByKeyword(String keyword);

	public void insertBook(Book book);

	List<Book> getBooks();


}
