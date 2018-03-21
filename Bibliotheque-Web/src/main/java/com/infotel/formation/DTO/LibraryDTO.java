package com.infotel.formation.DTO;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

	private long library_code;
	private String library_name;
	private String library_address;

	private List<Long> library_ListCatalog;

	private List<Long> library_ListMember;

	public LibraryDTO() {
	}

	public LibraryDTO(String library_name, String library_address) {
		this.library_name = library_name;
		this.library_address = library_address;
		library_ListCatalog = new ArrayList<Long>();
		library_ListMember = new ArrayList<Long>();
	}

	public long getLibrary_code() {
		return library_code;
	}

	public void setLibrary_code(long library_code) {
		this.library_code = library_code;
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

	public List<Long> getLibrary_ListCatalog() {
		return library_ListCatalog;
	}

	public void setLibrary_ListCatalog(List<Long> library_ListCatalog) {
		this.library_ListCatalog = library_ListCatalog;
	}

	public List<Long> getLibrary_ListMember() {
		return library_ListMember;
	}

	public void setLibrary_ListMember(List<Long> library_ListMember) {
		this.library_ListMember = library_ListMember;
	}

}
