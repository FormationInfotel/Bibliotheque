package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long editor_id;
	private String editor_name;

	@OneToMany(mappedBy = "Book")
	private List<Book> editor_listeBook;

	public List<Book> getEditor_listeBook() {
		return editor_listeBook;
	}

	public void setEditor_listeBook(List<Book> editor_listeBook) {
		this.editor_listeBook = editor_listeBook;
	}

	@Override
	public String toString() {
		return "Editor [editor_name=" + editor_name + ", editor_address=" + editor_address + "]";
	}

	public Editor() {
	}

	public Editor(String editor_name, String editor_address) {
		super();
		this.editor_name = editor_name;
		this.editor_address = editor_address;
	}

	public String getEditor_name() {
		return editor_name;
	}

	public void setEditor_name(String editor_name) {
		this.editor_name = editor_name;
	}

	public String getEditor_address() {
		return editor_address;
	}

	public void setEditor_address(String editor_address) {
		this.editor_address = editor_address;
	}

	public long getEditor_id() {
		return editor_id;
	}

	private String editor_address;
}
