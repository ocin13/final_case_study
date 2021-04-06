package com.casestudy.caseStudy.entityModels;

import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


public class Statistics {
	
	
	Integer id;
	
	Integer NumberOfDoctors;
	
	Integer NumberOfPatients;
	
	Long NumberOfReservedAppointments;
	
	Long NumberOfAvailableAppointments;
	
	List<Doctor> doctorsList;
	
	List<Appointment> reservedAppointmentsList;
	
	List<Patient> patientsList;
	
	HashMap<String, Integer> numberOfPatientsPerDepartment;
	
	List<?> numberOfPatientsPerDay;
	
	Integer numberOfCardioPatients;
	
	Integer numberOfChildrensPatients;
	
	Integer numberOfDisabledPatients;
	public Statistics() {
		super();
	}
	public Statistics(@NotNull Integer id, Integer numberOfDoctors, Integer numberOfPatients,
			Long numberOfReservedAppointments, Long numberOfAvailableAppointments, List<Doctor> doctorsList,
			List<Appointment> reservedAppointmentsList, List<Patient> patientsList, Integer numberOfCardioPatients,
			Integer numberOfChildrensPatients, Integer numberOfDisabledPatients) {
		super();
		this.id = id;
		NumberOfDoctors = numberOfDoctors;
		NumberOfPatients = numberOfPatients;
		NumberOfReservedAppointments = numberOfReservedAppointments;
		NumberOfAvailableAppointments = numberOfAvailableAppointments;
		this.doctorsList = doctorsList;
		this.reservedAppointmentsList = reservedAppointmentsList;
		this.patientsList = patientsList;
		this.numberOfCardioPatients = numberOfCardioPatients;
		this.numberOfChildrensPatients = numberOfChildrensPatients;
		this.numberOfDisabledPatients = numberOfDisabledPatients;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumberOfDoctors() {
		return NumberOfDoctors;
	}
	public void setNumberOfDoctors(Integer numberOfDoctors) {
		NumberOfDoctors = numberOfDoctors;
	}
	public Integer getNumberOfPatients() {
		return NumberOfPatients;
	}
	public void setNumberOfPatients(Integer numberOfPatients) {
		NumberOfPatients = numberOfPatients;
	}
	public Long getNumberOfReservedAppointments() {
		return NumberOfReservedAppointments;
	}
	public void setNumberOfReservedAppointments(Long numberOfReservedAppointments) {
		NumberOfReservedAppointments = numberOfReservedAppointments;
	}
	public Long getNumberOfAvailableAppointments() {
		return NumberOfAvailableAppointments;
	}
	public void setNumberOfAvailableAppointments(Long numberOfAvailableAppointments) {
		NumberOfAvailableAppointments = numberOfAvailableAppointments;
	}
	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}
	public void setDoctorsList(List<Doctor> doctorsList) {
		this.doctorsList = doctorsList;
	}
	public List<Appointment> getReservedAppointmentsList() {
		return reservedAppointmentsList;
	}
	public void setReservedAppointmentsList(List<Appointment> reservedAppointmentsList) {
		this.reservedAppointmentsList = reservedAppointmentsList;
	}
	public List<Patient> getPatientsList() {
		return patientsList;
	}
	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}
	public Integer getNumberOfCardioPatients() {
		return numberOfCardioPatients;
	}
	public void setNumberOfCardioPatients(Integer numberOfCardioPatients) {
		this.numberOfCardioPatients = numberOfCardioPatients;
	}
	public Integer getNumberOfChildrensPatients() {
		return numberOfChildrensPatients;
	}
	public void setNumberOfChildrensPatients(Integer numberOfChildrensPatients) {
		this.numberOfChildrensPatients = numberOfChildrensPatients;
	}
	public Integer getNumberOfDisabledPatients() {
		return numberOfDisabledPatients;
	}
	public void setNumberOfDisabledPatients(Integer numberOfDisabledPatients) {
		this.numberOfDisabledPatients = numberOfDisabledPatients;
	}
	
	
	public HashMap<String, Integer> getNumberOfPatientsPerDepartment() {
		return numberOfPatientsPerDepartment;
	}
	public void setNumberOfPatientsPerDepartment(HashMap<String, Integer> numberOfPatientsPerDepartment) {
		this.numberOfPatientsPerDepartment = numberOfPatientsPerDepartment;
	}
	
	
	public List<?> getNumberOfPatientsPerDay() {
		return numberOfPatientsPerDay;
	}
	public void setNumberOfPatientsPerDay(List<?> numberOfPatientsPerDay) {
		this.numberOfPatientsPerDay = numberOfPatientsPerDay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((NumberOfAvailableAppointments == null) ? 0 : NumberOfAvailableAppointments.hashCode());
		result = prime * result + ((NumberOfDoctors == null) ? 0 : NumberOfDoctors.hashCode());
		result = prime * result + ((NumberOfPatients == null) ? 0 : NumberOfPatients.hashCode());
		result = prime * result
				+ ((NumberOfReservedAppointments == null) ? 0 : NumberOfReservedAppointments.hashCode());
		result = prime * result + ((doctorsList == null) ? 0 : doctorsList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfCardioPatients == null) ? 0 : numberOfCardioPatients.hashCode());
		result = prime * result + ((numberOfChildrensPatients == null) ? 0 : numberOfChildrensPatients.hashCode());
		result = prime * result + ((numberOfDisabledPatients == null) ? 0 : numberOfDisabledPatients.hashCode());
		result = prime * result + ((patientsList == null) ? 0 : patientsList.hashCode());
		result = prime * result + ((reservedAppointmentsList == null) ? 0 : reservedAppointmentsList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistics other = (Statistics) obj;
		if (NumberOfAvailableAppointments == null) {
			if (other.NumberOfAvailableAppointments != null)
				return false;
		} else if (!NumberOfAvailableAppointments.equals(other.NumberOfAvailableAppointments))
			return false;
		if (NumberOfDoctors == null) {
			if (other.NumberOfDoctors != null)
				return false;
		} else if (!NumberOfDoctors.equals(other.NumberOfDoctors))
			return false;
		if (NumberOfPatients == null) {
			if (other.NumberOfPatients != null)
				return false;
		} else if (!NumberOfPatients.equals(other.NumberOfPatients))
			return false;
		if (NumberOfReservedAppointments == null) {
			if (other.NumberOfReservedAppointments != null)
				return false;
		} else if (!NumberOfReservedAppointments.equals(other.NumberOfReservedAppointments))
			return false;
		if (doctorsList == null) {
			if (other.doctorsList != null)
				return false;
		} else if (!doctorsList.equals(other.doctorsList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfCardioPatients == null) {
			if (other.numberOfCardioPatients != null)
				return false;
		} else if (!numberOfCardioPatients.equals(other.numberOfCardioPatients))
			return false;
		if (numberOfChildrensPatients == null) {
			if (other.numberOfChildrensPatients != null)
				return false;
		} else if (!numberOfChildrensPatients.equals(other.numberOfChildrensPatients))
			return false;
		if (numberOfDisabledPatients == null) {
			if (other.numberOfDisabledPatients != null)
				return false;
		} else if (!numberOfDisabledPatients.equals(other.numberOfDisabledPatients))
			return false;
		if (patientsList == null) {
			if (other.patientsList != null)
				return false;
		} else if (!patientsList.equals(other.patientsList))
			return false;
		if (reservedAppointmentsList == null) {
			if (other.reservedAppointmentsList != null)
				return false;
		} else if (!reservedAppointmentsList.equals(other.reservedAppointmentsList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Statistics [id=" + id + ", NumberOfDoctors=" + NumberOfDoctors + ", NumberOfPatients="
				+ NumberOfPatients + ", NumberOfReservedAppointments=" + NumberOfReservedAppointments
				+ ", NumberOfAvailableAppointments=" + NumberOfAvailableAppointments + ", doctorsList=" + doctorsList
				+ ", reservedAppointmentsList=" + reservedAppointmentsList + ", patientsList=" + patientsList
				+ ", numberOfCardioPatients=" + numberOfCardioPatients + ", numberOfChildrensPatients="
				+ numberOfChildrensPatients + ", numberOfDisabledPatients=" + numberOfDisabledPatients + "]";
	}
	
}
