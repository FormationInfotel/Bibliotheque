package com.infotel.formation.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.Mapper.BookMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.BookService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@Autowired
	BookMapper mapper;

	@GetMapping(value = "/book/get")
	public Resultat getBooks() {
		Resultat res = new Resultat();
		try {
			List<BookDTO> viewBooks = new ArrayList<BookDTO>();

			List<Book> books = bookService.getBooks();

			for (Book book : books) {
				viewBooks.add(mapper.mapIntoBookDTO(book));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewBooks);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/book/getOne")
	public Resultat getBookById(@RequestBody long Id) {
		Resultat res = new Resultat();
		try {
			Book book = bookService.getBookById(Id);

			BookDTO bookDTO = mapper.mapIntoBookDTO(book);

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(bookDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/book/add")
	public Resultat addBook(@RequestBody BookDTO bookDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			bookService.insertBook(mapper.mapIntoBook(bookDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(bookDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/book/update")
	public Resultat updateBook(@RequestBody BookDTO bookDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			bookService.updateBook(mapper.mapIntoBook(bookDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(bookDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/book/delete/{id}")
	public Resultat deleteBook(@PathVariable("id") long id) {
		Resultat res = new Resultat();
		try {
			bookService.deleteBook(bookService.getBookById(id));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.DELETE_SUCCESS);
			res.setPayload(id);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam String imagePath, HttpServletResponse response,
			HttpServletRequest request) throws IOException {

		InputStream in = request.getServletContext().getResourceAsStream("/resources/img/" + imagePath);

		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(in, response.getOutputStream());
	}

}
