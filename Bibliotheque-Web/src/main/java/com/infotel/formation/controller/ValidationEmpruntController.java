package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BorrowDTO;
import com.infotel.formation.Mapper.BorrowMapper;
import com.infotel.formation.entity.Borrow;
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
	public Resultat recommendedBooks() throws Exception {
		List<BorrowDTO> viewBorrow = new ArrayList<BorrowDTO>();
		List<Borrow> borrows = borrowService.getBorrows();
		Resultat res = new Resultat();
		
		for (Borrow borrow : borrows) {
			
			viewBorrow.add(mapper.mapIntoBorrowDTO(borrow));
		}
		
		res.setIsSucces(true);
		res.setMessage(ControllerConstants.BORROW_SHOW_SUCCES);
		res.setPayload(viewBorrow);
	
		System.out.println(res);
		
		return res;
	}

}
