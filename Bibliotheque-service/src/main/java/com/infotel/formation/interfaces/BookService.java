package com.infotel.formation.interfaces;

import java.util.Set;

import com.infotel.formation.entity.Book;

public interface BookService {
	
	public Set<Book> getBooksByKeyword(String keyword);


}
