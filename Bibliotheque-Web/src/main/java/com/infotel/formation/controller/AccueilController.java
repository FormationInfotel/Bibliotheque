package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotel.formation.interfaces.BookService;

@Controller
public class AccueilController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping(value = "/")
	public String recommendedBooks(Model model) {
		model.addAttribute("recommendedBooks", bookService.getRecommendedBooks());
		return "Accueil";
	}
}
