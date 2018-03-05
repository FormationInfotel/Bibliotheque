package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Catalog;
import com.infotel.formation.interfaces.CatalogDAO;

@Repository
@Transactional
public class CatalogDAOImpl implements CatalogDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCatalog(Catalog catalog) {
		sessionFactory.getCurrentSession().save(catalog);
	}

	@Override
	public Catalog getCatalogById(int catalogId) {
		Catalog catalogById = null;

		for (Catalog catalog : getCatalogs()) {
			if (catalog != null && catalog.getCatalog_id() > 0 && catalog.getCatalog_id() == catalogId) {
				catalogById = catalog;
				break;
			}
		}

		if (catalogById == null) {
			throw new IllegalArgumentException("No catalog found with the catalog id : " + catalogById);
		}
		return catalogById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Catalog getCatalog(String catalogName) {
		Query<Catalog> query = sessionFactory.getCurrentSession()
				.createQuery("from Catalog where catalog_name = :catalogName");
		query.setParameter("catalog_name", catalogName);
		return (Catalog) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Catalog> getCatalogs() {
		List<Catalog> result = (List<Catalog>) sessionFactory.getCurrentSession().createQuery("from Catalog").list();
		return result;
	}

}
