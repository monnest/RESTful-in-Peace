package com.monir.techiehunt.controller;
import com.monir.techiehunt.model.Doctor;
import com.monir.techiehunt.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class DoctorController {

	public DoctorController() {
		System.out.println("DoctorController()");
	}

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/viewList")
	public ModelAndView listDoctor(ModelAndView model) throws IOException {
		List<Doctor> listDoctor = doctorService.getAllDoctors();
		model.addObject("listDoctor", listDoctor);
		model.setViewName("doctorHome");
		return model;
	}

	@RequestMapping(value = "/newDoctor", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Doctor doctor = new Doctor();
		model.addObject("doctor", doctor);
		model.setViewName("addDoctor");
		return model;
	}

	@RequestMapping(value = "/saveDoctor", method = RequestMethod.POST)
	public ModelAndView saveDoctor(@ModelAttribute Doctor doctor) {
		if (doctor.getDoctorId() == 0) { // if doctor id is 0 then creating the
			// doctor other updating the doctor
			doctorService.addDoctor(doctor);
		} else {
			doctorService.updateDoctor(doctor);
		}
		return new ModelAndView("redirect:/viewList");
	}
	@Secured("ROLE_USER")
	@RequestMapping(value = "/deleteDoctor", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(HttpServletRequest request) {
		Integer doctorId = Integer.parseInt(request.getParameter("id"));
		doctorService.deleteDoctor(doctorId);
		return new ModelAndView("redirect:/viewList");
	}

	@RequestMapping(value = "/editDoctor", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int doctorId = Integer.parseInt(request.getParameter("id"));
		Doctor doctor = doctorService.getDoctor(doctorId);
		ModelAndView model = new ModelAndView("addDoctor");
		model.addObject("doctor", doctor);

		return model;
	}

/*	*//*Login Part*//*
*//*	@RequestMapping(value = "/welcome**", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;*//*
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
	}*/

}