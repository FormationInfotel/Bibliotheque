package com.infotel.formation.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long category_id;
	private String category_name;
	private String category_description;

	private List<Long> category_listeBook;

	public CategoryDTO(String category_name, String category_description) {
		this.category_name = category_name;
		this.category_description = category_description;
		category_listeBook = new ArrayList<Long>();
	}

	public CategoryDTO() {
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public List<Long> getCategory_listeBook() {
		return category_listeBook;
	}

	public void setCategory_listeBook(List<Long> category_listeBook) {
		this.category_listeBook = category_listeBook;
	}

}
