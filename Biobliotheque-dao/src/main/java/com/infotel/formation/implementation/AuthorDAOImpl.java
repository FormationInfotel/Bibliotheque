package com.infotel.formation.implementation;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Author;
import com.infotel.formation.interfaces.AuthorDAO;

@Repository
@Transactional
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
	}

	@Override
	public Author getAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}


}
