package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long author_id;
	private String author_lastname;
	private String author_firstname;

	@OneToMany(mappedBy = "Book")
	private List<Book> author_listeBook;

	public List<Book> getAuthor_listeBook() {
		return author_listeBook;
	}

	public void setAuthor_listeBook(List<Book> author_listeBook) {
		this.author_listeBook = author_listeBook;
	}

	@Override
	public String toString() {
		return "Author [author_lastname=" + author_lastname + ", author_firstname=" + author_firstname + "]";
	}

	public Author() {
	}

	public Author(String author_lastname, String author_firstname) {
		super();
		this.author_lastname = author_lastname;
		this.author_firstname = author_firstname;
	}

	public List<Book> getListeBook() {
		return author_listeBook;
	}

	public void setListeBook(List<Book> author_listeBook) {
		this.author_listeBook = author_listeBook;
	}

	public String getAuthor_lastname() {
		return author_lastname;
	}

	public void setAuthor_lastname(String author_lastname) {
		this.author_lastname = author_lastname;
	}

	public String getAuthor_firstname() {
		return author_firstname;
	}

	public void setAuthor_firstname(String author_firstname) {
		this.author_firstname = author_firstname;
	}

	public long getAuthor_id() {
		return author_id;
	}

}
