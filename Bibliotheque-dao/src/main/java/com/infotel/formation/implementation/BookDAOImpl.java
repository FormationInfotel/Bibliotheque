package com.infotel.formation.implementation;

import java.util.ArrayList;
import java.util.List;

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
	public Book getBookById(int bookId) {
		Book bookById = null;

		for (Book book : getBooks()) {
			if (book != null && book.getISBN() > 0) {
				bookById = book;
				break;
			}
		}

		if (bookById == null) {
			throw new IllegalArgumentException("No product found with the product id : " + bookId);
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
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByRecommand() {
		List<Book> listeBook = new ArrayList<Book>();
		listeBook = sessionFactory.getCurrentSession().createQuery("from Book as b where b.popular_book = true").list();
		return listeBook;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByTitle(String keyword) {
		Query<Book> query = sessionFactory.getCurrentSession()
				.createQuery("from Book Where book_title LIKE :keyword OR book_description LIKE :keyword");

		query.setParameter("keyword", "%" + keyword + "%").list();

		if (query.list().isEmpty()) {
			throw new IllegalArgumentException("No book found with the keyword : " + keyword);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByDescript(String keyword) {
		Query<Book> query = sessionFactory.getCurrentSession()
				.createQuery("from Book Where book_description LIKE :keyword");
		query.setParameter("keyword", "%" + keyword + "%").list();

		if (query.list().isEmpty()) {

			throw new IllegalArgumentException("No book found with the keyword : " + keyword);
		}

		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByEditor(Editor editor) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_editor =:editor");
		query.setParameter("editor", editor).list();

		if (query.list().isEmpty()) {

			throw new IllegalArgumentException("No book found");
		}

		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByCategory(Category category) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_category=:category");
		List<Book> list = query.setParameter("category", category).list();

		System.out.println(list.size());
		if (list.isEmpty()) {

			throw new IllegalArgumentException("No book found ");
		}

		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByAuthor(Author author) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book Where book_author =:author");
		query.setParameter("author", author).list();

		if (query.list().isEmpty()) {

			throw new IllegalArgumentException("No book found");
		}

		return query.list();

	}

	// @Override
	// public List<Book> getBooksByAuthor(String author) {
	// List<Book> listeBook = new ArrayList<Book>();
	// Query<Book> query = sessionFactory.getCurrentSession().createQuery("from Book
	// as b inner join Author as a on a.author_id = b.book_author Where
	// author_firstname = :author OR author_lastname = :author ORDER BY
	// author_lastname asc" );
	// query.setParameter("author", author).list();
	//
	// if (query.list().isEmpty()) {
	//
	// throw new IllegalArgumentException("No product found with the keyword : " +
	// author);
	// }
	//
	// return query.list();
	// // }
	//
	// @SuppressWarnings("unchecked")
	// public List<Book> getBooksByCategory(Category CategoryID) {
	// Query<Book> query = sessionFactory.getCurrentSession()
	// .createQuery("from Book as b where b.book_category=:CategoryID");
	// query.setParameter("CategoryID", CategoryID);
	// System.out.println(query.list().size());
	// return (List<Book>) query.getResultList();
	// }

}
