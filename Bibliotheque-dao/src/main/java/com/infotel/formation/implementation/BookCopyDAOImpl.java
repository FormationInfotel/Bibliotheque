package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.BookCopy;
import com.infotel.formation.interfaces.BookCopyDAO;

@Repository
@Transactional
public class BookCopyDAOImpl implements BookCopyDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertBookCopy(BookCopy bookCopy) {
		sessionFactory.getCurrentSession().save(bookCopy);
	}

	@Override
	public void updateBookCopy(BookCopy bookCopy) {
		sessionFactory.getCurrentSession().update(bookCopy);
	}

	@Override
	public void deleteBookCopy(BookCopy bookCopy) {
		sessionFactory.getCurrentSession().delete(bookCopy);
	}

	@Override
	public BookCopy getBookCopyById(long bookCopyId) {
		BookCopy bookCopyById = null;

		for (BookCopy bookCopy : getBookCopys()) {
			if (bookCopy != null && bookCopy.getCopy_id() > 0 && bookCopy.getCopy_id() == bookCopyId) {
				bookCopyById = bookCopy;
				break;
			}
		}
		return bookCopyById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BookCopy getBookCopy(String bookCopyName) {
		Query<BookCopy> query = sessionFactory.getCurrentSession()
				.createQuery("from BookCopy where copy_title = :bookCopyName");
		query.setParameter("copy_title", bookCopyName);
		return (BookCopy) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookCopy> getBookCopys() {
		List<BookCopy> result = (List<BookCopy>) sessionFactory.getCurrentSession().createQuery("from BookCopy").list();
		return result;
	}


}
