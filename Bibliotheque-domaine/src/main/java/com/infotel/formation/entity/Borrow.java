package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Borrow implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrow_id;
	private Date borrow_date;
	private Date return_date;

	@ManyToOne
	private Member borrow_member;

	@OneToMany(mappedBy = "bookcopy_borrow", fetch = FetchType.EAGER)
	private List<BookCopy> borrow_listeBookBopy;

	public Borrow(Date borrow_date, Date return_date, Member borrow_member, List<BookCopy> borrow_listeBookBopy) {
		super();
		borrow_listeBookBopy = new ArrayList<BookCopy>();
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.borrow_member = borrow_member;
		this.borrow_listeBookBopy = borrow_listeBookBopy;

	}

	public Member getBorrow_member() {
		return borrow_member;
	}

	public void setBorrow_member(Member borrow_member) {
		this.borrow_member = borrow_member;
	}

	public List<BookCopy> getBorrow_listeBookBopy() {
		return borrow_listeBookBopy;
	}

	public void setBorrow_listeBookBopy(List<BookCopy> borrow_listeBookBopy) {
		this.borrow_listeBookBopy = borrow_listeBookBopy;
	}

	public Borrow() {
	}

	public Borrow(Date borrow_date, Date return_date) {
		super();
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "Borrow [borrow_date=" + borrow_date + ", return_date=" + return_date + "]";
	}

	public Date getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

}
