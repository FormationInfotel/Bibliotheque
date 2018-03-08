package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.BookCopyDAO;
import com.infotel.formation.interfaces.BookCopyService;

@Service
@Transactional
public class BookCopyServiceImpl  implements BookCopyService{
	
	@Autowired
	BookCopyDAO bookcopyDAO;

}
