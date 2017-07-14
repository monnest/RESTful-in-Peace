package com.monir.techiehunt.service;

import com.monir.techiehunt.dao.DoctorDAO;
import com.monir.techiehunt.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    @Transactional
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    @Override
    @Transactional
    public void deleteDoctor(Integer doctorId) {
        doctorDAO.deleteDoctor(doctorId);
    }

    public Doctor getDoctor(int docId) {
        return doctorDAO.getDoctor(docId);
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
}
