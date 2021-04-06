package com.casestudy.caseStudy.services;

import java.util.List;

import com.casestudy.caseStudy.entityModels.Patient;



public interface PatientService {
	//insert new patient to the database
		public boolean addNewPatient(Patient patient);
		//get all patients from the data base
		public List<Patient> getAllPatients();
		//get specific patient using id
		public Patient getPatientById(Integer id);
		//get specific patient using the patient last name
		public List<Patient> getPatientByUserName(String username);
		//update patient information
		public boolean updatePatientById(Integer id, Patient patient);
		//delete patient from the database 
		public boolean deletePatientById(Integer id);
}
