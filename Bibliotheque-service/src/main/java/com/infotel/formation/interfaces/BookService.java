package com.infotel.formation.interfaces;

import java.util.List;
import java.util.Set;

import com.infotel.formation.entity.Book;

public interface BookService {
	
	public Set<Book> getBooksByKeyword(String keyword) throws Exception;

	public void insertBook(Book book) throws Exception;

	public void updateBook(Book book) throws Exception;

	public void deleteBook(Book book) throws Exception;
	
	public Book getBookById(long Id) throws Exception;

	public List<Book> getRecommendedBooks();

	List<Book> getBooks() throws Exception;


}
