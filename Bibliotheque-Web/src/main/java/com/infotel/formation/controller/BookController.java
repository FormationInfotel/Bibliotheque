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
import com.infotel.formation.Mapper.BookMapper;
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

	BookMapper mapper;

	@GetMapping(value = "/book/get")
	public List<BookDTO> getBooks() {
		List<BookDTO> viewBooks = new ArrayList<BookDTO>();

		List<Book> books = bookService.getBooks();
		System.out.println(books);

		for (Book book : books) {

			viewBooks.add(mapper.mapIntoBookDTO(book));
		}
		return viewBooks;
	}

	@PostMapping(value = "/book/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addBook(@RequestBody BookDTO bookDTO) {

		bookService.insertBook(mapper.mapIntoBook(bookDTO));

		System.out.println("Insert done successfully");
	}

	@PostMapping(value = "/book/update/", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateBook(@RequestBody BookDTO bookDTO) {

		bookService.updateBook(mapper.mapIntoBook(bookDTO));
	}

	@PostMapping(value = "/book/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteBook(@RequestBody BookDTO bookDTO) {

		bookService.deleteBook(mapper.mapIntoBook(bookDTO));
	}

}
