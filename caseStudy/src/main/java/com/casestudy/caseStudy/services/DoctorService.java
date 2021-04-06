package com.casestudy.caseStudy.services;

import java.util.List;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Doctor;

public interface DoctorService {
	//insert new doctor to the database
	public boolean addNewDoctor(Doctor doctor);
	//get all doctors from the data base
	public List<Doctor> getAllDoctors();
	//get specific doctor using id
	public Doctor getDoctorById(Integer id);
	//get specific doctor using the doctor last name
	public List<Doctor> getDoctorByUserName(String username);
	//update doctor information
	public boolean updateDoctorById(Integer id, Doctor doctor);
	//delete doctor from the database 
	public boolean deleteDoctorById(Integer id);
	
}
