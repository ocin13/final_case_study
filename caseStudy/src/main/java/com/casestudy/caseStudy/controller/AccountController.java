package com.casestudy.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.UserServiceImp;

@Controller
public class AccountController {
	@Autowired
	UserServiceImp us;
	//display a list of all existing accounts in the data base
	@RequestMapping("/accounts")
	public ModelAndView showAccounts() {
		ModelAndView mav = new ModelAndView("accounts");
		List<User> accounts = us.getAllUsers();
		mav.addObject("accounts", accounts);
		return mav;
	}
}
