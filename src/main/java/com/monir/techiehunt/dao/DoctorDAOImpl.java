package com.monir.techiehunt.dao;


import com.monir.techiehunt.model.Doctor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("doctorDao")
public class DoctorDAOImpl implements DoctorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addDoctor(Doctor doctor) {
        sessionFactory.getCurrentSession().saveOrUpdate(doctor);

    }

    @SuppressWarnings("unchecked")
    public List<Doctor> getAllDoctors() {

        return sessionFactory.getCurrentSession().createQuery("from Doctor").list();
    }


    public void deleteDoctor(Integer doctorId) {
        Doctor patient = (Doctor) sessionFactory.getCurrentSession().load(
                Doctor.class, doctorId);
        if (null != patient) {
            this.sessionFactory.getCurrentSession().delete(patient);
        }

    }

    public Doctor getDoctor(Integer doctorId) {
        return (Doctor) sessionFactory.getCurrentSession().get(
                Doctor.class, doctorId);
    }

    public Doctor updateDoctor(Doctor doctor) {
        sessionFactory.getCurrentSession().update(doctor);
        return doctor;
    }
}
