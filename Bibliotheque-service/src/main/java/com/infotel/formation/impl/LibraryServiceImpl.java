package com.infotel.formation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Library;
import com.infotel.formation.interfaces.LibraryDAO;
import com.infotel.formation.interfaces.LibraryService;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	LibraryDAO libraryDAO;

	@Override
	public List<Library> getLibraries() {
		return libraryDAO.getLibraries();
	}

	@Override
	public Library getLibraryById(long idLibrary) {
		return libraryDAO.getLibraryById(idLibrary);
	}

	@Override
	public Library getLibraryByName(String libraryName) {
		return libraryDAO.getLibraryByName(libraryName);
	}

	@Override
	public void insertLibrary(Library library) {
		libraryDAO.insertLibrary(library);
	}

	@Override
	public void updateLibrary(Library library) {
		libraryDAO.updateLibrary(library);
	}

	@Override
	public void deleteLibrary(Library library) {
		libraryDAO.deleteLibrary(library);
	}
}
