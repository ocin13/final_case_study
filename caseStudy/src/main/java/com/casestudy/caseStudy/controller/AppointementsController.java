package com.casestudy.caseStudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AppointmentService;
import com.casestudy.caseStudy.services.DepartmentService;
import com.casestudy.caseStudy.services.DoctorService;
import com.casestudy.caseStudy.services.UserServiceImp;

@Controller
public class AppointementsController {
	
	@Autowired
	AppointmentService as;
	
	@Autowired
	DepartmentService ds;
	
	@Autowired
	DoctorService drs;
	
	@Autowired
	UserServiceImp us;
	
	
	//show list of appointments available in the database
	@RequestMapping("/appointments")
	public ModelAndView  showAppointements() {
		ModelAndView mav = new ModelAndView("appointments");
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		List<Department> departmentsList = new ArrayList<Department>();
		departmentsList = ds.getAllDepartments();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
			Doctor doctor = drs.getDoctorByUserName(auth.getName()).get(0);
			Integer curDocId = doctor.getDocId();
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAppByDoctorId(curDocId).stream().filter(app -> app.isReserved() == true).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT")) || auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER")))
		{
			Appointment appointment = as.getByUserName(auth.getName());
			mav.addObject("reservedApp", appointment);
			
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAllAppointments().stream().filter(app -> app.isReserved() == false).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}
		else {
			appointmentsList = as.getAllAppointments();
		}
		mav.addObject("departmentsList", departmentsList);
		mav.addObject("appointmentsList", appointmentsList);
		return mav;
	}
	
	//show appointment form
	@RequestMapping("/newAppointment")
	public ModelAndView showAppointemtForm() {
		ModelAndView mav = new ModelAndView("appointments_form");
		List<Department> departmentsList = new ArrayList<Department>();
		List<Doctor> doctorsList = new ArrayList<Doctor>(); 
		try {
			departmentsList = ds.getAllDepartments();
			mav.addObject("departmentsList", departmentsList);
			doctorsList = drs.getAllDoctors();
			mav.addObject("doctorsList", doctorsList);
		}catch(Exception e) {
			System.out.print("no depatment found");
		}
		return mav;
	}
	
	//insert new appointment to the database
	@RequestMapping("/addAppointment")
	public ModelAndView addNewAppointment(@ModelAttribute Appointment appointment, @RequestParam("doctorId") Integer doctorId) {
		ModelAndView mav = new ModelAndView("appointments_form");
		if(appointment == null) {
			mav = new ModelAndView("/appointments_form");
			String message = "register new appointment failed";
			mav.addObject("message", message);
		}else {
			List<Department> departmentsList = new ArrayList<Department>();
			List<Doctor> doctorsList = new ArrayList<Doctor>(); 
			mav = new ModelAndView("appointments_form");
			Doctor doctor = drs.getDoctorById(doctorId);
			appointment.setDoctor(doctor);
			as.addNewAppointment(appointment);
			String message = "register new appointment completed successefully";
			mav.addObject("message", message);
			departmentsList = ds.getAllDepartments();
			mav.addObject("departmentsList", departmentsList);
			doctorsList = drs.getAllDoctors();
			mav.addObject("doctorsList", doctorsList);
		}
		return mav;
	}
	
	//show edit appointment form
	@RequestMapping(value="/editAppointment{aptId}", method=RequestMethod.GET)
	public ModelAndView showAppEditForm(@PathVariable("aptId") Integer aptId) {
		ModelAndView mav = new ModelAndView("appointments_form");
		try {
			Appointment appToUpdate = as.getAppointmentById(aptId);
			mav.addObject("appointment", appToUpdate);
		}catch(Exception e) {
			String message = "appointment not found";
			mav.addObject("message", message);
		}
		return mav;
	}
	//edit appointment
	@RequestMapping("/editAppointment")
	public ModelAndView editApp(@ModelAttribute Appointment appointment) {
		ModelAndView mav = new ModelAndView("appointments_form");
		try {
			as.updateAppointmentById(appointment.getAptId(), appointment);
			String message = "appointment updated successefully";
			mav.addObject("message", message);
			List<Department> departmentsList = new ArrayList<Department>();
			List<Doctor> doctorsList = new ArrayList<Doctor>(); 
			departmentsList = ds.getAllDepartments();
			mav.addObject("departmentsList", departmentsList);
			doctorsList = drs.getAllDoctors();
			mav.addObject("doctorsList", doctorsList);
		}catch(Exception e) {
			String message = "appointment updated failed";
			mav.addObject("message", message);
			
		}
		return mav;
	}
	
	//delete an appointment by id value
	@RequestMapping(value="/deleteAppointment{aptId}", method=RequestMethod.GET)
	public ModelAndView deleteApp(@PathVariable("aptId") Integer aptId) {
		ModelAndView mav = new ModelAndView("appointments");
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList = as.getAllAppointments();
		List<Department> departmentsList = new ArrayList<Department>();
		departmentsList = ds.getAllDepartments();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			as.deleteAppointmentById(aptId);
			if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT")) || auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
				Appointment appointment = as.getByUserName(auth.getName());
				mav.addObject("reservedApp", appointment);
				List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
				as.getAllAppointments().stream().filter(app -> app.isReserved() == false).forEach(app -> appointmentsListCollector.add(app));
				appointmentsList = appointmentsListCollector;
			}
			
			mav.addObject("appointmentsList", appointmentsList);
		}catch(Exception e) {
			System.out.print("delete appointment failed");
		}
		mav.addObject("departmentsList", departmentsList);
		return mav;
	}
	
	//reserve an appointment using the current user object details
	@RequestMapping(value="/reserveAppointment{aptId}", method=RequestMethod.GET)
	public ModelAndView reserveApp(@PathVariable("aptId") Integer aptId) {
		ModelAndView mav = new ModelAndView("appointments");
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList = as.getAllAppointments();
		List<Department> departmentsList = new ArrayList<Department>();
		departmentsList = ds.getAllDepartments();
		
		//instance of the Authentication made available by spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User curUser = us.getUserByUserNmae(auth.getName());
		Appointment checkIfAlreadyHasApp = as.getByUserName(auth.getName());
		boolean checkIfAppIsAlreadyToken = as.getAppointmentById(aptId).isReserved();
		//check if user has already an appointment
		if(checkIfAlreadyHasApp != null) {
			String message = "you already have booked an appointment ";
			mav.addObject("message", message);
		}
		//check if the appointment is available
		else if(checkIfAppIsAlreadyToken){
			String message = "this appointment is not available please choose another one ";
			mav.addObject("message", message);
		}
		//reserve the appointment
		else {
			as.confirmAppointment(aptId, auth.getName(), curUser.getEmail());
			String message = "you successefully reserved an appointment ";
			mav.addObject("message", message);
		}
		//if user is USER display list of available appointments only
		if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT")) || auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
			Appointment appointment = as.getByUserName(auth.getName());
			mav.addObject("reservedApp", appointment);
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAllAppointments().stream().filter(app -> app.isReserved() == false).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}
		//if user is USER doctor display his/her related appointments only
		if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
			Doctor doctor = drs.getDoctorByUserName(auth.getName()).get(0);
			Integer curDocId = doctor.getDocId();
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAppByDoctorId(curDocId).stream().filter(app -> app.isReserved() == true).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}
		
		mav.addObject("departmentsList", departmentsList);
		mav.addObject("appointmentsList", appointmentsList);
		return mav;
	}
	
	//cancel appointment and reset that specific appointment to make it a vailable again
	@RequestMapping(value="/cancelAppointment{aptId}", method=RequestMethod.GET)
	public ModelAndView cancelApp(@PathVariable("aptId") Integer aptId) {
		ModelAndView mav = new ModelAndView("appointments");
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		List<Department> departmentsList = new ArrayList<Department>();
		departmentsList = ds.getAllDepartments();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Appointment appointment = as.getAppointmentById(aptId);
		boolean checkIfAppIsAlreadyToken = as.getAppointmentById(aptId).isReserved();
		if(checkIfAppIsAlreadyToken){
			appointment.setReserved(false);
			appointment.setUserName(" ");
			appointment.setEmail(" ");
			as.updateAppointmentById(aptId, appointment);
			String message = "this appointment has been cancelled";
			mav.addObject("message", message);
		}
		else {
			String message = "this appointment is not reserved";
			mav.addObject("message", message);
		}
		mav.addObject("departmentsList", departmentsList);
		appointmentsList = as.getAllAppointments();
		mav.addObject("appointmentsList", appointmentsList);
		return mav;
	}
	
	//get appointments by department name
	@RequestMapping(value="/appointmentByDep",method=RequestMethod.GET)
	public ModelAndView filterAppointmentByDepName(@RequestParam("depName") String depName) {
		ModelAndView mav = new ModelAndView("appointments");
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		List<Department> departmentsList = new ArrayList<Department>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
			Doctor doctor = drs.getDoctorByUserName(auth.getName()).get(0);
			Integer curDocId = doctor.getDocId();
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAppByDepName(depName).stream().filter(app -> app.getDoctor().getDocId() == curDocId).filter(app -> app.isReserved() == true).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT")) || auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER")))
		{
			Appointment appointment = as.getByUserName(auth.getName());
			mav.addObject("reservedApp", appointment);
			
			List<Appointment> appointmentsListCollector = new ArrayList<Appointment>();
			as.getAppByDepName(depName).stream().filter(app -> app.isReserved() == false).forEach(app -> appointmentsListCollector.add(app));
			appointmentsList = appointmentsListCollector;
		}
		else {
			appointmentsList = as.getAppByDepName(depName);
		}
		
		departmentsList = ds.getAllDepartments();
		mav.addObject("departmentsList", departmentsList);
		mav.addObject("appointmentsList", appointmentsList);
		return mav;
	}

}
