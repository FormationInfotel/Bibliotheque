package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Library;

public interface LibraryService {

	public void insertLibrary(Library library) throws Exception;

	public void updateLibrary(Library library) throws Exception;

	public void deleteLibrary(Library library) throws Exception;

	public List<Library> getLibraries() throws Exception;

	public Library getLibraryById(long idLibrary);

	public Library getLibraryByName(String libraryName);

}
