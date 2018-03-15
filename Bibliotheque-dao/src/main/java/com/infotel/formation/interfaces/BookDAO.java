package com.infotel.formation.interfaces;

import java.util.List;
import java.util.Set;

import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;

public interface BookDAO {
	void insertBook(Book book);

	public Book getBookById(int bookId);

	Book getBook(String bookTitle);

	List<Book> getBooks();

	public List<Book> getBooksByRecommand();

	public List<Book> getBooksByTitleDescript(String keyword);

	public List<Book> getBooksByDescript(String keyword);

	public List<Book> getBooksByEditor(Editor editor);

	public List<Book> getBooksByCategory(Category category);

	public List<Book> getBooksByAuthor(Author author);

}
