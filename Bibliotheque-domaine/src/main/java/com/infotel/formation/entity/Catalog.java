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

	public Catalog(String catalog_name, Library catalog_library) {
		this.catalog_name = catalog_name;
		this.catalog_library = catalog_library;
	}

	@Override
	public String toString() {
		return "Catalog [catalog_name=" + catalog_name + "]";
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public long getCatalog_id() {
		return catalog_id;
	}

	public Library getCatalog_library() {
		return catalog_library;
	}

	public void setCatalog_library(Library catalog_library) {
		this.catalog_library = catalog_library;
	}

}
