package com.infotel.formation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long member_id;
	private String member_lastname;
	private String member_firstname;
	private String member_email;
	private String member_address;
	private String member_password;

	@ManyToOne
	private Library member_Library;

	public Member() {
		super();
	}

	public Member(String member_lastname, String member_firstname, String member_email, String member_address,
			String member_password) {
		super();
		this.member_lastname = member_lastname;
		this.member_firstname = member_firstname;
		this.member_email = member_email;
		this.member_address = member_address;
		this.member_password = member_password;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getMember_lastname() {
		return member_lastname;
	}

	public void setMember_lastname(String member_lastname) {
		this.member_lastname = member_lastname;
	}

	public String getMember_firstname() {
		return member_firstname;
	}

	public void setMember_firstname(String member_firstname) {
		this.member_firstname = member_firstname;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_address() {
		return member_address;
	}

	public Library getMember_Library() {
		return member_Library;
	}

	public void setMember_Library(Library member_Library) {
		this.member_Library = member_Library;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_lastname=" + member_lastname + ", member_firstname="
				+ member_firstname + ", member_email=" + member_email + ", member_address=" + member_address
				+ ", member_password=" + member_password + "]";
	}

}
