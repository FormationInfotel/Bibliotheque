package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.interfaces.RegistrationDAO;
import com.infotel.formation.interfaces.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	
	@Autowired
	RegistrationDAO registrationDAO;
}	
