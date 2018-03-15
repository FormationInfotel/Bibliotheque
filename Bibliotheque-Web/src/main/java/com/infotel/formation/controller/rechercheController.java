package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.EditorDAO;

@Controller
public class rechercheController {
	@Autowired
	public BookDAO bookDAO;
	@Autowired
	public EditorDAO editorDAO;
	@Autowired
	public CategoryDAO categoryDAO;
	@Autowired
	public AuthorDAO authorDAO;

	@RequestMapping(value = "/Recherche", method = RequestMethod.GET)
	public String rechercheBook(Model model) {
		return "recherche";
	}

	@RequestMapping(value = "/Recherche", method = RequestMethod.POST)
	private String resultatRecherche(HttpServletRequest request, Model model) {
		List<Book> listeBook = new ArrayList<Book>();
		if (request.getParameter("txboxTitre") != "") {
			String motTitre = request.getParameter("txboxTitre");
			System.out.println(bookDAO.getBooksByTitleDescript(motTitre));
			for (Book book : bookDAO.getBooksByTitleDescript(motTitre)) {
				listeBook.add(book);
			}

		}
		if (request.getParameter("txboxAuthor") != "") {
			String motAuthor = request.getParameter("txboxAuthor");
			List<Author> listAuthor = authorDAO.getListAuthorByKeyword(motAuthor);
			for (Author author : listAuthor) {
				for (Book book : bookDAO.getBooksByAuthor(author)) {
					listeBook.add(book);
				}
			}
		}
		if (request.getParameter("txboxEditor") != "") {
			String motEditor = request.getParameter("txboxEditor");
			List<Editor> listEdit = editorDAO.getListEditorByKeyword(motEditor);
			for (Editor editor : listEdit) {
				for (Book book : bookDAO.getBooksByEditor(editor)) {
					listeBook.add(book);
				}
			}
		}
		if (request.getParameter("txboxCategory") != "") {
			String motCategory = request.getParameter("txboxCategory");
			List<Category> listCat = categoryDAO.getListCategoryByKeyword(motCategory);
			for (Category category : listCat) {
				for (Book book : bookDAO.getBooksByCategory(category)) {
					listeBook.add(book);
				}
			}
		}

		if (listeBook.size() == 0) {
			model.addAttribute("resultDefault", "Aucun résultat trouvé");
		} else {
			model.addAttribute("ListeResultat", listeBook);
		}
		return "Resultat";
	}
	
	
	// @RequestMapping(value = "/Recherche", method = RequestMethod.POST)
	// private String resultatRecherche2(HttpServletRequest request, Model model) {
	// List<Book> listeBook = new ArrayList<Book>();
	// if (request.getParameter("txboxTitre") != "") {
	// String motTitre = request.getParameter("txboxTitre");
	// System.out.println(bookDAO.getBooksByTitleDescript(motTitre));
	// for (Book book : bookDAO.getBooksByTitleDescript(motTitre)) {
	// listeBook.add(book);
	// }
	//
	// }
	//
	//
	// if (listeBook.size() == 0) {
	// model.addAttribute("resultDefault", "Aucun résultat trouvé");
	// } else {
	// model.addAttribute("ListeResultat", listeBook);
	// }
	// return "Resultat";
	// }

}
