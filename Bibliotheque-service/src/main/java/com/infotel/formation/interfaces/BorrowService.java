package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Borrow;

public interface BorrowService {

	public void insertBorrow(Borrow borrow) throws Exception;

	public void updateBorrow(Borrow borrow) throws Exception;

	public void deleteBorrow(Borrow borrow) throws Exception;

	public Borrow getBorrowById(Long borrowdId) throws Exception;

	public List<Borrow> getBorrows() throws Exception;
}
