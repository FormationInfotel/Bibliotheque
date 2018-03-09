package com.infotel.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultatController {

	@RequestMapping("/resultat")
	public String recommendedBooks() {
		return "Resultat";
	}

}
