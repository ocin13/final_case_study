package com.casestudy.caseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.PatientServiceImp;

@SpringBootTest
class testservicesPatientServiceImp {
	
	@Autowired
	PatientServiceImp ps;
	
	static List<Patient> pList = null;
	
	@Test
	void testAddNewPatient() {
		Address testAdd = new Address("giles","apt02","jersey","nj",12345);

		User testUser = new User("userTest","test@gmail.com","test-2021",true,"USER");
		//
		Long phone = new Long(99999999);
		Patient p1 = new Patient("testFn","testLn","02/02/1999","femele",phone,"doctor1.PNG",
				"C:\\Users\\15512\\dev\\casestudy-final-1.0.0\\case_study-main\\caseStudy\\uploads\\doctor1.PNG",
				"image/png","417272",testAdd,testUser);
		Assertions.assertTrue(ps.addNewPatient(p1));
	}

	@Test
	void testGetAllPatients() {
		pList = ps.getAllPatients();
		Assertions.assertFalse(pList.isEmpty());
	}

	@Test
	void testGetPatientById() {
		Assertions.assertTrue(ps.getPatientById(1) != null);
	}

//
	@ParameterizedTest
	@ValueSource(ints = {2})
	void testDeletePatientById(Integer input) {
		Assertions.assertTrue(ps.deletePatientById(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"djamal"})
	void testGetPatientByUserName(String input) {
		Assertions.assertTrue(ps.getPatientByUserName(input) != null);
	}

}
