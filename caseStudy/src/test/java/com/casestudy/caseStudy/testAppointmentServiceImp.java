package com.casestudy.caseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.services.AppointmentServiceImp;
import com.casestudy.caseStudy.services.DoctorServiceImp;

@SpringBootTest
class testAppointmentServiceImp {
	
	@Autowired
	AppointmentServiceImp as;
	
	@Autowired
	DoctorServiceImp ds;
	
	List<Appointment> aList;
	
	
	
	@Test
	void testAddNewAppointment() {
		Appointment atest = new Appointment("djamal", ds.getDoctorById(1), "cardiology", "hoc1ne13dec@gmail.com",
				"10:23", "10/03/2021", false);
		Assertions.assertTrue(as.addNewAppointment(atest));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void testAddNewAppointmentFail(String input) {
		Appointment atest = new Appointment("djamal", ds.getDoctorById(1), input, "hoc1ne13dec@gmail.com",
				"10:23", "10/03/2021", false);
		Assertions.assertFalse(as.addNewAppointment(atest));
	}

	@Test
	void testGetAllAppointments() {
		aList = as.getAllAppointments();
		Assertions.assertFalse(aList.isEmpty());
	}

	@Test
	void testGetAppointmentById() {
		Assertions.assertTrue(as.getAppointmentById(1) != null);
	}



	@Test
	void testDeleteAppointmentById() {
		Assertions.assertTrue(as.deleteAppointmentById(4));
	}

	@Test
	void testGetAppByDoctorId() {
		Assertions.assertTrue(as.getAppByDoctorId(1) != null);
	}

	@Test
	void testGetByUserName() {
		
		Assertions.assertTrue(as.getByUserName("djamal") != null);
	}

	@Test
	void testConfirmAppointment() {
		Assertions.assertTrue(as.confirmAppointment(3, "username", "user@gmail.com") != null);
	}

	@Test
	void testGetAppByDepName() {
		aList = as.getAppByDepName("pediatrics");
		Assertions.assertFalse(aList.isEmpty());
	}

	

}
