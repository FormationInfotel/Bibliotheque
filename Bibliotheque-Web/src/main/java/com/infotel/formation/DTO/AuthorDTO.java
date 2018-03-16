package com.infotel.formation.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int author_id;
	private String author_lastname;
	private String author_firstname;

	private List<Long> author_listeBookId;

	public AuthorDTO() {
	}

	public AuthorDTO(String author_lastname, String author_firstname) {
		this.author_lastname = author_lastname;
		this.author_firstname = author_firstname;
		author_listeBookId = new ArrayList<Long>();
	}

	public String getAuthor_lastname() {
		return author_lastname;
	}

	public void setAuthor_lastname(String author_lastname) {
		this.author_lastname = author_lastname;
	}

	public String getAuthor_firstname() {
		return author_firstname;
	}

	public void setAuthor_firstname(String author_firstname) {
		this.author_firstname = author_firstname;
	}

	public List<Long> getAuthor_listeBookId() {
		return author_listeBookId;
	}

	public void setAuthor_listeBookId(List<Long> author_listeBookId) {
		this.author_listeBookId = author_listeBookId;
	}

	public int getAuthor_id() {
		return author_id;
	}
}
