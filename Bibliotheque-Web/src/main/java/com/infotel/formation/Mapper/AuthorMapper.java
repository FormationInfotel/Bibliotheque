package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.AuthorDTO;
import com.infotel.formation.entity.Author;
import com.infotel.formation.entity.Book;
import com.infotel.formation.interfaces.BookService;

@Component
public class AuthorMapper {

	@Autowired
	BookService bookService;

	public Author mapIntoAuthor(AuthorDTO authorDTO) throws Exception {
		Author author = new Author(authorDTO.getAuthor_lastname(), authorDTO.getAuthor_firstname());
		author.setAuthor_id(authorDTO.getAuthor_id());
		for (Long id : authorDTO.getAuthor_listeBookId()) {
			author.getAuthor_listeBook().add(bookService.getBookById(id));
		}

		return (author);
	}

	public AuthorDTO mapIntoAuthorDTO(Author author) {
		AuthorDTO authorDTO = new AuthorDTO(author.getAuthor_lastname(), author.getAuthor_firstname());
		authorDTO.setAuthor_id(author.getAuthor_id());
		for (Book book : author.getAuthor_listeBook()) {
			authorDTO.getAuthor_listeBookId().add(book.getISBN());
		}

		return (authorDTO);
	}
}
