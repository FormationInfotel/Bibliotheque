package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BorrowDTO;
import com.infotel.formation.Mapper.BorrowMapper;
import com.infotel.formation.entity.Borrow;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.BorrowService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class ValidationEmpruntController {

	@Autowired
	BorrowService borrowService;

	@Autowired
	BorrowMapper mapper;

	@GetMapping(value = "/borrow")
	public Resultat recommendedBooks() {
		List<BorrowDTO> viewBorrows = new ArrayList<BorrowDTO>();
		List<Borrow> borrows;
		Resultat res = new Resultat();

		try {

			borrows = borrowService.getBorrows();

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

}
