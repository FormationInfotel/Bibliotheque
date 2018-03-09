package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.BookBasketDAO;
import com.infotel.formation.interfaces.BookBasketService;

@Service
@Transactional
public class BookBasketServiceImpl implements BookBasketService{
	
	@Autowired
	BookBasketDAO bookbasketDAO;

}
