package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Library;

public interface LibraryDAO {
	void insertLibrary(Library library);

	public Library getLibraryById(long libraryId);

	Library getLibrary(String libraryName);

	List<Library> getLibrarys();

}
