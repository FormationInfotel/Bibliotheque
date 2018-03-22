package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.BookCopyDTO;
import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.interfaces.BookService;

@Component
public class BookCopyMapper {

	@Autowired
	BookService bookService;

	public BookCopy mapIntoBookCopy(BookCopyDTO bookCopyDTO) {
		BookCopy bookcopy = new BookCopy(bookCopyDTO.getISBN(), bookCopyDTO.getCopy_title(),
				bookService.getBookById(bookCopyDTO.getBookcopy_parentId()));
		return bookcopy;
	}

	public BookCopyDTO mapIntoBookCopyDTO(BookCopy bookcopy) {
		BookCopyDTO bookcopyDTO = new BookCopyDTO(bookcopy.getISBN(), bookcopy.getCopy_title(),
				bookcopy.getBookcopy_parent().getISBN());
		return bookcopyDTO;
	}
}
