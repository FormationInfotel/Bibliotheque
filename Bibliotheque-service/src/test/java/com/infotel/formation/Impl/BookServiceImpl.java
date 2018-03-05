package com.infotel.formation.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;

@Repository
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByRecommand() {
		List<Book> listeBook = new ArrayList<Book>();
		List<Book> result = (List<Book>) sessionFactory.getCurrentSession().createQuery("from Book").list();
		for (Book b : result) {
			if (b.isPopular_book() == true) {
				listeBook.add(b);
			}
		}
		return listeBook;
	}

}
