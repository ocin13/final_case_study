package com.casestudy.caseStudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.casestudy.caseStudy.entityModels.Patient;




public interface PatientRepository extends JpaRepository<Patient, Integer>{
	public List<Patient> findPatientByAccountUserName(String username);
}
