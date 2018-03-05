package com.infotel.formation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		// AuthorDAO userManager = (AuthorDAO) context.getBean("authorDAOImpl");
		// Author auteur = new Author("LEVEL", "LAURENE");
		// userManager.insertAuthor(auteur);
		// System.out.println("Autheur inséré");

	}

}
