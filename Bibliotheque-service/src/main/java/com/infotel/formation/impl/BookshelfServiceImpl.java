package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.BookshelfDAO;
import com.infotel.formation.interfaces.BookshelfService;

@Service
@Transactional
public class BookshelfServiceImpl implements BookshelfService{

	
	@Autowired
	BookshelfDAO bookshelfDAO;
}
