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
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.AuthorService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;

	@Autowired
	AuthorMapper mapper;

	@GetMapping(value = "/author/get")
	public Resultat getBooks() {
		Resultat res = new Resultat();
		try {
			List<AuthorDTO> viewAuthor = new ArrayList<AuthorDTO>();

			List<Author> authors = authorService.getAuthors();

			for (Author author : authors) {
				viewAuthor.add(mapper.mapIntoAuthorDTO(author));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewAuthor);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/author/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addAuthor(@RequestBody AuthorDTO authorDTO) {
		Resultat res = new Resultat();
		try {
			authorService.insertAuthor(mapper.mapIntoAuthor(authorDTO));
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(authorDTO);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/author/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateAuthor(@RequestBody AuthorDTO authorDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			authorService.updateAuthor(mapper.mapIntoAuthor(authorDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(authorDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/author/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteAuthor(@RequestBody AuthorDTO authorDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			authorService.deleteAuthor(authorService.getAuthorById(authorDTO.getAuthor_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(authorDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

}
