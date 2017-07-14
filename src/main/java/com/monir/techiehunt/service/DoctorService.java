package com.monir.techiehunt.service;
import com.monir.techiehunt.model.Doctor;

import java.util.List;

public interface DoctorService {

    public void addDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    public void deleteDoctor(Integer doctorId);

    public Doctor updateDoctor(Doctor doctor);

    public Doctor getDoctor(int doctorId);
}
