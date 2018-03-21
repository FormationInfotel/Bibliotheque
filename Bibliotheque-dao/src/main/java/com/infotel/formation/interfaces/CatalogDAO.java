package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Catalog;

public interface CatalogDAO {
	void insertCatalog(Catalog catalog);

	public Catalog getCatalogById(long catalogId);

	Catalog getCatalog(String catalogName);

	List<Catalog> getCatalogs();
}
