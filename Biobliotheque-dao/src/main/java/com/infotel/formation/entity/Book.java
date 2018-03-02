package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long ISBN;

	private String book_title;
	private String book_description;
	private float book_price;
	private Date publication_date;
	private int catalog_id;
	private int editor_id;
	private int category_id;
	private String image_path;
	private boolean popular_book;

	@ManyToOne
	private Author book_author;

	@ManyToOne
	private Editor book_editor;

	@ManyToOne
	private Category book_category;

	@ManyToOne
	private Catalog book_catalog;

	@OneToMany
	private List<BookCopy> book_ListCopy;

	public Book() {
		super();
	}

	public Book(String book_title, String book_description, float book_price, Date publication_date, int catalog_id,
			int editor_id, int category_id, String image_path, boolean popular_book) {
		super();
		this.book_title = book_title;
		this.book_description = book_description;
		this.book_price = book_price;
		this.publication_date = publication_date;
		this.catalog_id = catalog_id;
		this.editor_id = editor_id;
		this.category_id = category_id;
		this.image_path = image_path;
		this.popular_book = popular_book;
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

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public int getEditor_id() {
		return editor_id;
	}

	public void setEditor_id(int editor_id) {
		this.editor_id = editor_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
				+ ", book_price=" + book_price + ", publication_date=" + publication_date + ", catalog_id=" + catalog_id
				+ ", editor_id=" + editor_id + ", category_id=" + category_id + ", image_path=" + image_path
				+ ", popular_book=" + popular_book + "]";
	}

}
