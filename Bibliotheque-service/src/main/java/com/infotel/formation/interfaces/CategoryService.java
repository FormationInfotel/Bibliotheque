package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Category;

public interface CategoryService {

	public Category getCategoryById(long categoryId);

	public void insertCategory(Category category) throws Exception;

	public void updateCategory(Category category) throws Exception;

	public void deleteCategory(Category category) throws Exception;

	public List<Category> getCategories() throws Exception;

}
