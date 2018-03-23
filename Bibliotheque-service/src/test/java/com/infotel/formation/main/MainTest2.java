package com.infotel.formation.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;
import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookDAO;
@SuppressWarnings("unused")
public class MainTest2 {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		
		AuthorDAO userManager = (AuthorDAO) context.getBean("authorDAOImpl");
		 Author auteur = new Author("LEVEL", "LAURENE");
		// userManager.insertAuthor(auteur);

		 //System.out.println(userManager.getAuthors());
		 	 
		 //System.out.println("Autheur inséré");
		 
//		 AuthorService a = (AuthorService) context.getBean("authorServiceImpl");
//		 Author auteur2 = new Author("JEAN", "HERVE");
//		 a.insertAuthor("jean","hervé");
//		 userManager.insertAuthor(auteur2);
//		 System.out.println("Autheur inséré");
//		 
		 
		 Book test = new Book();
		 
		 List<Book> listeLivre = new ArrayList<Book>();
		 
		 
		 BookDAO livre = (BookDAO) context.getBean("bookDAOImpl");
		// listeLivre = livre.getBooksByKeywordTitle("Harry");
		 
		// listeLivre = livre.getBooksByKeywordDescript("synopsis");
		 
		 Author aut1 = new Author("test","test");
		 		 
		 AuthorDAO auteurDAO = (AuthorDAO) context.getBean("authorDAOImpl");
		 
		 auteurDAO.insert(aut1);
		 
		 listeLivre.forEach(book->System.out.println(book.getBook_author().getAuthor_lastname()));
		 
		 
		  //listeLivre.forEach(book->System.out.println(book.getBook_author().getAuthor_lastname()));
		 //listeLivre = livre.getBooksByAuthor("TOLKIEN");
		 
		 System.out.println(listeLivre);
		 
		
		 
		 
		 System.out.println("ok");
		 
		
		 
		
		 
		 
		 
		 
		 
	}

}
