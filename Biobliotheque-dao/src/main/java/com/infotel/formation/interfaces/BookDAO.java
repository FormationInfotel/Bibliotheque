package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;

public interface BookDAO {
	void insertBook(Book book);

	public Book getBookById(int bookId);

	Book getBook(String bookTitle);

	List<Book> getBooks();

	public List<Book> getBooksByRecommand();

	public List<Book> getBooksByCategory(Category CategoryID);

}
