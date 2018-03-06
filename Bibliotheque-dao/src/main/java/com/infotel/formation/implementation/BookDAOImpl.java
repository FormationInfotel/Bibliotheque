package com.infotel.formation.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
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
	public List<Book> getBooksByCategory(Category CategoryID) {
		Query<Book> query = sessionFactory.getCurrentSession()
				.createQuery("from Book as b where b.book_category=:CategoryID");
		query.setParameter("CategoryID", CategoryID);
		System.out.println(query.list().size());
		return (List<Book>) query.getResultList();
	}

}