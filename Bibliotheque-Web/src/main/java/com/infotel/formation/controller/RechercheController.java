package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class RechercheController {

	@Autowired
	public BookService bookService;

	@Autowired
	BookMapper mapper;

	@PostMapping(value = "/resultat")
	public Resultat getBooks(@RequestBody String keyword) throws Exception {
		List<BookDTO> viewBooks = new ArrayList<BookDTO>();
		Set<Book> books = new HashSet<Book>();

		Resultat res = new Resultat();

		books = bookService.getBooksByKeyword(keyword);

		for (Book book : books) {
			viewBooks.add(mapper.mapIntoBookDTO(book));
		}

		res.setIsSucces(true);
		res.setMessage(ControllerConstants.RESEARCH_SUCCES);
		res.setPayload(viewBooks);

		return res;

	}

}
