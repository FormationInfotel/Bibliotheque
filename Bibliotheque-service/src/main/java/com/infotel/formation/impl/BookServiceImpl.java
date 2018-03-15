package com.infotel.formation.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.EditorDAO;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	
	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	AuthorDAO authorDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	EditorDAO editorDAO;
	
	@SuppressWarnings("unchecked")
	public Set<Book> getBooksByKeyword(String keyword) {
		
		Set<Book> rechercheLivre = new HashSet<Book>();
					
		
		
		for (Book book : bookDAO.getBooksByTitleDescript(keyword)) {
			rechercheLivre.add(book);
		}
		
		for (Book book :bookDAO.getBooksByCategory(categoryDAO.getCategory(keyword))) {
			rechercheLivre.add(book);
		}
		
		for (Book book : bookDAO.getBooksByEditor(editorDAO.getEditor(keyword))) {
			rechercheLivre.add(book);
		}
		
		for (Book book : bookDAO.getBooksByAuthor(authorDAO.getAuthor(keyword))) {
			rechercheLivre.add(book);
		}		
				
		
		
		return rechercheLivre;
		
	}

}
