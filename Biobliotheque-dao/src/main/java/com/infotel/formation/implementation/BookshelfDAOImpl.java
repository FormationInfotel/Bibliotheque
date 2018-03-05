package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Bookshelf;
import com.infotel.formation.interfaces.BookshelfDAO;


@Repository
@Transactional
public class BookshelfDAOImpl implements BookshelfDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertAuthor(Bookshelf bookshelf) {
		sessionFactory.getCurrentSession().save(bookshelf);
	}

	@Override
	public Bookshelf getBookshelfById(int bookshelfId) {
		Bookshelf bookshelfById = null;

		for (Bookshelf bookshelf : getBookshelfs()) {
			if (bookshelf != null && bookshelf.getBookshelf_id() > 0) {
				bookshelfById = bookshelf;
				break;
			}
		}

		if (bookshelfById == null) {
			throw new IllegalArgumentException("No bookshelf found with the id : " + bookshelfId);
		}
		return bookshelfById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bookshelf getBookshelf(String bookshelfName) {
		Query<Bookshelf> query = sessionFactory.getCurrentSession().createQuery("from Bookshelf where bookshelf_name = :bookshelfName");
		query.setParameter("name", bookshelfName);
		return (Bookshelf) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bookshelf> getBookshelfs() {
		List<Bookshelf> result = (List<Bookshelf>) sessionFactory.getCurrentSession().createQuery("from Bookshelf").list();
		return result;
	}

}
