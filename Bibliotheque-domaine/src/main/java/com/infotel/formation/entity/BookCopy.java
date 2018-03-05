package com.infotel.formation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookCopy implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long copy_id;
	private long ISBN;
	private String copy_title;
	private String bookshelf_id;

	public BookCopy(long iSBN, String copy_title, Book bookcopy_parent) {
		super();
		ISBN = iSBN;
		this.copy_title = copy_title;
		this.bookcopy_parent = bookcopy_parent;
	}

	@ManyToOne
	private Book bookcopy_parent;

	@ManyToOne
	private Bookshelf bookcopy_bookshelf;

	@ManyToOne
	private BookBasket bookbasket_bookshelf;

	public BookBasket getBookbasket_bookshelf() {
		return bookbasket_bookshelf;
	}

	public void setBookbasket_bookshelf(BookBasket bookbasket_bookshelf) {
		this.bookbasket_bookshelf = bookbasket_bookshelf;
	}

	public Book getBookcopy_parent() {
		return bookcopy_parent;
	}

	public void setBookcopy_parent(Book bookcopy_parent) {
		this.bookcopy_parent = bookcopy_parent;
	}

	public Bookshelf getBookcopy_bookshelf() {
		return bookcopy_bookshelf;
	}

	public void setBookcopy_bookshelf(Bookshelf bookcopy_bookshelf) {
		this.bookcopy_bookshelf = bookcopy_bookshelf;
	}

	public BookCopy() {
		super();
	}

	public BookCopy(long iSBN, String copy_title, String bookshelf_id) {
		ISBN = iSBN;
		this.copy_title = copy_title;
		this.bookshelf_id = bookshelf_id;
	}

	public long getCopy_id() {
		return copy_id;
	}

	public void setCopy_id(long copy_id) {
		this.copy_id = copy_id;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getCopy_title() {
		return copy_title;
	}

	public void setCopy_title(String copy_title) {
		this.copy_title = copy_title;
	}

	public String getBookshelf_id() {
		return bookshelf_id;
	}

	@Override
	public String toString() {
		return "BookCopy [copy_id=" + copy_id + ", ISBN=" + ISBN + ", copy_title=" + copy_title + ", bookshelf_id="
				+ bookshelf_id + "]";
	}

}
