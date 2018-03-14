package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.entity.Borrow;
import com.infotel.formation.interfaces.BookCopyDAO;
import com.infotel.formation.interfaces.BorrowDAO;

@Controller
public class GestionBookController {
	@Autowired
	private BookCopyDAO bookcopyDAO;

	@Autowired
	private BorrowDAO borrowDAO;

	@RequestMapping("/gestionBook")
	public String recommendedBooks(Model model, HttpServletRequest request) {

		List<Borrow> listeBorrow = borrowDAO.getBorrows();
		List<BookCopy> listeBookCopy = new ArrayList<BookCopy>();
		for (Borrow borrow : listeBorrow) {
			for (BookCopy bookCopy : borrow.getBorrow_listeBookBopy()) {
				listeBookCopy.add(bookCopy);
			}

		}

		model.addAttribute("bookCopyList", listeBookCopy);
		return "BookGestion";
	}
}
