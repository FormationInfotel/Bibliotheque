package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.BookCopy;

public interface BookCopyDAO {
	public void insertBookCopy(BookCopy bookCopy);

	public void updateBookCopy(BookCopy bookCopy);

	public void deleteBookCopy(BookCopy bookCopy);

	public BookCopy getBookCopyById(long bookCopyId);

	BookCopy getBookCopy(String bookCopyName);

	List<BookCopy> getBookCopys();
}
