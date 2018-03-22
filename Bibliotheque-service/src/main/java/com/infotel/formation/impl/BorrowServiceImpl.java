package com.infotel.formation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Borrow;
import com.infotel.formation.interfaces.BorrowDAO;
import com.infotel.formation.interfaces.BorrowService;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	BorrowDAO borrowDAO;
	
	@Override
	public void insertBorrow(Borrow borrow){
		borrowDAO.insertBorrow(borrow);
	}

	@Override
	public void updateBorrow(Borrow borrow) {
		borrowDAO.updateBorrow(borrow);
	}

	@Override
	public void deleteBorrow(Borrow borrow) {
		borrowDAO.deleteBorrow(borrow);
	}

	@Override
	public Borrow getBorrowById(Long borrowdId) {
		return borrowDAO.getBorrowById(borrowdId);
	}

	@Override
	public List<Borrow> getBorrows() {
		return borrowDAO.getBorrows();
	}

}
