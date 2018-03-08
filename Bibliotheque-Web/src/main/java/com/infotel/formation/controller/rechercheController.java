package com.infotel.formation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Author;
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
		String motRecherche = request.getParameter("txboxRecherche");
		if (request.getParameter("checkTitre") != null) {
			model.addAttribute("ListeResultat", bookDAO.getBooksByTitle(motRecherche));
		} else if (request.getParameter("checkAutor") != null) {
			List<Author> listAuthor = authorDAO.getListAuthorByKeyword(motRecherche);
			for (Author author : listAuthor) {
				model.addAttribute("ListeResultat", bookDAO.getBooksByAuthor(author));
			}
		} else if (request.getParameter("checkEditor") != null) {
			List<Editor> listEdit = editorDAO.getListEditorByKeyword(motRecherche);
			for (Editor editor : listEdit) {
				model.addAttribute("ListeResultat", bookDAO.getBooksByEditor(editor));
			}
		} else if (request.getParameter("checkCategory") != null) {
			List<Category> listCat = categoryDAO.getListCategoryByKeyword(motRecherche);
			for (Category category : listCat) {
				model.addAttribute("ListeResultat", bookDAO.getBooksByCategory(category));
			}
		} else {
			model.addAttribute("ListeResultat", 0);
		}
		return "resultat";
	}

}
