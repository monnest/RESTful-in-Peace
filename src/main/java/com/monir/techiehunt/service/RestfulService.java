package com.monir.techiehunt.service;

import com.monir.techiehunt.dao.RestfulDAO;
import com.monir.techiehunt.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service("restfulService")
public class RestfulService {

    @Autowired
    RestfulDAO restfulDAO;

    @Transactional
    public List getAllPatients() {
        return restfulDAO.getAllPatients();
    }
    @Transactional
    public Patient getPatient(int id) {
        return restfulDAO.getPatient(id);
    }
    @Transactional
    public void addPatient(Patient patient) {
        restfulDAO.addPatient(patient);
    }
    @Transactional
    public void updatePatient(Patient patient) {
        restfulDAO.updatePatient(patient);
    }
    @Transactional
    public void deletePatient(int id) {
        restfulDAO.deletePatient(id);
    }
}
