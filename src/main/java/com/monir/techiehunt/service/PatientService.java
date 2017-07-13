package com.monir.techiehunt.service;

import com.monir.techiehunt.model.Patient;

import java.util.List;


public interface PatientService {
	
	public void addPatient(Patient patient);

	public List<Patient> getAllPatients();

	public void deletePatient(Integer patientId);

	public Patient getPatient(int patientid);

	public Patient updatePatient(Patient patient);
}
