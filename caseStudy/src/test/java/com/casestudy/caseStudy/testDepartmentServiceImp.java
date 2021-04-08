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

import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.services.DepartmentServiceImp;

@SpringBootTest
class testDepartmentServiceImp {
	
	@Autowired
	DepartmentServiceImp ds;
	
	List<Department> dList;
	
	@ParameterizedTest
	@ValueSource(strings = {"physsical therapy","urology"})
	void testAddNewDepartment(String input) {
		Department dTest = new Department(input, "we try to offer teh best servcies");
		Assertions.assertTrue(ds.addNewDepartment(dTest));
	}
	@ParameterizedTest
	@NullAndEmptySource
	void testAddNewDepartmentFail(String input) {
		Department dTest = new Department(input, "we try to offer teh best servcies");
		Assertions.assertFalse(ds.addNewDepartment(dTest));
	}

	@Test
	void testGetAllDepartments() {
		dList = ds.getAllDepartments();
		Assertions.assertFalse(dList.isEmpty());
	}

	@ParameterizedTest
	@ValueSource(ints = {1})
	void testGetDepartmentById(Integer input) {
		Assertions.assertTrue(ds.getDepartmentById(input) != null);
	}



	@ParameterizedTest
	@ValueSource(ints = {6})
	void testDeleteDepartmentById(Integer input) {
		Assertions.assertTrue(ds.deleteDepartmentById(input));
	}

}
