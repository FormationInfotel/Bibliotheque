package com.infotel.formation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotel.formation.conteneur.ConteneurSpringFullJava;
import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.entity.Bookshelf;
import com.infotel.formation.entity.Catalog;
import com.infotel.formation.entity.Category;
import com.infotel.formation.entity.Editor;
import com.infotel.formation.entity.Library;
import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.AuthorDAO;
import com.infotel.formation.interfaces.BookCopyDAO;
import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.BookshelfDAO;
import com.infotel.formation.interfaces.CatalogDAO;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.EditorDAO;
import com.infotel.formation.interfaces.LibraryDAO;
import com.infotel.formation.interfaces.MemberDAO;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ConteneurSpringFullJava.class);

		///////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES AUTEURS DANS LA BASE ///////////////////////
		///////////////////////////////////////////////////////////////////////////////
		AuthorDAO userManagerAuthor = (AuthorDAO) context.getBean("authorDAOImpl");
		Author auteur1 = new Author("ROWLINGS", "J K");
		Author auteur2 = new Author("TOLKIEN", "");
		Author auteur3 = new Author("Recettes", "");
		Author auteur4 = new Author("Martin", "Georges R");
		Author auteur5 = new Author("Les Nuls", "");
		userManagerAuthor.insertAuthor(auteur1);
		userManagerAuthor.insertAuthor(auteur2);
		userManagerAuthor.insertAuthor(auteur3);
		userManagerAuthor.insertAuthor(auteur4);
		userManagerAuthor.insertAuthor(auteur5);
		System.out.println("Auteurs inséré");

		////////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES EDITEURS DANS LA BASE ///////////////////////
		////////////////////////////////////////////////////////////////////////////////
		EditorDAO userManagerEditeur = (EditorDAO) context.getBean("editorDAOImpl");
		Editor e1 = new Editor("Bargelonne", "Paris");
		Editor e2 = new Editor("Milady", "Paris");
		Editor e3 = new Editor("France-Loisir", "Paris");
		Editor e4 = new Editor("Michel", "PasICI");
		Editor e5 = new Editor("Milan", "New York");
		userManagerEditeur.insertEditor(e1);
		userManagerEditeur.insertEditor(e2);
		userManagerEditeur.insertEditor(e3);
		userManagerEditeur.insertEditor(e4);
		userManagerEditeur.insertEditor(e5);
		System.out.println("Editeurs inséré");

		////////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES CATEGORY DANS LA BASE ///////////////////////
		////////////////////////////////////////////////////////////////////////////////
		CategoryDAO userManagerCategory = (CategoryDAO) context.getBean("categoryDAOImpl");
		Category c1 = new Category("Philosophie",
				"Textes regroupant les textes philosophiques de nos époques et d'autre");
		Category c2 = new Category("Perdiodique", "Les périodiques");
		Category c3 = new Category("Cuisine", "La cuisine pour les débutants et confirmés");
		Category c4 = new Category("Fantastique", "Un élément surnaturel dans un monde réel");
		Category c5 = new Category("Fantasy", "Un monde créé de toute pièce");
		userManagerCategory.insertCategory(c1);
		userManagerCategory.insertCategory(c2);
		userManagerCategory.insertCategory(c3);
		userManagerCategory.insertCategory(c4);
		userManagerCategory.insertCategory(c5);
		System.out.println("Category inséré");

		////////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES LIBRARY DANS LA BASE ////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		LibraryDAO userManagerLibrary = (LibraryDAO) context.getBean("libraryDAOImpl");
		Library l1 = new Library("Mediathèque Angers", "Le QUAI, ANGERS");
		Library l2 = new Library("Bibliothèque Rennes", "Rue du Mail, Rennes");
		Library l3 = new Library("Bibliothèque Brest", "Dans l'eau, Brest");
		Library l4 = new Library("Bibliothèque Municipale Nantes", "Rue Gamin, Nantes");
		Library l5 = new Library("Médiathèque Le Mans", "rue de Torcé, Le Mans");
		userManagerLibrary.insertLibrary(l1);
		userManagerLibrary.insertLibrary(l2);
		userManagerLibrary.insertLibrary(l3);
		userManagerLibrary.insertLibrary(l4);
		userManagerLibrary.insertLibrary(l5);
		System.out.println("Library inséré");

		////////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES CATALOG DANS LA BASE ////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		CatalogDAO userManagerCatalog = (CatalogDAO) context.getBean("catalogDAOImpl");
		Catalog cat1 = new Catalog("Newsletter", l1);
		Catalog cat2 = new Catalog("Nouveauté", l2);
		Catalog cat3 = new Catalog("Newsletter", l3);
		Catalog cat4 = new Catalog("Mai 2018", l4);
		Catalog cat5 = new Catalog("Newsletter", l5);
		userManagerCatalog.insertCatalog(cat1);
		userManagerCatalog.insertCatalog(cat2);
		userManagerCatalog.insertCatalog(cat3);
		userManagerCatalog.insertCatalog(cat4);
		userManagerCatalog.insertCatalog(cat5);
		System.out.println("Catalog insérés");

		////////////////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES BOOKS DANS LA BASE //////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		BookDAO userManagerBook = (BookDAO) context.getBean("bookDAOImpl");
		Book b1 = new Book(00001110L, "Les recettes les plus simples du monde",
				"Des recettes pour les débutants, peu d'ingrédients et pas cher", new Float(22.50), "01/01/18", true);
		Book b2 = new Book(00001120L, "Harry Potter 1", "synopsis", new Float(25), "01/01/18", false);
		Book b3 = new Book(00001130L, "Les seigneur des Anneaux", "Un anneau pour les gouverner tous !", new Float(12),
				"01/01/18", false);
		Book b4 = new Book(00001140L, "Game of Thrones - Intégrale 1", "Longue histoire, adaptée en Série",
				new Float(30), "01/01/18", true);
		Book b5 = new Book(00001140L, "Freud pour les Nuls", "La philosophie pour les débutants", new Float(18),
				"01/01/18",
				false);

		b1.setImage_path("1");
		b2.setImage_path("2");
		b3.setImage_path("3");
		b4.setImage_path("4");
		b5.setImage_path("5");

		b1.setBook_author(auteur3);
		b1.setBook_category(c3);
		b1.setBook_catalog(cat1);
		b1.setBook_editor(e4);

		b2.setBook_author(auteur1);
		b2.setBook_category(c4);
		b2.setBook_catalog(cat4);
		b2.setBook_editor(e1);

		b3.setBook_author(auteur2);
		b3.setBook_category(c2);
		b3.setBook_catalog(cat5);
		b3.setBook_editor(e4);

		b4.setBook_author(auteur4);
		b4.setBook_category(c2);
		b4.setBook_catalog(cat1);
		b4.setBook_editor(e2);

		b5.setBook_author(auteur5);
		b5.setBook_category(c2);
		b5.setBook_catalog(cat1);
		b5.setBook_editor(e3);

		userManagerBook.insertBook(b1);
		userManagerBook.insertBook(b2);
		userManagerBook.insertBook(b3);
		userManagerBook.insertBook(b4);
		userManagerBook.insertBook(b5);
		System.out.println("Books insérés");

		//////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES BOOKCOPY //////////////////////////
		//////////////////////////////////////////////////////////////////////
		BookCopyDAO userManagerBookCopy = (BookCopyDAO) context.getBean("bookCopyDAOImpl");
		BookCopy bc1 = new BookCopy(00001111L, "Les recettes les plus simples du monde", b1);
		BookCopy bc2 = new BookCopy(00001112L, "Les recettes les plus simples du monde", b1);
		BookCopy bc3 = new BookCopy(00001113L, "Les recettes les plus simples du monde", b1);
		BookCopy bc4 = new BookCopy(00001121L, "Harry Potter 1", b2);
		BookCopy bc5 = new BookCopy(00001121L, "Harry Potter 1", b2);
		BookCopy bc6 = new BookCopy(00001121L, "Harry Potter 1", b2);
		BookCopy bc7 = new BookCopy(00001141L, "Game of Thrones - Intégrale 1", b4);
		BookCopy bc8 = new BookCopy(00001142L, "Game of Thrones - Intégrale 1", b4);
		BookCopy bc9 = new BookCopy(00001143L, "Game of Thrones - Intégrale 1", b4);

		// ajout des copy dans la liste dans le livre
		b1.getBook_ListCopy().add(bc1);
		b1.getBook_ListCopy().add(bc2);
		b1.getBook_ListCopy().add(bc3);
		b2.getBook_ListCopy().add(bc4);
		b2.getBook_ListCopy().add(bc5);
		b2.getBook_ListCopy().add(bc6);
		b4.getBook_ListCopy().add(bc7);
		b4.getBook_ListCopy().add(bc8);
		b4.getBook_ListCopy().add(bc9);
		System.out.println("Copy de Book insérés");

		///////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES BOOKSHELF //////////////////////////
		///////////////////////////////////////////////////////////////////////
		BookshelfDAO userManagerBookShelf = (BookshelfDAO) context.getBean("bookshelfDAOImpl");
		Bookshelf bk1 = new Bookshelf("Rayon 1 - Fantasy", "Les livres de Fantasy", 10);
		Bookshelf bk2 = new Bookshelf("Rayon 2 - Cuisine", "Les livres de Cuisine", 10);
		Bookshelf bk3 = new Bookshelf("Rayon 3 - Histoire", "Les livres de Histoire", 10);
		Bookshelf bk4 = new Bookshelf("Rayon 4 - Philosophie", "Les livres de Philosophie", 10);
		Bookshelf bk5 = new Bookshelf("Rayon 5 - Fantastique", "Les livres de Fantastique", 10);
		userManagerBookShelf.insertBookShelf(bk1);
		userManagerBookShelf.insertBookShelf(bk2);
		userManagerBookShelf.insertBookShelf(bk3);
		userManagerBookShelf.insertBookShelf(bk4);
		userManagerBookShelf.insertBookShelf(bk5);

		// mise en rayon des copies
		bc1.setBookcopy_bookshelf(bk2);
		bc2.setBookcopy_bookshelf(bk2);
		bc3.setBookcopy_bookshelf(bk2);
		bc4.setBookcopy_bookshelf(bk5);
		bc5.setBookcopy_bookshelf(bk5);
		bc6.setBookcopy_bookshelf(bk5);
		bc7.setBookcopy_bookshelf(bk1);
		bc8.setBookcopy_bookshelf(bk1);
		bc9.setBookcopy_bookshelf(bk1);

		userManagerBookCopy.insertBookCopy(bc1);
		userManagerBookCopy.insertBookCopy(bc2);
		userManagerBookCopy.insertBookCopy(bc3);
		userManagerBookCopy.insertBookCopy(bc4);
		userManagerBookCopy.insertBookCopy(bc5);
		userManagerBookCopy.insertBookCopy(bc6);
		userManagerBookCopy.insertBookCopy(bc7);
		userManagerBookCopy.insertBookCopy(bc8);
		userManagerBookCopy.insertBookCopy(bc9);

		System.out.println("Bookshelf insérés");

		//////////////////////////////////////////////////////////////////////
		///////////////////// CREATION DES MEMBRES ///////////////////////////
		//////////////////////////////////////////////////////////////////////
		MemberDAO userManagerMember = (MemberDAO) context.getBean("memberDAOImpl");
		Member m1 = new Member("LEVEL", "LAURENE", "laurene.level@infotel.com", "35 rue Pasteur Retiers", "azerty123",false);
		Member m2 = new Member("COCHENNEC", "YOANN", "yoann.cochennec@infotel.com", "Brestmeme", "azerty123",false);
		Member m3 = new Member("RONCO", "ROMAIN", "roamin.ronco@infotel.com", "Rennes", "azerty123",false);
		Member m4 = new Member("GUENOT", "MICKAEL", "mickael.guenot@infotel.com", "Lyon", "azerty123",false);
		Member m5 = new Member("LE TEXIER", "LENA", "lena.letexier@infotel.com", "BrestpasMeme", "azerty123",false);
		Member m6 = new Member("az", "az", "az@az", "az", "az",true);
		m1.setMember_Library(l1);
		m2.setMember_Library(l1);
		m3.setMember_Library(l1);
		m4.setMember_Library(l2);
		m5.setMember_Library(l2);
		m6.setMember_Library(l1);
		l1.getLibrary_ListMember().add(m1);
		l1.getLibrary_ListMember().add(m2);
		l1.getLibrary_ListMember().add(m3);
		l2.getLibrary_ListMember().add(m4);
		l2.getLibrary_ListMember().add(m5);
		l1.getLibrary_ListMember().add(m6);

		userManagerMember.insertMember(m1);
		userManagerMember.insertMember(m2);
		userManagerMember.insertMember(m3);
		userManagerMember.insertMember(m4);
		userManagerMember.insertMember(m5);
		userManagerMember.insertMember(m6);

		System.out.println("Membre insérés");

	}

}
