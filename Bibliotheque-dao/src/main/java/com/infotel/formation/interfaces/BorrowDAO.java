package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Borrow;
import com.infotel.formation.entity.Member;

public interface BorrowDAO {
	void insertBorrow(Borrow borrow);

	public Borrow getBorrowByMember(Member memberId);

	List<Borrow> getBorrows();

}
