package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Category;


public interface CategoryDAO {
	
	void insertAuthor(Category category);

	public Category getCategoryById(int categoryId);

	Category getCategory(String categoryName);

	List<Category> getCategories();

}
