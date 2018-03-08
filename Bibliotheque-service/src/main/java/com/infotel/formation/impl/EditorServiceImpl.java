package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.EditorDAO;
import com.infotel.formation.interfaces.EditorService;

@Service
@Transactional
public class EditorServiceImpl implements EditorService{
	
	@Autowired
	EditorDAO editorDAO;
}
