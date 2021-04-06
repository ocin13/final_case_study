package com.casestudy.caseStudy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Appointment;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.repository.AppointmentRepository;


@Service
public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	AppointmentRepository ar;
	
	@Override
	public boolean addNewAppointment(Appointment appointment) {
		// insert new appointment to the database
				boolean status = false;
				try {
					ar.save(appointment);
					status = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					status = false;
				}
				return status;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// fetch list of appointments from the database 
				List<Appointment> appointmentsList = new ArrayList<Appointment>();
				try {
					appointmentsList = ar.findAll();
				}catch(Exception e) {
					System.out.println(e.getMessage());
					appointmentsList  = null;
				}
				return appointmentsList ;
	}

	@Override
	public Appointment getAppointmentById(Integer id) {
		// get Appointment using id value
				Appointment foundAppointment = ar.getOne(id);
				if(foundAppointment != null) {
					System.out.println("Appointment with id: " + id + " found");
				}else {
					System.out.println("Appointment with id: " + id + " not found");
				}
				
				return foundAppointment;
	}

	@Override
	public boolean updateAppointmentById(Integer id, Appointment appointment) {
		// update appointment using id value
				boolean status = false;
				Appointment appointmentToUpdate = ar.getOne(id);
				if(appointmentToUpdate!= null) {
					System.out.println("appointment with id: " + id + " found");
					if(appointment.getUserName() != null) appointmentToUpdate.setUserName(appointment.getUserName());
					if(appointment.getDoctor() != null) appointmentToUpdate.setDoctor(appointment.getDoctor());
					if(appointment.getDepName() != null) appointmentToUpdate.setDepName(appointment.getDepName());
					if(appointment.getDate()!= null) appointmentToUpdate.setDate(appointment.getDate());
					if(appointment.getTime() != null) appointmentToUpdate.setTime(appointment.getTime());
					ar.save(appointmentToUpdate);
					status = true;
				}else {
					System.out.println("patient with id: " + id + " not found");
					status = false;
				}
				return status;
	}

	@Override
	public boolean deleteAppointmentById(Integer id) {
		//delete appointment using id value
				boolean status = false;
				try {
					ar.deleteById(id);
					status = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					status = false;
				}finally {
					return status;
				}
	}

	@Override
	public List<Appointment> getAppByDoctorId(Integer id) {
		return ar.findByDoctorDocId(id);
	}

	@Override
	public Appointment getByUserName(String username) {
		return ar.findByUserName(username);
	}

	@Override
	public Appointment confirmAppointment(Integer id,String username, String email) {
		Appointment appToConfirm = ar.getOne(id);
		appToConfirm.setUserName(username);
		appToConfirm .setEmail(email);
		appToConfirm.setReserved(true);
		return ar.save(appToConfirm);
		
	}

	@Override
	public List<Appointment> getAppByDepName(String depName) {
		return ar.findByDepName(depName);
	}
	
	@Override
	public List<?> getNumberOfPatientPerDay() {
		// number of appointments per day
		return ar.findAppointmentCount();
	}

}
