package com.casestudy.caseStudy.entityModels;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employess")
public class Employee {
	//here all the doctor properties that will be saved in the database
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Emp_ID")
		private Integer empId;
		@Column(name="first_name")
		private String firstName;
		@Column(name="last_name")
		private String lastName;
		@Column(name="occupation")
		private String occupation;
		@Column(name = "birthdate")
		private String dateOfBirth;
		@Column(name="gender")
		private String gender;
		@Column(name="phone_number")
		private Long phone;
		@Column(name="picture_name")
		private String fileName;
		@Column(name="picture_path")
		private String filePath;
		@Column(name="picture_type")
		private String fileType;
		@Column(name="picture_size")
		private String fileSize;
		@OneToOne(targetEntity = Address.class ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
		@JoinTable(name="employee_address")
		private Address address;
		@OneToOne(targetEntity = User.class ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name="employee_account")
		private User account;
		
		//default constructor
		public Employee() {
			super();
		}
		
		public Employee(String firstName, String lastName, String occupation,String dateOfBirth, String gender, Long phone, String fileName, String filePath,
				String fileType, String fileSize, Address address, User account) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.occupation = occupation;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			this.phone = phone;
			this.fileName = fileName;
			this.filePath = filePath;
			this.fileType = fileType;
			this.fileSize = fileSize;
			this.address = address;
			this.account = account;
		}

		public Employee(Integer empId, String firstName, String lastName, String occupation,String dateOfBirth, String gender, Long phone, String fileName, String filePath,
				String fileType, String fileSize, Address address, User account) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.occupation = occupation;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			this.phone = phone;
			this.fileName = fileName;
			this.filePath = filePath;
			this.fileType = fileType;
			this.fileSize = fileSize;
			this.address = address;
			this.account = account;
		}

		public Integer getEmpId() {
			return empId;
		}

		public void setEmpId(Integer empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		

		

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Long getPhone() {
			return phone;
		}

		public void setPhone(Long phone) {
			this.phone = phone;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public String getFileSize() {
			return fileSize;
		}

		public void setFileSize(String fileSize) {
			this.fileSize = fileSize;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public User getAccount() {
			return account;
		}

		public void setAccount(User account) {
			this.account = account;
		}

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((account == null) ? 0 : account.hashCode());
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
			result = prime * result + ((empId == null) ? 0 : empId.hashCode());
			result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
			result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
			result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
			result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
			Employee other = (Employee) obj;
			if (account == null) {
				if (other.account != null)
					return false;
			} else if (!account.equals(other.account))
				return false;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (dateOfBirth == null) {
				if (other.dateOfBirth != null)
					return false;
			} else if (!dateOfBirth.equals(other.dateOfBirth))
				return false;
			if (empId == null) {
				if (other.empId != null)
					return false;
			} else if (!empId.equals(other.empId))
				return false;
			if (fileName == null) {
				if (other.fileName != null)
					return false;
			} else if (!fileName.equals(other.fileName))
				return false;
			if (filePath == null) {
				if (other.filePath != null)
					return false;
			} else if (!filePath.equals(other.filePath))
				return false;
			if (fileSize == null) {
				if (other.fileSize != null)
					return false;
			} else if (!fileSize.equals(other.fileSize))
				return false;
			if (fileType == null) {
				if (other.fileType != null)
					return false;
			} else if (!fileType.equals(other.fileType))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (gender == null) {
				if (other.gender != null)
					return false;
			} else if (!gender.equals(other.gender))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (occupation == null) {
				if (other.occupation != null)
					return false;
			} else if (!occupation.equals(other.occupation))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", occupation="
					+ occupation + ", dateOfBirth=" + dateOfBirth
					+ ", gender=" + gender + ", phone=" + phone + ", fileName=" + fileName + ", filePath=" + filePath
					+ ", fileType=" + fileType + ", fileSize=" + fileSize + ", address=" + address + ", account="
					+ account + "]";
		}
		
		
}

