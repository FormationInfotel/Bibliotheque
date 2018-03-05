package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.BookCopy;

public interface BookCopyDAO {
	void insertBookCopy(BookCopy bookCopy);

	public BookCopy getBookCopyById(int bookCopyId);

	BookCopy getBookCopy(String bookCopyName);

	List<BookCopy> getBookCopys();
}
