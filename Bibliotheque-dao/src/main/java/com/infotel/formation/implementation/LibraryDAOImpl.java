package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Library;
import com.infotel.formation.interfaces.LibraryDAO;

@Repository
@Transactional
public class LibraryDAOImpl implements LibraryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertLibrary(Library library) {
		sessionFactory.getCurrentSession().save(library);
	}

	@Override
	public void updateLibrary(Library library) {
		sessionFactory.getCurrentSession().update(library);
	}

	@Override
	public void deleteLibrary(Library library) {
		sessionFactory.getCurrentSession().delete(library);
	}

	@Override
	public Library getLibraryById(long libraryId) {
		Library libraryById = null;

		for (Library library : getLibraries()) {
			if (library != null && library.getLibrary_code() > 0 && library.getLibrary_code() == libraryId) {
				libraryById = library;
				break;
			}
		}

		if (libraryById == null) {
			throw new IllegalArgumentException("No Author found with the Author id : " + libraryId);
		}
		return libraryById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Library getLibraryByName(String libraryName) {
		Query<Library> query = sessionFactory.getCurrentSession()
				.createQuery("from Library where library_name = :libraryName");
		query.setParameter("libraryName", libraryName);
		return (Library) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getLibraries() {
		List<Library> result = (List<Library>) sessionFactory.getCurrentSession().createQuery("from Library").list();
		for (Library library : result) {
			Hibernate.initialize(library.getLibrary_ListMember());
			Hibernate.initialize(library.getLibrary_ListCatalog());
		}
		return result;
	}


}
