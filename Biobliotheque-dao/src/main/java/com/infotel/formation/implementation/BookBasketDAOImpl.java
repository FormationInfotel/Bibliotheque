package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.BookBasket;
import com.infotel.formation.interfaces.BookBasketDAO;


@Repository
@Transactional
public class BookBasketDAOImpl implements BookBasketDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void insertBookBasket(BookBasket bookBasket) {
		sessionFactory.getCurrentSession().save(bookBasket);
		
	}

	@Override
	public BookBasket getBookBasketById(int bookBasketId) {
		BookBasket bookBasketById = null;

		for (BookBasket  bookBasket : getBookBaskets()) {
			if (bookBasket != null && bookBasket.getBook_basket_id() > 0) {
				bookBasketById = bookBasket;
				break;
			}
		}

		if (bookBasketById == null) {
			throw new IllegalArgumentException("No book basket found with the id : " + bookBasketId);
		}
		return bookBasketById;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BookBasket> getBookBaskets() {
		
		List<BookBasket> result = (List<BookBasket>) sessionFactory.getCurrentSession().createQuery("from BookBasket").list();
		return result;
	}

}
