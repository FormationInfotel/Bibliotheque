package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorDAO;

@Repository
@Transactional
public class AuthorDAOImpl extends _GenericDAOImpl<Author> implements AuthorDAO {
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
	}

	@Override
	public void updateAuthor(Author author) {
		sessionFactory.getCurrentSession().update(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		sessionFactory.getCurrentSession().delete(author);
	}

	@Override
	public Author getAuthorById(long authorId) {
		Author authorById = null;

		for (Author author : getAuthors()) {
			if (author != null && author.getAuthor_id() > 0 && author.getAuthor_id() == authorId) {
				authorById = author;
				break;
			}
		}
		return authorById;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Author getAuthor(String authorName) {
		Query<Author> query = sessionFactory.getCurrentSession()
				.createQuery("from Author Where author_name LIKE :authorName");
		query.setParameter("authorName", "%" + authorName + "%").list();
		return query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getListAuthorByKeyword(String authorname) {
		Query<Author> query = sessionFactory.getCurrentSession()
				.createQuery("from Author Where author_firstname LIKE :authorname OR author_lastname LIKE :authorname");
		query.setParameter("authorname", "%" + authorname + "%").list();
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAuthors() {
		List<Author> result = (List<Author>) sessionFactory.getCurrentSession().createQuery("from Author").list();
		return result;
	}

	

}
