package com.casestudy.caseStudy;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.casestudy.caseStudy.controller.DoctorsController;
import com.casestudy.caseStudy.controller.EmployeeController;
import com.casestudy.caseStudy.controller.PatientController;


@SpringBootApplication
public class CaseStudyApplication {

	public static void main(String[] args) {
		new File(DoctorsController.uploadDirectory).mkdir();
		new File(PatientController.uploadDirectory).mkdir();
		new File(EmployeeController.uploadDirectory).mkdir();
		SpringApplication.run(CaseStudyApplication.class, args);
	}

}
