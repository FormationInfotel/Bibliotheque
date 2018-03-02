package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long registration_id;
	private Date registration_date;

	public Registration() {
	}

	public Registration(Date registration_date) {
		super();
		this.registration_date = registration_date;
	}

	@Override
	public String toString() {
		return "Registration [registration_date=" + registration_date + "]";
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public long getRegistration_id() {
		return registration_id;
	}

}
