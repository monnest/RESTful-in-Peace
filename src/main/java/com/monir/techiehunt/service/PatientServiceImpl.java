package com.monir.techiehunt.service;

import java.util.List;

import com.monir.techiehunt.dao.PatientDAO;
import com.monir.techiehunt.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public void addPatient(Patient patient) {
		patientDAO.addPatient(patient);
	}

	@Override
	@Transactional
	public List<Patient> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	@Transactional
	public void deletePatient(Integer patientId) {
		patientDAO.deletePatient(patientId);
	}

	@Transactional(readOnly=true)
	public Patient getPatient(int patid) {
		return patientDAO.getPatient(patid);
	}

	public Patient updatePatient(Patient patient) {
		return patientDAO.updatePatient(patient);
	}

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

}
