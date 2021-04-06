package com.casestudy.caseStudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Company;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.CompanyServiceImp;
import com.casestudy.caseStudy.services.DepartmentServiceImp;
import com.casestudy.caseStudy.services.DoctorServiceImp;
import com.casestudy.caseStudy.services.UserService;
import com.casestudy.caseStudy.services.UserServiceImp;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	DepartmentServiceImp ds;
	@Autowired
	CompanyServiceImp cs;
	@Autowired
	DoctorServiceImp dos;
	@Autowired
	UserServiceImp us;
	//display the main page
		@GetMapping({"/", "/index"})
		public ModelAndView showMainPage() {
			ModelAndView mav = new ModelAndView("index");
			List<Department> departmentsList = new ArrayList<Department>();
			List<Doctor> doctorsList = new ArrayList<Doctor>();
			departmentsList = ds.getAllDepartments();
			mav.addObject("departmentsList", departmentsList);
			if(dos.getAllDoctors().size() == 1) {
				doctorsList.add(dos.getAllDoctors().get(0));
				}
			if(dos.getAllDoctors().size() >= 2) {
			doctorsList.add(dos.getAllDoctors().get(1));
			}
			mav.addObject("doctorsList", doctorsList);
			Company company = cs.getCompany();
			mav.addObject("company", company);
			return mav;
		}
		
		 @GetMapping("/login")
		    public String login() {
		        return "login";
		    }
		
		@GetMapping(value="/signup")
		public ModelAndView signupForm() {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		}
		
		@PostMapping(value="/signup")
		public ModelAndView signupNewAccount(@ModelAttribute @Valid User user,BindingResult bindingResult,
				@RequestParam("passCon") String passCon) {
			ModelAndView mav = new ModelAndView("signup");
			if(bindingResult.hasErrors()) {
					if(bindingResult.getFieldError("userName") != null) {
					mav.addObject("nameError", bindingResult.getFieldError("userName").getDefaultMessage());
					}
					if(bindingResult.getFieldError("email") != null) {
					mav.addObject("emailError", bindingResult.getFieldError("email").getDefaultMessage());
					}
					if(bindingResult.getFieldError("password") != null) {
						mav.addObject("passError", bindingResult.getFieldError("password").getDefaultMessage());
					}
						
					String message = "register new account failed";
					mav.addObject("message", message);
			}else if(!user.getPassword().equals(passCon)) {
				String conPassError = "password confirmation does not match";
				mav.addObject("conPassError", conPassError);
				String message = "register new account failed";
				mav.addObject("message", message);
			}
			
			else {
				us.addNewUser(user);
				String message = "registred successefully";
				mav.addObject("message", message);
			}
			return mav;
		}
		
		
	
	
	
}
