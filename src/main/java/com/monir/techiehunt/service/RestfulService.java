package com.monir.techiehunt.service;

import com.monir.techiehunt.dao.RestfulDAO;
import com.monir.techiehunt.model.Doctor;
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
    public List getAllDoctors() {
        return restfulDAO.getAllDoctors();
    }
    @Transactional
    public Doctor getDoctor(int id) {
        return restfulDAO.getDoctor(id);
    }
    @Transactional
    public void addDoctor(Doctor doctor) {
        restfulDAO.addDoctor(doctor);
    }
    @Transactional
    public void updateDoctor(Doctor doctor) {
        restfulDAO.updateDoctor(doctor);
    }
    @Transactional
    public void deleteDoctor(int id) {
        restfulDAO.deleteDoctor(id);
    }
}
