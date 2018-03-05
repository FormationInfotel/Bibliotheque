package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Registration;

public interface RegistrationDAO {
	void insertRegistration(Registration registration);

	public Registration getRegistrationById(int registrationId);

	List<Registration> getRegistrations();
}
