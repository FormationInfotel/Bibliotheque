package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.AuthorDTO;
import com.infotel.formation.Mapper.AuthorMapper;
import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;

	@Autowired
	AuthorMapper mapper;

	@GetMapping(value = "/author/get")
	public List<AuthorDTO> getBooks() {
		List<AuthorDTO> viewAuthor = new ArrayList<AuthorDTO>();

		List<Author> authors = authorService.getAuthors();

		for (Author author : authors) {
			viewAuthor.add(mapper.mapIntoAuthorDTO(author));
		}
		return viewAuthor;
	}

	@PutMapping(value = "/author/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void addAuthor(@RequestBody AuthorDTO authorDTO) {
		authorService.insertAuthor(mapper.mapIntoAuthor(authorDTO));
	}

	@PostMapping(value = "/author/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateAuthor(@RequestBody AuthorDTO authorDTO) {
		authorService.updateAuthor(mapper.mapIntoAuthor(authorDTO));
	}

	@DeleteMapping(value = "/author/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteAuthor(@RequestBody AuthorDTO authorDTO) {
		authorService.deleteAuthor(authorService.getAuthorById(authorDTO.getAuthor_id()));
	}
}
