package com.casestudy.caseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.services.DepartmentServiceImp;

@SpringBootTest
class testDepartmentServiceImp {
	
	@Autowired
	DepartmentServiceImp ds;
	
	List<Department> dList;
	
	@Test
	void testAddNewDepartment() {
		Department dTest = new Department("physical therapy", "we try to offer teh best servcies");
		Assertions.assertTrue(ds.addNewDepartment(dTest));
	}

	@Test
	void testGetAllDepartments() {
		dList = ds.getAllDepartments();
		Assertions.assertFalse(dList.isEmpty());
	}

	@Test
	void testGetDepartmentById() {
		Assertions.assertTrue(ds.getDepartmentById(1) != null);
	}

//	@Test
//	void testUpdateDepartmentById() {
//		fail("Not yet implemented");
//	}

	@Test
	void testDeleteDepartmentById() {
		Assertions.assertTrue(ds.deleteDepartmentById(6));
	}

}
