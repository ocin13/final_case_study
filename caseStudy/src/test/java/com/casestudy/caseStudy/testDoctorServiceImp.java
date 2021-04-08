package com.casestudy.caseStudy;







import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Doctor;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.DoctorServiceImp;


@SpringBootTest
class testDoctorServiceImp {
	
	@Autowired
	DoctorServiceImp ds;
	static List<Doctor> docList = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("you are connected successfully!!!");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("all test have been executed...");
		
	}
	//create a copy of a database and store it in ArrayLists for testing purposes
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("test executed here");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("test has been executed...");
	}

	@Test
	void testAddNewDoctor() {
		Address testAdd = new Address("giles","apt02","jersey","nj",12345);

		User testUser = new User("userTest","test@gmail.com","test-2021",true,"USER");
		//
		Long phone = new Long(99999999);
		Doctor d1 = new Doctor("testFn","testLn","cardiology","02/02/1999","femele",phone,"doctor1.PNG",
				"C:\\Users\\15512\\dev\\casestudy-final-1.0.0\\case_study-main\\caseStudy\\uploads\\doctor1.PNG",
				"image/png","417272",testAdd,testUser);
		Assertions.assertTrue(ds.addNewDoctor(d1));
	}

	@Test
	void testGetAllDoctors() {
		docList = ds.getAllDoctors();
		Assertions.assertFalse(docList.isEmpty());
	}
//
	@ParameterizedTest
	@ValueSource(ints = {1})
	void testGetDoctorById(Integer input) {
		
		Assertions.assertTrue(ds.getDoctorById(input) != null);
	}
//

//
	@ParameterizedTest
	@ValueSource(ints = {4})
	void testDeleteDoctorById(Integer input) {
		Assertions.assertTrue(ds.deleteDoctorById(input));
	}
//
	@ParameterizedTest
	@ValueSource(strings = {"turkia"})
	void testGetDoctorByUserName(String input) {
		Assertions.assertTrue(ds.getDoctorByUserName(input) != null);
	}

}
