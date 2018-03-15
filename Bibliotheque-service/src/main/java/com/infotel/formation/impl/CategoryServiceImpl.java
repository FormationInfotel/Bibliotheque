package com.infotel.formation.impl;

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
}
