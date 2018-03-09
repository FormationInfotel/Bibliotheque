package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.LibraryDAO;
import com.infotel.formation.interfaces.LibraryService;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	LibraryDAO libraryDAO;
}
