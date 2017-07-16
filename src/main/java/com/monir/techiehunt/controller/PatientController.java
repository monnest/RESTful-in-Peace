package com.monir.techiehunt.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monir.techiehunt.model.Doctor;
import com.monir.techiehunt.model.Patient;
import com.monir.techiehunt.service.DoctorService;
import com.monir.techiehunt.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PatientController {

	public PatientController() {
		System.out.println("PatientController()");
	}

	@Autowired
	private PatientService patientService;

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/")
	public ModelAndView listPatient(ModelAndView model) throws IOException {
		List<Patient> listPatient = patientService.getAllPatients();
		model.addObject("listPatient", listPatient);
		model.setViewName("home");
		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

		binder.registerCustomEditor(Doctor.class, "doctorId", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue((text.equals(""))?null:doctorService.getDoctor(Integer.parseInt((String)text)));
			}
		});
	}

	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public ModelAndView newContact(@ModelAttribute("command")  Doctor doctor,
								   BindingResult result) {
		Patient patient = new Patient();
		Map<String, Object> doctorMap = new HashMap<String, Object>();
		doctorMap.put("doctorList", doctorService.getAllDoctors());
		doctorMap.put("patient",  patient);
		return new ModelAndView("PatientForm", doctorMap);
	}
	@RequestMapping(value = "/editPatient", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int patientId = Integer.parseInt(request.getParameter("id"));
		Patient patient = patientService.getPatient(patientId);
		ModelAndView model = new ModelAndView("PatientForm");
		model.addObject("patient", patient);

		return model;
	}
	@RequestMapping(value = { "/savePatient" }, method = RequestMethod.POST)
	public String savePatient(@ModelAttribute Patient patient, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			return "home";
		}
		if (patient.getId() == 0) { // if patient id is 0 then creating the
			// patient other updating the patient
			patientService.addPatient(patient);
		} else {
			patientService.updatePatient(patient);
		}

		model.addAttribute("success", "Patient " + patient.getName() + " registered successfully");
		//return "success";
		return "home";
	}


	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public ModelAndView deletePatient(HttpServletRequest request) {
		int patientId = Integer.parseInt(request.getParameter("id"));
		patientService.deletePatient(patientId);
		return new ModelAndView("redirect:/");
	}



	/*Login Part*/
/*	@RequestMapping(value = "/welcome**", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;*/
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView redirect() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

}