package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;


@Controller
public class rechercheController {


	@Autowired
	public BookService bookService;

	@RequestMapping(value = "/recherche", method = RequestMethod.GET)
	public String rechercheBook(Model model) {
		return "recherche";
	}

	@RequestMapping(value = "/recherche", method = RequestMethod.POST)
	private String resultatRecherche(HttpServletRequest request, Model model) {
		List<Book> listeBook = new ArrayList<Book>();
		if (request.getParameter("txboxRecherche") != "") {
			String motTitre = request.getParameter("txboxRecherche");

			for (Book book : bookService.getBooksByKeyword(motTitre)) {
				listeBook.add(book);
			}
		}

		if (listeBook.size() == 0) {
			model.addAttribute("resultDefault", "Aucun résultat trouvé");
		} else {
			model.addAttribute("ListeResultat", listeBook);
		}
		return "Resultat";
	}

}
