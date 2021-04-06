package com.casestudy.caseStudy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.casestudy.caseStudy.entityModels.Employee;

import com.casestudy.caseStudy.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository er;
	
	@Override
	public boolean addNewEmployee(Employee employee) {
		// insert new Employee to the database 
				boolean status = false;
				try {
					er.save(employee);
					status = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					status = false;
				}
				return status;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// fetch list of doctors from the database
				List<Employee> empList = new ArrayList<Employee>();
				try {
					empList = er.findAll();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				return empList;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// get patient using id value
				Employee foundEmployee = er.getOne(id);
				if(foundEmployee != null) {
					System.out.println("Employee with id: " + id + " found");
				}else {
					System.out.println("Employee with id: " + id + " not found");
				}
				
				return foundEmployee;
	}

	@Override
	public boolean updateEmployeeById(Integer id, Employee employee) {
		// update Employee using id value
				boolean status = false;
				Employee employeeToUpdate = er.getOne(id);
				if(employeeToUpdate != null) {
					System.out.println("employee with id: " + id + " found");
					if(employee.getFirstName() != null) employeeToUpdate.setFirstName(employee.getFirstName());
					if(employee.getLastName() != null) employeeToUpdate.setLastName(employee.getLastName());
					if(employee.getOccupation() != null) employeeToUpdate.setOccupation(employee.getOccupation());
					if(employee.getDateOfBirth() != null) employeeToUpdate.setDateOfBirth(employee.getDateOfBirth());
					if(employee.getGender() != null) employeeToUpdate.setGender(employee.getGender());
					if(employee.getPhone() != null) employeeToUpdate.setPhone(employee.getPhone());
					if(employee.getAccount() != null) employeeToUpdate.setAccount(employee.getAccount());
					if(employee.getAddress() != null) employeeToUpdate.setAddress(employee.getAddress());
					er.save(employeeToUpdate);
					status = true;
				}else {
					System.out.println("patient with id: " + id + " not found");
					status = false;
				}
				return status;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) {
		//delete employee using id value
				boolean status = false;
				try {
					er.deleteById(id);
					status = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					status = false;
				}finally {
					return status;
				}
	}

	@Override
	public List<Employee> getEmployeeByAccountUserName(String username) {
		return er.findEmployeeByAccountUserName(username);
	}

}
