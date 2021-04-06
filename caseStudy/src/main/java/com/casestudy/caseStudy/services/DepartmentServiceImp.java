package com.casestudy.caseStudy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {
	
	@Autowired
	DepartmentRepository dr;
	
	@Override
	public boolean addNewDepartment(Department department) {
		// insert new Department to the database
		boolean status = false;
		try {
			dr.save(department);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}

	@Override
	public List<Department> getAllDepartments() {
		// fetch list of Departments from the database 
		List<Department> departmentsList = new ArrayList<Department>();
		try {
			departmentsList = dr.findAll();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			departmentsList  = null;
		}
		return departmentsList;
	}

	@Override
	public Department getDepartmentById(Integer id) {
		// get Department using id value
		Department foundDepartment = dr.getOne(id);
		if(foundDepartment != null) {
			System.out.println("Department with id: " + id + " found");
		}else {
			System.out.println("Department with id: " + id + " not found");
		}
		
		return foundDepartment;
	}

	@Override
	public boolean updateDepartmentById(Integer id, Department department) {
		// update Department using id value
		boolean status = false;
		Department departmentToUpdate = dr.getOne(id);
		if(departmentToUpdate != null) {
			System.out.println("department with id: " + id + " found");
			if(department.getName() != null) departmentToUpdate.setName(department.getName());
			if(department.getDescription() != null) departmentToUpdate.setDescription(department.getDescription());
			dr.save(departmentToUpdate );
			status = true;
		}else {
			System.out.println("department with id: " + id + " not found");
			status = false;
		}
		return status;
	}

	@Override
	public boolean deleteDepartmentById(Integer id) {
		//delete Department using id value
		boolean status = false;
		try {
			dr.deleteById(id);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}finally {
			return status;
		}
	}

}
