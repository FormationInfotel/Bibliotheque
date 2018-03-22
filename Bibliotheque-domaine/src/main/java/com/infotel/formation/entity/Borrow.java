package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


public class Borrow implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long borrow_id;
	private String borrow_date;
	private String return_date;
	private boolean isValidated;
	
	@ManyToOne
	private Member borrow_member;
	
	@OneToMany(mappedBy = "bookcopy_borrow")
	private List<BookCopy> borrow_listCopy;
	
	public Borrow(String borrow_date, String return_date, Member borrow_member, List<BookCopy> borrow_listCopy) {
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.borrow_member = borrow_member;
		this.borrow_listCopy = borrow_listCopy;
	}

	public Borrow() {
	}

	public long getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(long borrow_id) {
		this.borrow_id = borrow_id;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public Member getBorrow_member() {
		return borrow_member;
	}

	public void setBorrow_member(Member borrow_member) {
		this.borrow_member = borrow_member;
	}

	public List<BookCopy> getBorrow_listCopy() {
		return borrow_listCopy;
	}

	public void setBorrow_listCopy(List<BookCopy> borrow_listCopy) {
		this.borrow_listCopy = borrow_listCopy;
	}

	
}