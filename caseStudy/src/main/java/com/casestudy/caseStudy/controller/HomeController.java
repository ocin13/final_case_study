package com.casestudy.caseStudy.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Company;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.Employee;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.Statistics;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.AddressService;
import com.casestudy.caseStudy.services.CompanyServiceImp;
import com.casestudy.caseStudy.services.DoctorServiceImp;
import com.casestudy.caseStudy.services.EmployeeServiceImp;
import com.casestudy.caseStudy.services.PatientService;
import com.casestudy.caseStudy.services.StatisticsService;
import com.casestudy.caseStudy.services.UserServiceImp;

@Controller
public class HomeController {
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
	@Autowired
	CompanyServiceImp cs;
	
		//display the home page
		@RequestMapping("/home")
		public String showhome(){
			return "home";
		}
		//display the welcome page and get the current user object from the session
		@RequestMapping("/welcome")
		public ModelAndView displayWelcomePage(HttpSession session) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object profile;
			//if user is PATIENT get the user properties from patients table
			if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("PATIENT"))) {
	        	Patient patient = ps.getPatientByUserName(auth.getName()).get(0);
	        	profile = patient;
	        	
	        	
	        }
			//if user is DOCTOR get the user properties from doctors table
			else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
	        	Doctor doctor = ds.getDoctorByUserName(auth.getName()).get(0);
	        	profile = doctor;
	        	
	        }
			//if user is EMPLOYEE get the user properties from employees table
			else if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE"))) {
	        	Employee employee = es.getEmployeeByAccountUserName(auth.getName()).get(0);
	        	profile = employee;
	        	
	        }else {
	        	profile = null;
	        }
			session.setAttribute("profile", profile);
			return new ModelAndView("welcome");
		}
		
		//display the settings page
		@RequestMapping("/settings")
		public ModelAndView settings() throws Exception {
			ModelAndView mav =  new ModelAndView("settings");
			Company company = cs.getCompany();
			mav.addObject("company", company);
			return mav;
		}
		//save new settings 
		@RequestMapping("/saveSettings")
		public ModelAndView saveSettings(@ModelAttribute Company company) throws Exception {
			ModelAndView mav =  new ModelAndView("settings");
			cs.updateCompanyInformation(company, company.getId());
			mav.addObject("company", company);
			return mav;
		}
		
		
	

	    
}
