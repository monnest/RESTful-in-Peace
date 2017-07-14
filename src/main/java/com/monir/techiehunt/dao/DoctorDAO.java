package com.monir.techiehunt.dao;


import com.monir.techiehunt.model.Doctor;

import java.util.List;

public interface DoctorDAO {

    public void addDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    public void deleteDoctor(Integer doctorId);

    public Doctor updateDoctor(Doctor doctor);

    public Doctor getDoctor(int doctorId);
}
