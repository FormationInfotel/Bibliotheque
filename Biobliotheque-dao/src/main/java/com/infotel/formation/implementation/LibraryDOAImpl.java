package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Library;
import com.infotel.formation.interfaces.LibraryDAO;

@Repository
@Transactional
public class LibraryDOAImpl implements LibraryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertLibrary(Library library) {
		sessionFactory.getCurrentSession().save(library);
	}

	@Override
	public Library getLibraryById(long libraryId) {
		Library libraryById = null;

		for (Library library : getLibrarys()) {
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
	public Library getLibrary(String libraryName) {
		Query<Library> query = sessionFactory.getCurrentSession()
				.createQuery("from Library where library_name = :libraryName");
		query.setParameter("library_name", libraryName);
		return (Library) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getLibrarys() {
		List<Library> result = (List<Library>) sessionFactory.getCurrentSession().createQuery("from Library").list();
		return result;
	}

}
