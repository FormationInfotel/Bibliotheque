package com.infotel.formation.DTO;

import java.io.Serializable;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long ISBN;
	private String book_title;
	private String book_description;
	private float book_price;
	private String publication_date;
	private String image_path;
	private boolean popular_book;

	private long book_authorId;
	
	private String author_lastname;
	private String author_firstname;

	private long book_editorId;
	private long book_categoryId;

	public BookDTO() {
	}

	public BookDTO(long iSBN, String book_title, String book_description, float book_price, String publication_date,
			String image_path, boolean popular_book) {
		ISBN = iSBN;
		this.book_title = book_title;
		this.book_description = book_description;
		this.book_price = book_price;
		this.publication_date = publication_date;
		this.image_path = image_path;
		this.popular_book = popular_book;
	}
	
	


	public BookDTO(long iSBN, String book_title, String book_description, float book_price, Date publication_date,
			String image_path, boolean popular_book, long book_authorId, String author_lastname,
			String author_firstname, long book_editorId, long book_categoryId) {
		super();
		ISBN = iSBN;
		this.book_title = book_title;
		this.book_description = book_description;
		this.book_price = book_price;
		this.publication_date = publication_date;
		this.image_path = image_path;
		this.popular_book = popular_book;
		this.book_authorId = book_authorId;
		this.author_lastname = author_lastname;
		this.author_firstname = author_firstname;
		this.book_editorId = book_editorId;
		this.book_categoryId = book_categoryId;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public boolean isPopular_book() {
		return popular_book;
	}

	public void setPopular_book(boolean popular_book) {
		this.popular_book = popular_book;
	}

	public long getBook_editorId() {
		return book_editorId;
	}

	public void setBook_editorId(long book_editorId) {
		this.book_editorId = book_editorId;
	}

	public long getBook_categoryId() {
		return book_categoryId;
	}

	public void setBook_categoryId(long book_categoryId) {
		this.book_categoryId = book_categoryId;
	}

	public long getBook_authorId() {
		return book_authorId;
	}

	public void setBook_authorId(long book_authorId) {
		this.book_authorId = book_authorId;
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
}
