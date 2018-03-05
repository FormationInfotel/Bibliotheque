package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.Date;


public class Borrow_test implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date borrow_date;
	private Date return_date;

	public Borrow_test() {
	}

	public Borrow_test(Date borrow_date, Date return_date) {
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
