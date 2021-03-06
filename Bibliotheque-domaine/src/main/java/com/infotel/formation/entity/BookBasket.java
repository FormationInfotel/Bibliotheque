package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookBasket implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long book_basket_id;
	private String creation_date;
	private String delivery_date;
	
	@OneToMany(mappedBy = "bookcopy_bookbasket")
	private List<BookCopy> bookbasket_Listbook;

	public BookBasket() {
		super();
	}
	
	public BookBasket(String creation_date, String delivery_date) {
		this.creation_date = creation_date;
		this.delivery_date = delivery_date;
	}

	

	public BookBasket(String creation_date, String delivery_date, List<BookCopy> bookbasket_Listbook) {
		this.creation_date = creation_date;
		this.delivery_date = delivery_date;
		this.bookbasket_Listbook = bookbasket_Listbook;
	}

	public List<BookCopy> getBookbasket_Listbook() {
		return bookbasket_Listbook;
	}



	public void setBookbasket_Listbook(List<BookCopy> bookbasket_Listbook) {
		this.bookbasket_Listbook = bookbasket_Listbook;
	}



	
	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public long getBook_basket_id() {
		return book_basket_id;
	}

	@Override
	public String toString() {
		return "BookBasket [book_basket_id=" + book_basket_id + ", creation_date=" + creation_date + ", delivery_date="
				+ delivery_date + "]";
	}
	
	
	
	
	
	
	
}
