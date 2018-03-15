package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Category;

public interface CategoryDAO {

	public Category getCategoryById(long categoryId);

	List<Category> getCategories();

	void insertCategory(Category category);

	List<Category> getListCategoryByKeyword(String categoryName);

}
