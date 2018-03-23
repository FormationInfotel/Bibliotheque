package com.infotel.formation.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.BookDAO;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

	@Override
	public Book getBookById(long bookId) {
		Book bookById = null;

		for (Book book : getBooks()) {
			if (book != null && book.getISBN() > 0 && book.getISBN() == bookId) {
				bookById = book;
				break;
			}
		}
		return bookById;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Book getBook(String bookTitle) {

		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book where title = :bookTitle");
		query.setParameter("title", bookTitle);
		return (Book) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks() {
		List<Book> result = (List<Book>) sessionFactory.getCurrentSession().createQuery("from Book").list();
		for (Book book : result) {
			Hibernate.initialize(book.getBook_ListCopy());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getRecommendedBooks() {
		List<Book> listeBook = new ArrayList<Book>();
		listeBook = sessionFactory.getCurrentSession().createQuery("from Book as b where b.popular_book = true").list();
		return listeBook;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByTitleDescript(String keyword) {
		Query<Book> query = sessionFactory.getCurrentSession()
				.createQuery("from Book Where book_title LIKE :keyword OR book_description LIKE :keyword");

		query.setParameter("keyword", "%" + keyword + "%").list();
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByDescript(String keyword) {
		Query<Book> query = sessionFactory.getCurrentSession()
				.createQuery("from Book Where book_description LIKE :keyword");
		query.setParameter("keyword", "%" + keyword + "%").list();
		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByEditor(Editor editor) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_editor =:editor");
		query.setParameter("editor", editor).list();
		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByCategory(Category category) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_category=:category");
		query.setParameter("category", category).list();
		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByAuthor(Author author) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_author =:author");
		query.setParameter("author", author).list();

		return query.list();

	}

	
}
