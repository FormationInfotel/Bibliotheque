package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Borrow;
import com.infotel.formation.interfaces.BorrowDAO;

@Repository
@Transactional
public class BorrowDAOImpl implements BorrowDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertBorrow(Borrow borrow) {
		sessionFactory.getCurrentSession().save(borrow);
	}

	@Override
	public void updateBorrow(Borrow borrow) {
		sessionFactory.getCurrentSession().update(borrow);
	}

	@Override
	public void deleteBorrow(Borrow borrow) {
		sessionFactory.getCurrentSession().delete(borrow);
	}

	@Override
	public Borrow getBorrowById(Long borrowdId) {
		Borrow borrowId = null;

		for (Borrow borrow : getBorrows()) {
			if (borrow != null && borrow.getBorrow_id() > 0 && borrow.getBorrow_id() == borrowdId) {
				borrowId = borrow;
				break;
			}
		}
		return borrowId;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Borrow> getBorrows() {
		List<Borrow> result = (List<Borrow>) sessionFactory.getCurrentSession().createQuery("from Borrow").list();
		return result;
	}

}
