package com.infotel.formation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.CategoryDAO;

public class MainTestRequete {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		BookDAO userManagerBook = (BookDAO) context.getBean("bookServiceImpl");
		CategoryDAO userManagerCategory = (CategoryDAO) context.getBean("categoryDAOImpl");
		System.out.println(userManagerBook.getBooksByCategory(userManagerCategory.getCategoryById(7)));
	}

}
