package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	private long ISBN;

	private String book_title;
	private String book_description;
	private float book_price;
	private Date publication_date;
	private String image_path;
	private boolean popular_book;

	@ManyToOne(fetch = FetchType.EAGER)
	private Author book_author;

	@ManyToOne(fetch = FetchType.EAGER)
	private Editor book_editor;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category book_category;

	@ManyToOne(fetch = FetchType.EAGER)
	private Catalog book_catalog;

	@OneToMany(mappedBy = "bookcopy_parent")
	private List<BookCopy> book_ListCopy;


	public Book() {
	}

	public Book(long iSBN, String book_title, String book_description, float book_price, Date publication_date,
			boolean popular_book) {
		super();
		ISBN = iSBN;
		this.book_title = book_title;
		this.book_description = book_description;
		this.book_price = book_price;
		this.publication_date = publication_date;
		this.popular_book = popular_book;
		book_ListCopy = new ArrayList<BookCopy>();
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public Author getBook_author() {
		return book_author;
	}

	public void setBook_author(Author book_author) {
		this.book_author = book_author;
	}

	public String getBook_title() {
		return book_title;
	}

	public Editor getBook_editor() {
		return book_editor;
	}

	public void setBook_editor(Editor book_editor) {
		this.book_editor = book_editor;
	}

	public Category getBook_category() {
		return book_category;
	}

	public void setBook_category(Category book_category) {
		this.book_category = book_category;
	}

	public Catalog getBook_catalog() {
		return book_catalog;
	}

	public void setBook_catalog(Catalog book_catalog) {
		this.book_catalog = book_catalog;
	}

	public List<BookCopy> getBook_ListCopy() {
		return book_ListCopy;
	}

	public void setBook_ListCopy(List<BookCopy> book_ListCopy) {
		this.book_ListCopy = book_ListCopy;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public float getBook_price() {
		return book_price;
	}

	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}

	public Date getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(Date publication_date) {
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

	public String getBook_description() {
		return book_description;
	}

	@Override
	public String toString() {
		return "book [ISBN=" + ISBN + ", book_title=" + book_title + ", book_description=" + book_description
				+ ", book_price=" + book_price + ", publication_date=" + publication_date + ", image_path=" + image_path
				+ ", popular_book=" + popular_book + "]";
	}

}
