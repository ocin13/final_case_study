package com.casestudy.caseStudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.services.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService ds;
	
	@RequestMapping("/departments")
	public ModelAndView showDepartments() {
		ModelAndView mav = new ModelAndView("departments");
		List<Department> departmentsList = new ArrayList<Department>();
		try {
			departmentsList = ds.getAllDepartments();
			mav.addObject("departmentsList", departmentsList);
		}catch(Exception e) {
			System.out.print("no depatment found");
		}
		return mav;
	}
	
	@RequestMapping("/newDepartment")
	public ModelAndView showDepartmentForm() {
		ModelAndView mav = new ModelAndView("department_form");
		return mav;
	}
	
	@RequestMapping(value="addDepartment", method=RequestMethod.POST)
	public ModelAndView addNewDep(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("department_form");
		
		if(bindingResult.hasErrors()) {
			if(bindingResult.getFieldError("name") != null) {
			mav.addObject("nameError", bindingResult.getFieldError("name").getDefaultMessage());
			}
			if(bindingResult.getFieldError("description") != null) {
			mav.addObject("descError", bindingResult.getFieldError("description").getDefaultMessage());
			}
			String message = "register new department failed";
			mav.addObject("message", message);
		}else {
			ds.addNewDepartment(department);
			String message = "register new department completed successefully";
			mav.addObject("message", message);
		}
		return mav;
	}
	
	@RequestMapping(value="editDepartment{depId}", method=RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable("depId") Integer depId) {
		ModelAndView mav = new ModelAndView("department_form");
		try {
			Department depToUpdate = ds.getDepartmentById(depId);
			mav.addObject("department", depToUpdate);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return mav;
	}
	
	//edit department
	@RequestMapping(value="editDepartment", method=RequestMethod.POST)
	public ModelAndView editDep(@ModelAttribute Department department) {
		ModelAndView mav = new ModelAndView("department_form");
		try {
			ds.updateDepartmentById(department.getDepId(), department);
			String message = "department updated successefully";
			mav.addObject("message", message);
		}catch(Exception e) {
			String message = "department updated failed";
			mav.addObject("message", message);
		}
		return mav;
	}
	
	//delete department
	
		@RequestMapping(value="/deleteDepartment{depId}", method=RequestMethod.GET)
		public ModelAndView deleteDep(@PathVariable("depId") Integer depId) {
			ModelAndView mav = new ModelAndView("departments");
			List<Department> departmentsList = new ArrayList<Department>();
			try {
				ds.deleteDepartmentById(depId);
				departmentsList = ds.getAllDepartments();
				mav.addObject("departmentsList", departmentsList);
			}catch(Exception e) {
				System.out.print("delete department failed");
			}
			return mav;
		}
}
