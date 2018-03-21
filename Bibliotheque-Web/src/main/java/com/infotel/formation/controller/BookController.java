package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@Autowired
	BookMapper mapper;

	
	
	@GetMapping(value = "/book/get")
	public List<BookDTO> getBooks() {
		List<BookDTO> viewBooks = new ArrayList<BookDTO>();

		List<Book> books = bookService.getBooks();

		for (Book book : books) {
			viewBooks.add(mapper.mapIntoBookDTO(book));
		}
		return viewBooks;
	}

	@PutMapping(value = "/book/add") //,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addBook(@RequestBody BookDTO bookDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			bookService.insertBook(mapper.mapIntoBook(bookDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(bookDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/book/update")//,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateBook(@RequestBody BookDTO bookDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			//bookService.updateBook(mapper.mapIntoBook(bookDTO));
			//bookService.deleteBook(mapper.mapIntoBook(bookDTO));
			bookService.deleteBook(bookService.getBookById(bookDTO.getISBN()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(bookDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/book/delete")//,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteBook(@RequestBody BookDTO bookDTO) {
		Resultat res = new Resultat();
		try {
			bookService.deleteBook(bookService.getBookById(bookDTO.getISBN()));
			
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.DELETE_SUCCESS);
			res.setPayload(bookDTO);
		
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}
}
