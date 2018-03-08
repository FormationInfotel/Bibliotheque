package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.CatalogDAO;
import com.infotel.formation.interfaces.CatalogService;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	CatalogDAO catalogDAO;
}
