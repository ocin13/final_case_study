package com.casestudy.caseStudy.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.Employee;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AddressService;
import com.casestudy.caseStudy.services.DoctorServiceImp;
import com.casestudy.caseStudy.services.EmployeeServiceImp;
import com.casestudy.caseStudy.services.PatientService;
import com.casestudy.caseStudy.services.UserServiceImp;

import antlr.collections.List;

@Controller
public class ProfileController {
	
	@Autowired
	UserServiceImp us;
	@Autowired
	EmployeeServiceImp es;
	@Autowired
	DoctorServiceImp ds;
	@Autowired
	PatientService ps;
	@Autowired
	AddressService as;
	
	
	@RequestMapping("/profile")
	public ModelAndView showProfile(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("profile");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        Object profile;
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT"))) {
        	Patient patient = ps.getPatientByUserName(auth.getName()).get(0);
        	profile = patient;
        	mav.addObject("id", patient.getpId());
        	
        }else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
        	Doctor doctor = ds.getDoctorByUserName(auth.getName()).get(0);
        	profile = doctor;
        	mav.addObject("id", doctor.getDocId());
        }else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE"))) {
        	Employee employee = es.getEmployeeByAccountUserName(auth.getName()).get(0);
        	profile = employee;
        	mav.addObject("id", employee.getEmpId());
        }else {
        	profile = null;
        }
        mav.addObject("profile", profile);
		return mav;
	}
	
	@RequestMapping("/edit_profile")
	public ModelAndView showeditProfileForm(@RequestParam("firstName") String firstName,
			@RequestParam("lastName")  String lastName,
			@RequestParam("dateOfBirth")  String dateOfBirth,
			@RequestParam("gender")  String gender,@RequestParam("street")  String street,
			@RequestParam("apt")  String apt,@RequestParam("city")  String city,
			@RequestParam("state")  String state,@RequestParam("zip")  Integer zip,
			@RequestParam("phone")  Long phone) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mav = new ModelAndView("profile");
		 if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE"))) {
			 Employee employeeToUpdate = es.getEmployeeByAccountUserName(auth.getName()).get(0);
			 
			 	employeeToUpdate.setEmpId(employeeToUpdate.getEmpId());
			 	employeeToUpdate.setFirstName(firstName);
			 	employeeToUpdate.setLastName(lastName);
			 	employeeToUpdate.setDateOfBirth(dateOfBirth);
			 	employeeToUpdate.setGender(gender);
			 	employeeToUpdate.setPhone(phone);
			 	employeeToUpdate.setOccupation(employeeToUpdate.getOccupation());
			 	employeeToUpdate.setAccount(employeeToUpdate.getAccount());
				Address newAddress = new Address(street,apt,city,state,zip);
				employeeToUpdate.setAddress(newAddress);
				es.updateEmployeeById(employeeToUpdate.getEmpId(), employeeToUpdate);
				mav.addObject("profile", employeeToUpdate);
	        	
	        }else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
	        	Doctor doctorToUpdate = ds.getDoctorByUserName(auth.getName()).get(0);
	        	doctorToUpdate.setDocId(doctorToUpdate.getDocId());
	        	doctorToUpdate.setFirstName(firstName);
	        	doctorToUpdate.setLastName(lastName);
	        	doctorToUpdate.setDateOfBirth(dateOfBirth);
	        	doctorToUpdate.setGender(gender);
	        	doctorToUpdate.setPhone(phone);
	        	doctorToUpdate.setSpeciality(doctorToUpdate.getSpeciality());
	        	doctorToUpdate.setAccount(doctorToUpdate.getAccount());
				Address newAddress = new Address(street,apt,city,state,zip);
				doctorToUpdate.setAddress(newAddress);
				ds.updateDoctorById(doctorToUpdate.getDocId(), doctorToUpdate);
				mav.addObject("profile", doctorToUpdate);
	        }else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT"))) {
	        	Patient patientToUpdate = ps.getPatientByUserName(auth.getName()).get(0);
	        	patientToUpdate.setpId(patientToUpdate.getpId());
	        	patientToUpdate.setFirstName(firstName);
	        	patientToUpdate.setLastName(lastName);
	        	patientToUpdate.setDateOfBirth(dateOfBirth);
	        	patientToUpdate.setGender(gender);
	        	patientToUpdate.setPhone(phone);
	        	patientToUpdate.setAccount(patientToUpdate.getAccount());
				Address newAddress = new Address(street,apt,city,state,zip);
				patientToUpdate.setAddress(newAddress);
				ps.updatePatientById(patientToUpdate.getpId(), patientToUpdate);
				mav.addObject("profile", patientToUpdate);
	        }
	        
	        else {
	        	Patient patient = new Patient();
	        	patient.setFirstName(firstName);
				patient.setLastName(lastName);
				patient.setDateOfBirth(dateOfBirth);
				patient.setGender(gender);
				patient.setPhone(phone);
				Address newAddress = new Address(street,apt,city,state,zip);
				as.addNewAddress(newAddress);
				ps.addNewPatient(patient);
	        }
		return mav;
	}
}
