package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotel.formation.interfaces.BookService;

@Controller
public class RecommendedBooksController {

	
	 @Autowired
	private BookService bookService;

	@RequestMapping("/recommendedBooks")
	public String recommendedBooks(Model model) {
		model.addAttribute("recommendedBooks", bookService.getRecommendedBooks());
		return "recommendedBooks";
	}

}