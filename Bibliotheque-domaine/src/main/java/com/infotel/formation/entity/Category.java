package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long category_id;
	private String category_name;
	private String category_description;

	@OneToMany(mappedBy = "book_category")
	private List<Book> category_listeBook;

	public List<Book> getCategory_listeBook() {
		return category_listeBook;
	}

	public void setCategory_listeBook(List<Book> category_listeBook) {
		this.category_listeBook = category_listeBook;
	}

	public Category() {
	}

	public Category(String category_name, String category_description) {
		super();
		this.category_name = category_name;
		this.category_description = category_description;
	}

	@Override
	public String toString() {
		return "Category [category_name=" + category_name + ", category_description=" + category_description + "]";
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public long getCategory_id() {
		return category_id;
	}
}
