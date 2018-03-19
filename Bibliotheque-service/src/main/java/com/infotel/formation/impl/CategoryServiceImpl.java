package com.infotel.formation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Category;
import com.infotel.formation.interfaces.CategoryDAO;
import com.infotel.formation.interfaces.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;

	public Category getCategoryById(long categoryId) {
		return categoryDAO.getCategoryById(categoryId);
	}

	@Override
	public void insertCategory(Category category) {
		categoryDAO.insertCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryDAO.deleteCategory(category);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}
}
