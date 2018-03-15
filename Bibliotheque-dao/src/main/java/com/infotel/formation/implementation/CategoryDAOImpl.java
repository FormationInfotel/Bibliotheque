package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Category;
import com.infotel.formation.interfaces.CategoryDAO;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public Category getCategoryById(long categoryId) {
		Category categoryById = null;

		for (Category category : getCategories()) {
			if (category != null && category.getCategory_id() > 0 && category.getCategory_id() == categoryId) {
				categoryById = category;
				break;
			}
		}

		if (categoryById == null) {
			throw new IllegalArgumentException("No category found with the id : " + categoryId);
		}
		return categoryById;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getListCategoryByKeyword(String categoryName) {
		Query<Category> query = sessionFactory.getCurrentSession()
				.createQuery("from Category Where category_name LIKE :categoryName");
		query.setParameter("categoryName", "%" + categoryName + "%").list();
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		List<Category> result = (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category").list();
		return result;
	}

}
