package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Author;

public interface AuthorDAO {
	void insertCustomer(Author author);

	public Author getCustomerById(String authorId);

	Author getCustomer(String authorName);

	List<Author> getCustomers();

}
