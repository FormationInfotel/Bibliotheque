package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.CategoryDTO;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Category;
import com.infotel.formation.interfaces.BookService;

@Component
public class CategoryMapper {

	@Autowired
	BookService bookService;

	public Category mapIntoCategory(CategoryDTO categoryDTO) {
		Category category = new Category(categoryDTO.getCategory_name(), categoryDTO.getCategory_description());
		category.setCategory_id(categoryDTO.getCategory_id());
		for (Long id : categoryDTO.getCategory_listeBook()) {
			category.getCategory_listeBook().add(bookService.getBookById(id));
		}

		return (category);
	}

	public CategoryDTO mapIntoEditorDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getCategory_name(), category.getCategory_description());
		categoryDTO.setCategory_id(category.getCategory_id());
		for (Book book : category.getCategory_listeBook()) {
			categoryDTO.getCategory_listeBook().add(book.getISBN());
		}

		return (categoryDTO);
	}
}
