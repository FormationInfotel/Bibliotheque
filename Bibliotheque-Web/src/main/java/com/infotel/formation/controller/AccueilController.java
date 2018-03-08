package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotel.formation.interfaces.BookDAO;

@Controller
public class AccueilController {
	@Autowired
	private BookDAO bookDao;
	@RequestMapping("/")
	public String recommendedBooks(Model model) {
		model.addAttribute("recommendedBooks", bookDao.getBooksByRecommand());
		return "Accueil";
	}
}
