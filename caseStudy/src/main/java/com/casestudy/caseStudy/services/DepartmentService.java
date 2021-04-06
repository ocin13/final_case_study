package com.casestudy.caseStudy.services;

import java.util.List;

import com.casestudy.caseStudy.entityModels.Department;



public interface DepartmentService {
	
	public boolean addNewDepartment(Department department);
	//get all Departments from the data base
	public List<Department> getAllDepartments();
	//get specific Department using id
	public Department getDepartmentById(Integer id);

	//update Department information
	public boolean updateDepartmentById(Integer id, Department department);
	//delete Department from the database 
	public boolean deleteDepartmentById(Integer id);
}
