package com.casestudy.caseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Employee;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.EmployeeServiceImp;

@SpringBootTest
class testEmployeeServiceImp {
	
	@Autowired
	EmployeeServiceImp es;
	
	List<Employee> empList;
	
	
//	@Test
//	void testAddNewEmployee() {
//		Address testAdd = new Address("giles","apt02","jersey","nj",12345);
//
//		User testUser = new User("userTest","test@gmail.com","test-2021",true,"USER");
//		//
//		Long phone = new Long(99999999);
//		Employee e1 = new Employee("testFn","testLn","security","02/02/1999","femele",phone,"doctor1.PNG",
//				"C:\\Users\\15512\\dev\\casestudy-final-1.0.0\\case_study-main\\caseStudy\\uploads\\doctor1.PNG",
//				"image/png","417272",testAdd,testUser);
//		Assertions.assertTrue(es.addNewEmployee(e1));
//	}

	@Test
	void testGetAllEmployees() {
		empList = es.getAllEmployees();
		Assertions.assertFalse(empList.isEmpty());
	}

	@Test
	void testGetEmployeeById() {
		Assertions.assertTrue(es.getEmployeeById(5) != null);
	}

//	@Test
//	void testUpdateEmployeeById() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testDeleteEmployeeById() {
//		Assertions.assertTrue(es.deleteEmployeeById(4));
//	}

	@Test
	void testGetEmployeeByAccountUserName() {
		Assertions.assertTrue(es.getEmployeeByAccountUserName("sofiane") != null);
	}

}
