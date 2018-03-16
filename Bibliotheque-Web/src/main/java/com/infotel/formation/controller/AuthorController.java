package com.infotel.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;

	@GetMapping(value = "/author/get")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}

	@PostMapping(value = "/author/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addAuthor(Author author) {
		authorService.insertAuthor(author);
	}

	@PostMapping(value = "/author/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateAuthor(Author author) {
		authorService.insertAuthor(author);
	}

	@PostMapping(value = "/author/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteAuthor(Author author) {
		authorService.insertAuthor(author);
	}
}
