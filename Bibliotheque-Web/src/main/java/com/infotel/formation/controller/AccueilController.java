package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;

@Controller
public class AccueilController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	BookMapper mapper;

	
	
	@GetMapping(value = "/")
	public List<BookDTO> recommendedBooks() {
		List<BookDTO> viewBook = new ArrayList<BookDTO>();
		
		List<Book> Books = bookService.getRecommendedBooks();
		
		for (Book book : Books) {
			viewBook.add(mapper.mapIntoBookDTO(book));
		}
	
		return viewBook;

//		model.addAttribute("recommendedBooks", bookService.getRecommendedBooks());
//		return "Accueil";
		
		
		
	}
}
