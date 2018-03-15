package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(value = "/book/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addBook(@RequestBody BookDTO bookDTO) {
		Book book = new Book(bookDTO.getISBN(), bookDTO.getBook_title(), bookDTO.getBook_description(),
				bookDTO.getBook_price(), null, bookDTO.isPopular_book());
		book.setBook_author(authorService.getAuthorById(bookDTO.getBook_authorId()));
		book.setBook_category(categoryService.getCategoryById(bookDTO.getBook_categoryId()));
		book.setBook_editor(editorService.getEditorById(bookDTO.getBook_editorId()));

		bookService.insertBook(book);

		System.out.println("Insert done successfully");
	}

	@GetMapping(value = "/book/get")
	public List<BookDTO> getBooks() {
		List<BookDTO> viewBooks = new ArrayList<BookDTO>();
		
		List<Book> books = bookService.getBooks();
		
		for (Book book : books) {
			viewBooks.add(new BookDTO(book.getISBN(), book.getBook_title(), book.getBook_description(),
					book.getBook_price(), book.getPublication_date(), book.getImage_path(), book.isPopular_book()));

		}
		return viewBooks;
	}

}
