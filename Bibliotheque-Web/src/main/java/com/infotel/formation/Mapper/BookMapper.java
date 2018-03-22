package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.AuthorService;
import com.infotel.formation.interfaces.CategoryService;
import com.infotel.formation.interfaces.EditorService;

@Component
public class BookMapper {

	@Autowired
	AuthorService authorService;
	@Autowired
	EditorService editorService;
	@Autowired
	CategoryService categoryService;

	public Book mapIntoBook(BookDTO bookDTO) {
		Book book = new Book(bookDTO.getISBN(), bookDTO.getBook_title(), bookDTO.getBook_description(),
				bookDTO.getBook_price(), bookDTO.getPublication_date(), bookDTO.getImage_path(), bookDTO.isPopular_book());
		book.setBook_author(authorService.getAuthorById(bookDTO.getBook_authorId()));
		book.setBook_editor(editorService.getEditorById(bookDTO.getBook_editorId()));
		book.setBook_category(categoryService.getCategoryById(bookDTO.getBook_categoryId()));
		return (book);
	}

	public BookDTO mapIntoBookDTO(Book book) {
		BookDTO bookDTO = new BookDTO(book.getISBN(), book.getBook_title(), book.getBook_description(),
				book.getBook_price(), book.getPublication_date(), book.getImage_path(), book.isPopular_book());
		bookDTO.setISBN(book.getISBN());
		bookDTO.setBook_authorId(book.getBook_author().getAuthor_id());
		bookDTO.setBook_editorId(book.getBook_editor().getEditor_id());
		bookDTO.setBook_categoryId(book.getBook_category().getCategory_id());
		bookDTO.setAuthor_firstname(book.getBook_author().getAuthor_firstname());
		bookDTO.setAuthor_lastname(book.getBook_author().getAuthor_lastname());
		
		return bookDTO;
	}
}
