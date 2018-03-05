package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Bookshelf;


public interface BookshelfDAO {
	
	void insertAuthor(Bookshelf bookshelf);

	public Bookshelf getBookshelfById(int bookshelfId);

	Bookshelf getBookshelf(String bookshelfName);

	List<Bookshelf> getBookshelfs();

}
