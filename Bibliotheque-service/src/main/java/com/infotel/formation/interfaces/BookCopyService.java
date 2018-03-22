package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.BookCopy;

public interface BookCopyService {

	public void insertBookCopy(BookCopy bookCopy) throws Exception;

	public void updateBookCopy(BookCopy bookCopy) throws Exception;

	public void deleteBookCopy(BookCopy bookCopy) throws Exception;

	public BookCopy getBookCopyById(long bookCopyId);

	BookCopy getBookCopy(String bookCopyName);

	List<BookCopy> getBookCopys() throws Exception;
}
