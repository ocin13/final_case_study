package com.casestudy.caseStudy.entityModels;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.casestudy.caseStudy.entityModels.Doctor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="apt_id")
	private Integer aptId;
	
	
	@Column(name="patient_name")
	private String userName;
	
	@ManyToOne(targetEntity = Doctor.class ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinTable(name="appointment_doctors")
	private Doctor doctor;
	
	@NotBlank
	@Column(name="depName_name")
	private String depName;
	
	
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="time")
	private String time;
	
	@NotNull
	@Column(name="date")
	private String date;
	
	@NotNull
	@Column(name="status")
	private boolean reserved;
	
	//default constructor
	public Appointment() {
		super();
		this.reserved = false;
	}
	
	public Appointment(String userName, Doctor doctor, String depName, String email, String time,
			String date, boolean reserved) {
		super();
		this.userName = userName;
		this.doctor = doctor;
		this.depName = depName;
		this.email = email;
		this.time = time;
		this.date = date;
		this.reserved = reserved;
	}

	public Appointment(Integer aptId, String userName, Doctor doctor, String depName, String email, String time,
			String date, boolean reserved) {
		super();
		this.aptId = aptId;
		this.userName = userName;
		this.doctor = doctor;
		this.depName = depName;
		this.email = email;
		this.time = time;
		this.date = date;
		this.reserved = reserved;
	}

	public Integer getAptId() {
		return aptId;
	}

	public void setAptId(Integer aptId) {
		this.aptId = aptId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aptId == null) ? 0 : aptId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((depName == null) ? 0 : depName.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (reserved ? 1231 : 1237);
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Appointment other = (Appointment) obj;
		if (aptId == null) {
			if (other.aptId != null)
				return false;
		} else if (!aptId.equals(other.aptId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (depName == null) {
			if (other.depName != null)
				return false;
		} else if (!depName.equals(other.depName))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (reserved != other.reserved)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [aptId=" + aptId + ", userName=" + userName + ", doctor=" + doctor + ", depName=" + depName
				+ ", email=" + email + ", time=" + time + ", date=" + date + ", reserved=" + reserved + "]";
	}

	

	
	
	
}
