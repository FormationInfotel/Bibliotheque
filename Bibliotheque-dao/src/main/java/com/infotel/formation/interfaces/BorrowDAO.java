package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Borrow;

public interface BorrowDAO {

	public void insertBorrow(Borrow borrow);

	public void updateBorrow(Borrow borrow);

	public void deleteBorrow(Borrow borrow);

	public Borrow getBorrowById(Long borrowdId);

	public List<Borrow> getBorrows();
}
