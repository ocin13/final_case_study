package com.casestudy.caseStudy.entityModels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dep_id")
	Integer depId;
	
	@NotBlank
	@Size(min=5,max=30,message="name must not be longer than 30 or shorter than 5")
	@Column(name="dep_name")
	String name;
	
	@NotBlank
	@Size(min=10,max=80,message="description must not be longer than 80 or shorter than 10")
	@Column(name="dep_description")
	String description;
	
	@OneToMany
	@JoinTable
	List<Patient> patientList;
	public Department() {
		super();
	}
	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Department(Integer depId, String name, String description, List<Patient> patietList) {
		super();
		this.depId = depId;
		this.name = name;
		this.description = description;
		this.patientList = patietList;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Patient> getPatietList() {
		return patientList;
	}
	public void setPatietList(List<Patient> patietList) {
		this.patientList = patietList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depId == null) ? 0 : depId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patientList == null) ? 0 : patientList.hashCode());
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
		Department other = (Department) obj;
		if (depId == null) {
			if (other.depId != null)
				return false;
		} else if (!depId.equals(other.depId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patientList == null) {
			if (other.patientList != null)
				return false;
		} else if (!patientList.equals(other.patientList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", name=" + name + ", description=" + description + ", patietList="
				+ patientList + "]";
	}
	
	
	
	

}
