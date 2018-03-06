package com.infotel.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.formation.entity.Registration;
import com.infotel.formation.interfaces.RegistrationDAO;


@Repository
@Transactional
public class RegistrationDAOImpl implements RegistrationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertRegistration(Registration registration) {
		sessionFactory.getCurrentSession().save(registration);
	}

	@Override
	public Registration getRegistrationById(int registrationId) {
		Registration registrationById = null;

		for (Registration registration : getRegistrations()) {
			if (registration != null && registration.getRegistration_id() > 0
					&& registration.getRegistration_id() == registrationId) {
				registrationById = registration;
				break;
			}
		}

		if (registrationById == null) {
			throw new IllegalArgumentException("No Registration found with the Registration id : " + registrationId);
		}
		return registrationById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getRegistrations() {
		List<Registration> result = (List<Registration>) sessionFactory.getCurrentSession()
				.createQuery("from Registration").list();
		return result;
	}

}
