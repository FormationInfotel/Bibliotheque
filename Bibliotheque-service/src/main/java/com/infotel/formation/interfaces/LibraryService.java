package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Library;

public interface LibraryService {

	public List<Library> getLibraries();

	public Library getLibraryById(long idLibrary);

	public Library getLibraryByName(String libraryName);

}
