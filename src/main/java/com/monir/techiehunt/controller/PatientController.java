package com.monir.techiehunt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.monir.techiehunt.model.Patient;
import com.monir.techiehunt.service.PatientService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PatientController {

	private static final Logger logger = Logger
			.getLogger(PatientController.class);

	public PatientController() {
		System.out.println("PatientController()");
	}

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/")
	public ModelAndView listPatient(ModelAndView model) throws IOException {
		List<Patient> listPatient = patientService.getAllPatients();
		model.addObject("listPatient", listPatient);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Patient patient = new Patient();
		model.addObject("patient", patient);
		model.setViewName("PatientForm");
		return model;
	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute Patient patient) {
		if (patient.getId() == 0) { // if patient id is 0 then creating the
			// patient other updating the patient
			patientService.addPatient(patient);
		} else {
			patientService.updatePatient(patient);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public ModelAndView deletePatient(HttpServletRequest request) {
		int patientId = Integer.parseInt(request.getParameter("id"));
		patientService.deletePatient(patientId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editPatient", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int patientId = Integer.parseInt(request.getParameter("id"));
		Patient patient = patientService.getPatient(patientId);
		ModelAndView model = new ModelAndView("PatientForm");
		model.addObject("patient", patient);

		return model;
	}

}