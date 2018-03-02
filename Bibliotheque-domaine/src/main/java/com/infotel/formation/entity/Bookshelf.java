package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bookshelf implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long bookshelf_id;
	private String bookshelf_name;
	private String bookshelf_description;
	private int book_number;
	private int library_code;
	
	@OneToMany(mappedBy = "BookCopy")
	private List<BookCopy> bookshelf_Listbook;

	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}

	public Bookshelf() {
		super();
	}
	
	

	public Bookshelf(String bookshelf_name, String bookshelf_description, int book_number, int library_code) {
		super();
		this.bookshelf_name = bookshelf_name;
		this.bookshelf_description = bookshelf_description;
		this.book_number = book_number;
		this.library_code = library_code;
	}



	public long getBookshelf_id() {
		return bookshelf_id;
	}

	public void setBookshelf_id(long bookshelf_id) {
		this.bookshelf_id = bookshelf_id;
	}

	public String getBookshelf_name() {
		return bookshelf_name;
	}

	public void setBookshelf_name(String bookshelf_name) {
		this.bookshelf_name = bookshelf_name;
	}

	public String getBookshelf_description() {
		return bookshelf_description;
	}

	public void setBookshelf_description(String bookshelf_description) {
		this.bookshelf_description = bookshelf_description;
	}

	public int getLibrary_code() {
		return library_code;
	}

	public void setLibrary_code(int library_code) {
		this.library_code = library_code;
	}

	public int getBook_number() {
		return book_number;
	}



	@Override
	public String toString() {
		return "Bookshelf [bookshelf_id=" + bookshelf_id + ", bookshelf_name=" + bookshelf_name
				+ ", bookshelf_description=" + bookshelf_description + ", book_number=" + book_number
				+ ", library_code=" + library_code + "]";
	}
	
	
	
	
	

}
