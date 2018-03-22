package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.BookBasket;


public interface BookBasketDAO {
	
	void insertBookBasket(BookBasket bookBasket);
	
	void updateBookBasket(BookBasket bookBasket);
	
	void deleteBookBasket(BookBasket bookBasket);
	
	public BookBasket getBookBasketById(int bookBasketId);
	
	List<BookBasket> getBookBaskets();

}
