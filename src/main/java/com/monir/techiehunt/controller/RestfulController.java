package com.monir.techiehunt.controller;

import com.monir.techiehunt.model.Patient;
import com.monir.techiehunt.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/patients")
public class RestfulController {

    @Autowired
    RestfulService restfulService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getPatients() {
        List listOfPatients = restfulService.getAllPatients();
        return listOfPatients;
    }
    @RequestMapping(value = "/getpatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Patient getPatientById(@PathVariable int id) {
        return restfulService.getPatient(id);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addPatient(@RequestBody Patient patient) {
         restfulService.addPatient(patient);
    }
    @RequestMapping(value = "/updatePatient", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateCountry(@RequestBody Patient patient) {
        restfulService.updatePatient(patient);
    }
    @RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deletePatient(@PathVariable("id") int id) {
        restfulService.deletePatient(id);
    }

}


