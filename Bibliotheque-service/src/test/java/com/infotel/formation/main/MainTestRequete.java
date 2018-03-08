package com.infotel.formation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;
import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.EditorDAO;

public class MainTestRequete {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		BookDAO userManagerBook = (BookDAO) context.getBean("bookDAOImpl");
		AuthorDAO userManagerAuthor = (AuthorDAO) context.getBean("authorDAOImpl");
		EditorDAO userManagerEditor = (EditorDAO) context.getBean("editorDAOImpl");
		CategoryDAO userManagerCategory = (CategoryDAO) context.getBean("categoryDAOImpl");

		System.out.println("recherche par titre :");
		String strTitle = "Harry";
		System.out.println(userManagerBook.getBooksByTitle(strTitle));
		System.out.println("recherche descript");
		String strDesc = "anneau";
		System.out.println(userManagerBook.getBooksByDescript(strDesc));

		System.out.println("recherche editor");
		String strEditor = "Milady";
		List<Editor> listEdit = userManagerEditor.getListEditorByKeyword(strEditor);
		for (Editor editor2 : listEdit) {
			System.out.println(userManagerBook.getBooksByEditor(editor2));
		}

		System.out.println("recherche author");
		String strAuthor = "TOLKIEN";
		List<Author> listAuthor = userManagerAuthor.getListAuthorByKeyword(strAuthor);
		for (Author author : listAuthor) {
			System.out.println(userManagerBook.getBooksByAuthor(author));
		}

		System.out.println("recherche category");
		String strCategory = "Fantasy";
		List<Category> listCat = userManagerCategory.getListCategoryByKeyword(strCategory);
		for (Category category : listCat) {
			System.out.println(userManagerBook.getBooksByCategory(category));
		}
	}
}
