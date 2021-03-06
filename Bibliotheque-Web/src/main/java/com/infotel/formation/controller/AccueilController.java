package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class AccueilController {

	@Autowired
	BookService bookService;

	@Autowired
	BookMapper mapper;

	@GetMapping(value = "/recommendedbooks")
	public Resultat recommendedBooks() {
		List<BookDTO> viewBook = new ArrayList<BookDTO>();
		List<Book> Books = bookService.getRecommendedBooks();
		Resultat res = new Resultat();

		for (Book book : Books) {
			viewBook.add(mapper.mapIntoBookDTO(book));
		}

		res.setIsSucces(true);
		res.setMessage(ControllerConstants.RECOMMENDED_BOOKS_FOUND);
		res.setPayload(viewBook);

		return res;

	}
}
