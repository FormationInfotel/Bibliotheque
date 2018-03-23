package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.DTO.MemberDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Member;
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
		//public List<BookDTO> getBooks(@PathVariable("keyword") String keyword) throws Exception {
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
		//return viewBooks;
	}

	// @GetMapping(value = "/research/{keyword}")
	// public Resultat research(@PathVariable("keyword") String keyword) throws
	// Exception {
	// List<BookDTO> viewBooks = new ArrayList<BookDTO>();
	// Resultat res = new Resultat();
	// HashSet<Book> books = new HashSet<Book>();
	//
	// try {
	//
	// books = (HashSet<Book>) bookService.getBooksByKeyword(keyword);
	//
	// for (Book book : books) {
	// viewBooks.add(mapper.mapIntoBookDTO(book));
	// }
	//
	// res.setIsSucces(true);
	// res.setMessage(ControllerConstants.UPDATE_SUCCESS);
	// res.setPayload(viewBooks);
	//
	// } catch (ServiceException serviceException) {
	// res.setIsSucces(false);
	// res.setMessage(serviceException.getMessage());
	// } catch (Exception e) {
	// res.setIsSucces(false);
	// res.setMessage("Err");
	// }
	//
	// System.out.println(viewBooks);
	// return res;
	// }

	// @RequestMapping(value = "/recherche", method = RequestMethod.GET)
	// public String rechercheBook(Model model) {
	// return "recherche";
	// }
	//
	// @RequestMapping(value = "/recherche", method = RequestMethod.POST)
	// private String resultatRecherche(HttpServletRequest request, Model model) {
	// List<Book> listeBook = new ArrayList<Book>();
	// if (request.getParameter("txboxRecherche") != "") {
	// String motTitre = request.getParameter("txboxRecherche");
	//
	// for (Book book : bookService.getBooksByKeyword(motTitre)) {
	// listeBook.add(book);
	// }
	// }
	//
	// if (listeBook.size() == 0) {
	// model.addAttribute("resultDefault", "Aucun résultat trouvé");
	// } else {
	// model.addAttribute("ListeResultat", listeBook);
	// }
	// return "Resultat";
	// }

}
