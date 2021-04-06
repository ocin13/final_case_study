package com.casestudy.caseStudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.caseStudy.entityModels.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
	public List<Employee> findEmployeeByAccountUserName(String username);
}
