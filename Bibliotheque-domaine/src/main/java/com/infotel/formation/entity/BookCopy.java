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
	private boolean isBorrowed;

	@ManyToOne
	private Borrow bookcopy_borrow;

	@ManyToOne
	private Book bookcopy_parent;

	@ManyToOne
	private BookBasket bookcopy_bookbasket;

	public BookCopy(long iSBN, String copy_title, Book bookcopy_parent) {
		ISBN = iSBN;
		this.copy_title = copy_title;
		this.bookcopy_parent = bookcopy_parent;
	}

	public BookCopy() {
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

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public Borrow getBookcopy_borrow() {
		return bookcopy_borrow;
	}

	public void setBookcopy_borrow(Borrow bookcopy_borrow) {
		this.bookcopy_borrow = bookcopy_borrow;
	}

	public Book getBookcopy_parent() {
		return bookcopy_parent;
	}

	public void setBookcopy_parent(Book bookcopy_parent) {
		this.bookcopy_parent = bookcopy_parent;
	}

	public BookBasket getBookcopy_bookbasket() {
		return bookcopy_bookbasket;
	}

	public void setBookcopy_bookbasket(BookBasket bookcopy_bookbasket) {
		this.bookcopy_bookbasket = bookcopy_bookbasket;
	}

}