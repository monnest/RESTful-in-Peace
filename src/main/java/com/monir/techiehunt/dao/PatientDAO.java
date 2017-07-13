package com.monir.techiehunt.dao;

import com.monir.techiehunt.model.Patient;

import java.util.List;

public interface PatientDAO {

	public void addPatient(Patient patient);

	public List<Patient> getAllPatients();

	public void deletePatient(Integer patientId);

	public Patient updatePatient(Patient patient);

	public Patient getPatient(int patientid);
}
