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

import com.infotel.formation.DTO.BorrowDTO;
import com.infotel.formation.Mapper.BorrowMapper;
import com.infotel.formation.entity.Borrow;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.BorrowService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class BorrowController {
	@Autowired
	BorrowService borrowService;

	@Autowired
	BorrowMapper mapper;

	@GetMapping(value = "/borrow/get")
	public Resultat getBooks() {
		Resultat res = new Resultat();
		try {
			List<BorrowDTO> viewBorrows = new ArrayList<BorrowDTO>();

			List<Borrow> borrows = borrowService.getBorrows();

			for (Borrow borrow : borrows) {
				viewBorrows.add(mapper.mapIntoBorrowDTO(borrow));
			}
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(viewBorrows);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/borrow/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addBook(@RequestBody BorrowDTO borrowDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			borrowService.insertBorrow(mapper.mapIntoBorrow(borrowDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(borrowDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/borrow/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateBook(@RequestBody BorrowDTO borrowDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			borrowService.updateBorrow(mapper.mapIntoBorrow(borrowDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(borrowDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/book/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteBook(@RequestBody BorrowDTO borrowDTO) {
		Resultat res = new Resultat();
		try {
			borrowService.deleteBorrow(borrowService.getBorrowById(borrowDTO.getBorrow_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.DELETE_SUCCESS);
			res.setPayload(borrowDTO);

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
