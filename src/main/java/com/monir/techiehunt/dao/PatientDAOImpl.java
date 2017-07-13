package com.monir.techiehunt.dao;

import java.util.List;

import com.monir.techiehunt.model.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPatient(Patient patient) {
		sessionFactory.getCurrentSession().saveOrUpdate(patient);

	}

	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {

		return sessionFactory.getCurrentSession().createQuery("from Patient").list();
	}


	public void deletePatient(Integer patientId) {
		Patient patient = (Patient) sessionFactory.getCurrentSession().load(
				Patient.class, patientId);
		if (null != patient) {
			this.sessionFactory.getCurrentSession().delete(patient);
		}

	}

	public Patient getPatient(int patientId) {
		return (Patient) sessionFactory.getCurrentSession().get(
				Patient.class, patientId);
	}

	public Patient updatePatient(Patient patient) {
		sessionFactory.getCurrentSession().update(patient);
		return patient;
	}

}