package com.infotel.formation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;
import com.infotel.formation.interfaces.AuthorService;

public class MainTestRequete {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		AuthorService authorService = (AuthorService) context.getBean("authorServiceImpl");
		System.out.println(authorService.getAuthorById(5L));
	}
}
