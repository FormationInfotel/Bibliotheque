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
		//List<BookCopy> bookCopy = new ArrayList<BookCopy>();
		
		Borrow borrow = new Borrow(borrowDTO.getBorrow_date(), borrowDTO.getBorrow_date(),
				memberService.getMemberById(borrowDTO.getBorrow_memberId()));
		
		for (Long id : borrowDTO.getBorrow_listCopyId()) {
			borrow.getBorrow_listCopy().add(bookcopyService.getBookCopyById(id));
		}
		
		return borrow;
	}

	public BorrowDTO mapIntoBorrowDTO(Borrow borrow) {
		List<Long> listCopy = new ArrayList<Long>();
		
		
		System.out.println(listCopy);
		
		BorrowDTO borrowDTO = new BorrowDTO(borrow.getBorrow_member().getMember_id(), borrow.getBorrow_date(),
				borrow.getReturn_date(), borrow.isValidated(),
				memberService.getMemberById(borrow.getBorrow_member().getMember_id()).getMember_firstname(),
				memberService.getMemberById(borrow.getBorrow_member().getMember_id()).getMember_lastname(),
				borrow.getBorrow_member().getMember_id());
		System.out.println(borrow.getBorrow_listCopy());
		
		for (BookCopy bc : borrow.getBorrow_listCopy()) {
			borrowDTO.getBorrow_listCopyId().add(bc.getCopy_id());
		}
		return borrowDTO;

	}

}
