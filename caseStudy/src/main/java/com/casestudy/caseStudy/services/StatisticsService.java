package com.casestudy.caseStudy.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.Statistics;

@Service
public class StatisticsService {
	@Autowired
	AppointmentService aps;
	@Autowired
	EmployeeServiceImp es;
	@Autowired
	DoctorServiceImp ds;
	@Autowired
	PatientService ps;
	@Autowired
	AddressService as;
	@Autowired
	DepartmentService dss;
	
	
	//get the statistics data and return the statistics object
		public Statistics getStatistics() throws IOException{
			Statistics statistics = new Statistics();
			statistics.setNumberOfDoctors(ds.getAllDoctors().size());
			statistics.setNumberOfPatients(ps.getAllPatients().size());
			statistics.setNumberOfAvailableAppointments(aps.getAllAppointments().stream().filter(app -> app.isReserved() == false).count());
			statistics.setNumberOfReservedAppointments(aps.getAllAppointments().stream().filter(app -> app.isReserved() == true).count());
			statistics.setDoctorsList(ds.getAllDoctors());
			
			statistics.setPatientsList(ps.getAllPatients());
			List<Appointment> appointmentsList = new ArrayList<Appointment>();
			aps.getAllAppointments().stream().filter(app -> app.isReserved() == true).forEach(app -> appointmentsList.add(app));
			statistics.setReservedAppointmentsList(appointmentsList);
			statistics.setNumberOfCardioPatients(aps.getAppByDepName("cardiology").size());
			statistics.setNumberOfChildrensPatients(aps.getAppByDepName("pediatrics").size());
			statistics.setNumberOfDisabledPatients(aps.getAppByDepName("disability assistance").size());
			List<Department> dList = dss.getAllDepartments();
			HashMap<String,Integer> patientPerDep = new HashMap<String,Integer>();
			for(int i=0;i<dList.size();i++) {
				String dName = dList.get(i).getName();
				Integer NOfPatients = aps.getAppByDepName(dName).size();
				patientPerDep.put(dName, NOfPatients);
			}
			statistics.setNumberOfPatientsPerDepartment(patientPerDep);
			statistics.setNumberOfPatientsPerDay(aps.getNumberOfPatientPerDay());
			return statistics;
		}

}
