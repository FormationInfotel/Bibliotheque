package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.BookDAO;
import com.infotel.formation.interfaces.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	
	@Autowired
	BookDAO bookDAO;
}
