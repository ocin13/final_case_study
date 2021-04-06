package com.casestudy.caseStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.caseStudy.entityModels.Department;

public interface DepartmentRepository extends JpaRepository <Department, Integer>{

}
