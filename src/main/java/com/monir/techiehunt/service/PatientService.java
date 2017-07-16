package com.monir.techiehunt.service;

import com.monir.techiehunt.model.Patient;
import org.springframework.security.access.annotation.Secured;

import java.util.List;


public interface PatientService {
	
	public void addPatient(Patient patient);

	public List<Patient> getAllPatients();

	@Secured({ "ROLE_DBA", "ROLE_ADMIN" })
	public void deletePatient(Integer patientId);

	public Patient getPatient(int patientid);

	public Patient updatePatient(Patient patient);
}
