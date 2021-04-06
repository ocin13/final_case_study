package com.casestudy.caseStudy.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.Employee;

public interface DoctorRepository extends  JpaRepository<Doctor, Integer>{
	public List<Doctor> findDoctorByAccountUserName(String username);
}
