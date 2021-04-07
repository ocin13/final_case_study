package com.casestudy.caseStudy.controller;



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
			//send the company information object to the index page
			Company company = cs.getCompany();
			mav.addObject("company", company);
			return mav;
		}
		
		//display the login page
		 @GetMapping("/login")
		    public String login() {
		        return "login";
		    }
		
		 //show the register form
		@GetMapping(value="/signup")
		public ModelAndView signupForm() {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		}
		
		//register new user to the database
		@PostMapping(value="/signup")
		public ModelAndView signupNewAccount(@ModelAttribute @Valid User user,BindingResult bindingResult,
				@RequestParam("passCon") String passCon) {
			ModelAndView mav = new ModelAndView("signup");
			//check the user information validity
			if(bindingResult.hasErrors()) {
				//check if there is any error related to the user name field
					if(bindingResult.getFieldError("userName") != null) {
					mav.addObject("nameError", bindingResult.getFieldError("userName").getDefaultMessage());
					}
					//check if there is any errors related to the email field
					if(bindingResult.getFieldError("email") != null) {
					mav.addObject("emailError", bindingResult.getFieldError("email").getDefaultMessage());
					}
					//check if there is any errors related to the password field
					if(bindingResult.getFieldError("password") != null) {
						mav.addObject("passError", bindingResult.getFieldError("password").getDefaultMessage());
					}
						
					String message = "register new account failed";
					mav.addObject("message", message);
			}
			//check if the password matches the confirmation password field 
			else if(!user.getPassword().equals(passCon)) {
				String conPassError = "password confirmation does not match";
				mav.addObject("conPassError", conPassError);
				String message = "register new account failed";
				mav.addObject("message", message);
			}
			//if all the validations are passed register the new user account
			else {
				
				us.addNewUser(user);
				String message = "registred successefully";
				mav.addObject("message", message);
			}
			return mav;
		}
		
		
	
	
	
}
