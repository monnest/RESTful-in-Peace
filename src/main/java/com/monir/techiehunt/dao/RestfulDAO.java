package com.monir.techiehunt.dao;


import com.monir.techiehunt.model.Doctor;
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

    public List getAllDoctors() {
        Session session = this.sessionFactory.getCurrentSession();
        List doctorList = session.createQuery("from Doctor").list();
        return doctorList;
    }
    public Doctor getDoctor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor doctor = (Doctor) session.load(Doctor.class, new Integer(id));
        return doctor;
    }
    public Doctor addDoctor(Doctor doctor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(doctor);
        return doctor;
    }
    public void updateDoctor(Doctor doctor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(doctor);
    }
    public void deleteDoctor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor p = (Doctor) session.load(Doctor.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}
