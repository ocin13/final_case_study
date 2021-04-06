package com.casestudy.caseStudy.services;

import java.util.List;

import com.casestudy.caseStudy.entityModels.Appointment;



public interface AppointmentService {
	public boolean addNewAppointment(Appointment appointment);
	//get all Appointments from the data base
	public List<Appointment> getAllAppointments();
	//get specific Appointment using id
	public Appointment getAppointmentById(Integer id);
	//get appointments assigned to specific doctor
	public List<Appointment> getAppByDoctorId(Integer id);
	//get appointments for a specific department
	public List<Appointment> getAppByDepName(String depName);
	//get appointment of a single user
	public Appointment getByUserName(String username);
	//update Appointment information
	public boolean updateAppointmentById(Integer id, Appointment appointment);
	//delete Appointment from the database 
	public boolean deleteAppointmentById(Integer id);
	//confirm appointment 
	public Appointment confirmAppointment(Integer id,String username,String email);
	//get number of Appointments from the same day
	public List<?> getNumberOfPatientPerDay();
}
