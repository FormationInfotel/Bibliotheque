package com.infotel.formation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long library_code;
	private String library_name;
	private String library_address;

	@OneToMany(mappedBy = "catalog_library", fetch = FetchType.EAGER)
	private List<Catalog> library_ListCatalog;

	@OneToMany(mappedBy = "member_Library")
	private List<Member> library_ListMember;

	public Library() {
	}

	public Library(String library_name, String library_address) {
		this.library_name = library_name;
		this.library_address = library_address;
		library_ListMember = new ArrayList<Member>();
		library_ListCatalog = new ArrayList<Catalog>();
	}

	@Override
	public String toString() {
		return "Library [library_name=" + library_name + ", library_address=" + library_address + "]";
	}

	public List<Catalog> getLibrary_ListCatalog() {
		return library_ListCatalog;
	}

	public void setLibrary_ListCatalog(List<Catalog> library_ListCatalog) {
		this.library_ListCatalog = library_ListCatalog;
	}

	public String getLibrary_name() {
		return library_name;
	}

	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}

	public String getLibrary_address() {
		return library_address;
	}

	public void setLibrary_address(String library_address) {
		this.library_address = library_address;
	}

	public long getLibrary_code() {
		return library_code;
	}

	public List<Member> getLibrary_ListMember() {
		return library_ListMember;
	}

	public void setLibrary_ListMember(List<Member> library_ListMember) {
		this.library_ListMember = library_ListMember;
	}
}
