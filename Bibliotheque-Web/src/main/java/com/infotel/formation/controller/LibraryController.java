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

import com.infotel.formation.DTO.LibraryDTO;
import com.infotel.formation.Mapper.LibraryMapper;
import com.infotel.formation.entity.Library;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.LibraryService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@Autowired
	LibraryMapper mapper;

	@GetMapping(value = "/library/get")
	public Resultat getLibraries() {
		Resultat res = new Resultat();
		try {
			List<LibraryDTO> viewLibraries = new ArrayList<LibraryDTO>();

			List<Library> libraries = libraryService.getLibraries();

			for (Library library : libraries) {
				viewLibraries.add(mapper.mapIntoLibraryDTO(library));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewLibraries);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@PutMapping(value = "/library/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addLibrary(@RequestBody LibraryDTO libraryDTO) {
		Resultat res = new Resultat();
		try {
			libraryService.insertLibrary(mapper.mapIntoLibrary(libraryDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(libraryDTO);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/library/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateLibrary(@RequestBody LibraryDTO libraryDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			libraryService.updateLibrary(mapper.mapIntoLibrary(libraryDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(libraryDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/library/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteLibrary(@RequestBody LibraryDTO libraryDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			libraryService.deleteLibrary(libraryService.getLibraryById(libraryDTO.getLibrary_code()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(libraryDTO);

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
