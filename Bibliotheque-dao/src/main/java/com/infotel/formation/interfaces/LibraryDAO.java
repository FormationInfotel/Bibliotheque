package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Library;

public interface LibraryDAO {
	public void insertLibrary(Library library);

	public void updateLibrary(Library library);

	public void deleteLibrary(Library library);

	public Library getLibraryById(long libraryId);

	Library getLibraryByName(String libraryName);

	List<Library> getLibraries();

}
