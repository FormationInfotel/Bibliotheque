package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.LibraryDTO;
import com.infotel.formation.entity.Catalog;
import com.infotel.formation.entity.Library;
import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.CatalogService;
import com.infotel.formation.interfaces.MemberService;

@Component
public class LibraryMapper {

	@Autowired
	MemberService memberService;

	@Autowired
	CatalogService catalogService;

	public Library mapIntoLibrary(LibraryDTO libraryDTO) {
		Library library = new Library(libraryDTO.getLibrary_name(), libraryDTO.getLibrary_address());
		for (long L : libraryDTO.getLibrary_ListMember()) {
			library.getLibrary_ListMember().add(memberService.getMemberById(L));
		}
		for (long L : libraryDTO.getLibrary_ListCatalog()) {
			library.getLibrary_ListCatalog().add(catalogService.getCatalogById(L));
		}
		return (library);
	}

	public LibraryDTO mapIntoLibraryDTO(Library library) {
		LibraryDTO libraryDTO = new LibraryDTO(library.getLibrary_name(), library.getLibrary_address());
		libraryDTO.setLibrary_code(library.getLibrary_code());
		for (Member M : library.getLibrary_ListMember()) {
			libraryDTO.getLibrary_ListMember().add(M.getMember_id());
		}
		for (Catalog C : library.getLibrary_ListCatalog()) {
			libraryDTO.getLibrary_ListCatalog().add(C.getCatalog_id());
		}
		return libraryDTO;
	}
}
