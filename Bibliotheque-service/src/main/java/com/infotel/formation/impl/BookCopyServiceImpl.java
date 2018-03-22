package com.infotel.formation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.interfaces.BookCopyDAO;
import com.infotel.formation.interfaces.BookCopyService;

@Service
@Transactional
public class BookCopyServiceImpl  implements BookCopyService{
	
	@Autowired
	BookCopyDAO bookcopyDAO;

	@Override
	public void insertBookCopy(BookCopy bookCopy) {
		bookcopyDAO.insertBookCopy(bookCopy);
	}

	@Override
	public void updateBookCopy(BookCopy bookCopy) {
		bookcopyDAO.updateBookCopy(bookCopy);
	}

	@Override
	public void deleteBookCopy(BookCopy bookCopy) {
		bookcopyDAO.deleteBookCopy(bookCopy);
	}

	@Override
	public BookCopy getBookCopyById(long bookCopyId) {
		return bookcopyDAO.getBookCopyById(bookCopyId);
	}

	@Override
	public BookCopy getBookCopy(String bookCopyName) {
		return bookcopyDAO.getBookCopy(bookCopyName);
	}

	@Override
	public List<BookCopy> getBookCopys() {
		return bookcopyDAO.getBookCopys();
	}

}
