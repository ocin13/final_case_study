package com.casestudy.caseStudy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({testUserServiceImp.class,testAppointmentServiceImp.class,
	testDoctorServiceImp.class,testservicesPatientServiceImp.class,testEmployeeServiceImp.class,
	testAppointmentServiceImp.class,testDepartmentServiceImp.class})
public class AllTests {

}
