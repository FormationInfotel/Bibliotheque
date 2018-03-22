package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookCopyDTO;
import com.infotel.formation.Mapper.BookCopyMapper;
import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.BookCopyService;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class BookCopyController {
	@Autowired
	BookService bookService;

	@Autowired
	BookCopyService bookcopyService;

	@Autowired
	BookCopyMapper mapper;

	@GetMapping(value = "/bookcopy/get")
	public Resultat getBookCopies() {
		Resultat res = new Resultat();
		try {
			List<BookCopyDTO> viewBookCopies = new ArrayList<BookCopyDTO>();

			List<BookCopy> bookcopies = bookcopyService.getBookCopys();

			for (BookCopy bookcopy : bookcopies) {
				viewBookCopies.add(mapper.mapIntoBookCopyDTO(bookcopy));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewBookCopies);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/bookcopy/add") // ,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addBookcopy(@RequestBody BookCopyDTO bookCopyDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			bookcopyService.insertBookCopy(mapper.mapIntoBookCopy(bookCopyDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(bookCopyDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/bookcopy/update") // ,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateBookcopy(@RequestBody BookCopyDTO bookCopyDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			bookcopyService.updateBookCopy(mapper.mapIntoBookCopy(bookCopyDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(bookCopyDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/bookcopy/delete") // ,consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteBookcopy(@RequestBody BookCopyDTO bookCopyDTO) {
		Resultat res = new Resultat();
		try {
			bookcopyService.deleteBookCopy(bookcopyService.getBookCopyById(bookCopyDTO.getCopy_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.DELETE_SUCCESS);
			res.setPayload(bookCopyDTO);

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
