package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long catalog_id;
	private String catalog_name;
	private Library library_code;

	@OneToMany(mappedBy = "book_catalog")
	private List<Book> catalog_book;

	@ManyToOne
	private Library catalog_library;

	public List<Book> getCatalog_book() {
		return catalog_book;
	}

	public void setCatalog_book(List<Book> catalog_book) {
		this.catalog_book = catalog_book;
	}

	public Catalog() {
	}

	public Catalog(String catalog_name, Library library_code) {
		super();
		this.catalog_name = catalog_name;
		this.library_code = library_code;
	}

	@Override
	public String toString() {
		return "Catalog [catalog_name=" + catalog_name + ", library_code=" + library_code + "]";
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public Library getLibrary_code() {
		return library_code;
	}

	public void setLibrary_code(Library library_code) {
		this.library_code = library_code;
	}

	public long getCatalog_id() {
		return catalog_id;
	}

}
