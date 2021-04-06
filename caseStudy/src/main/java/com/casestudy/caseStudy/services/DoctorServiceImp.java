package com.casestudy.caseStudy.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService{
	
	@Autowired
	DoctorRepository dr;
	
	@Override
	public boolean addNewDoctor(Doctor doctor) {
		// insert new doctor to the database 
		boolean status = false;
		try {
			dr.save(doctor);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}
	
//	public Doctor addNewDoctor2(Doctor doctor) throws IOException{
//		return dr.save(doctor);
//	}
//	
	@Override
	public List<Doctor> getAllDoctors() {
		// fetch list of doctors from the database
		List<Doctor> docList = new ArrayList<Doctor>();
		try {
			docList = dr.findAll();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return docList;
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		// find doctor using id value
		Doctor foundDoctor = dr.getOne(id);
		if(foundDoctor != null) {
			return foundDoctor;
		}else {
			System.out.println("Doctor with id:"+ id + " does not exist in the database" );
			return null;
		}
		
		
	}

	
//	public List<Doctor> getDoctorByLastName(String lastName) {
//		// find doctor using last value
//		List<Doctor> foundDoctor = dr.getDoctorByName(lastName);
//		if(foundDoctor != null) {
//			return foundDoctor;
//		}else {
//			System.out.println("Doctor with id:"+ lastName + " does not exist in the database" );
//			return null;
//		}
//		
//	}

	@Override
	public boolean updateDoctorById(Integer id, Doctor doctor) {
		// update doctor information 
		boolean status;
		try {
			Doctor updatedDoctor = dr.getOne(id);
			if(doctor.getFirstName() != null) updatedDoctor.setFileName(doctor.getFirstName());
			if(doctor.getLastName() != null) updatedDoctor.setLastName(doctor.getLastName());
			if(doctor.getSpeciality() != null) updatedDoctor.setSpeciality(doctor.getSpeciality());
			if(doctor.getPhone() != null) updatedDoctor.setPhone(doctor.getPhone());
			if(doctor.getGender() != null) updatedDoctor.setGender(doctor.getGender());
			if(doctor.getAccount() != null) updatedDoctor.setAccount(doctor.getAccount());
			if(doctor.getAddress() != null) updatedDoctor.setAddress(doctor.getAddress());
			dr.save(updatedDoctor);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}

	@Override
	public boolean deleteDoctorById(Integer id) {
		// remove doctor using id value
		boolean status = false;
		try {
			dr.deleteById(id);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}

	@Override
	public List<Doctor> getDoctorByUserName(String username) {
		return dr.findDoctorByAccountUserName(username);
	}

}
