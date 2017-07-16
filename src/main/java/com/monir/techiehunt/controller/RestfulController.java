package com.monir.techiehunt.controller;

import com.monir.techiehunt.model.Doctor;
import com.monir.techiehunt.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/doctors")
public class RestfulController {

    @Autowired
    RestfulService restfulService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getDoctors() {
        List listOfDoctors = restfulService.getAllDoctors();
        return listOfDoctors;
    }
    @RequestMapping(value = "/getdoctor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Doctor getDoctorById(@PathVariable int id) {
        return restfulService.getDoctor(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addDoctor(@RequestBody Doctor doctor) {
         restfulService.addDoctor(doctor);
    }

    @RequestMapping(value = "/updateDoctor", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateDoctor(@RequestBody Doctor doctor) {

        restfulService.updateDoctor(doctor);
    }

    @RequestMapping(value = "/deleteDoctor/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteDoctor(@PathVariable("id") int id) {
        restfulService.deleteDoctor(id);
    }

}


