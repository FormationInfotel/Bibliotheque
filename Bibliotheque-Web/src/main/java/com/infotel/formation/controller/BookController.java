package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.AuthorService;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.interfaces.CategoryService;
import com.infotel.formation.interfaces.EditorService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	AuthorService authorService;
	@Autowired
	EditorService editorService;
	@Autowired
	CategoryService categoryService;

	@PostMapping("/book/add")
	public void addBook(@RequestBody BookDTO bookDTO) {
		Book book = new Book(bookDTO.getISBN(), bookDTO.getBook_title(), bookDTO.getBook_description(),
				bookDTO.getBook_price(), bookDTO.getPublication_date(), bookDTO.isPopular_book());
		book.setBook_author(authorService.getAuthorById(bookDTO.getBook_authorId()));
		book.setBook_category(categoryService.getCategoryById(bookDTO.getBook_categoryId()));
		book.setBook_editor(editorService.getEditorById(bookDTO.getBook_editorId()));
	}
}
