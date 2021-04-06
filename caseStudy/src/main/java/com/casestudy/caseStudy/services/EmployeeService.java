package com.casestudy.caseStudy.services;

import java.util.List;

import com.casestudy.caseStudy.entityModels.Employee;



public interface EmployeeService {
	public boolean addNewEmployee(Employee employee);
	//get all Employees from the data base
	public List<Employee> getAllEmployees();
	//get specific Employee using id
	public Employee getEmployeeById(Integer id);
	//get specific doctor using the Employee last name
	public List<Employee> getEmployeeByAccountUserName(String username);
	//update doctor information
	public boolean updateEmployeeById(Integer id, Employee employee);
	//delete Employee from the database 
	public boolean deleteEmployeeById(Integer id);
}
