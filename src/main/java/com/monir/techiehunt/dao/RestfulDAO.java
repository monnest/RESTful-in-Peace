package com.monir.techiehunt.dao;


import com.monir.techiehunt.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestfulDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List getAllPatients() {
        Session session = this.sessionFactory.getCurrentSession();
        List patientList = session.createQuery("from Patient").list();
        return patientList;
    }
    public Patient getPatient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(id));
        return patient;
    }
    public Patient addPatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(patient);
        return patient;
    }
    public void updatePatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(patient);
    }
    public void deletePatient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}
