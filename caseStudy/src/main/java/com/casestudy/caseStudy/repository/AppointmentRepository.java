package com.casestudy.caseStudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.casestudy.caseStudy.entityModels.Appointment;

public interface AppointmentRepository extends JpaRepository <Appointment, Integer>{
	public List<Appointment> findByDoctorDocId(Integer id);
	public Appointment findByUserName(String username);
	//find list of appointment related to specific department
	public List<Appointment> findByDepName(String depName);
	//find the count of appointments grouped by the same date
			@Query("SELECT new map(count(a) as an, a.date as d) FROM Appointment a GROUP BY a.date ORDER BY a.date DESC")
			public List<?> findAppointmentCount();
	
}
