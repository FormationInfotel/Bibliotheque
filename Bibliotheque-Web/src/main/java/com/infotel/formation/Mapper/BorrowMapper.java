package com.infotel.formation.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.BorrowDTO;
import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.entity.Borrow;
import com.infotel.formation.interfaces.BookCopyService;
import com.infotel.formation.interfaces.MemberService;

@Component
public class BorrowMapper {

	@Autowired
	MemberService memberService;

	@Autowired
	BookCopyService bookcopyService;

	public Borrow mapIntoBorrow(BorrowDTO borrowDTO) {
		List<BookCopy> bookCopy = new ArrayList<BookCopy>();
		for (Long id : borrowDTO.getBorrow_listCopyId()) {
			bookCopy.add(bookcopyService.getBookCopyById(id));
		}
		Borrow borrow = new Borrow(borrowDTO.getBorrow_date(), borrowDTO.getBorrow_date(),
				memberService.getMemberById(borrowDTO.getBorrow_memberId()), bookCopy);
		return borrow;
	}

	public BorrowDTO mapIntoBorrowDTO(Borrow borrow) {
		List<Long> listCopy = new ArrayList<Long>();
		for (BookCopy bc : borrow.getBorrow_listCopy()) {
			listCopy.add(bc.getCopy_id());
		}
		BorrowDTO borrowDTO = new BorrowDTO(borrow.getBorrow_date(), borrow.getReturn_date(),
				borrow.getBorrow_member().getMember_id(), listCopy);
		return borrowDTO;

	}

}
