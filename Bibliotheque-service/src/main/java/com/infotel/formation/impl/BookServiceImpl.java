package com.infotel.formation.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.EditorDAO;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Autowired
	AuthorDAO authorDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	EditorDAO editorDAO;

	@Override
	public void insertBook(Book book) {
		bookDAO.insertBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);

	}

	@Override
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);

	}

	public Set<Book> getBooksByKeyword(String keyword) {

		Set<Book> rechercheLivre = new HashSet<Book>();

		for (Book book : bookDAO.getBooksByTitleDescript(keyword)) {
			rechercheLivre.add(book);
		}

		for (Category category : categoryDAO.getListCategoryByKeyword(keyword)) {
			for (Book book : bookDAO.getBooksByCategory(category)) {
				rechercheLivre.add(book);
			}
		}

		for (Editor editor : editorDAO.getListEditorByKeyword(keyword)) {
			for (Book book : bookDAO.getBooksByEditor(editor)) {
				rechercheLivre.add(book);
			}
		}

		for (Author author : authorDAO.getListAuthorByKeyword(keyword)) {
			for (Book book : bookDAO.getBooksByAuthor(author)) {
				rechercheLivre.add(book);
			}
		}

		return rechercheLivre;

	}


	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Override
	public List<Book> getRecommendedBooks() {
		return bookDAO.getRecommendedBooks();
	}

	@Override
	public Book getBookById(Long Id) {
		return bookDAO.getBookById(Id);
	}

}
