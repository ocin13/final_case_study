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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name="doctors")
public class Doctor {
	
	//here all the doctor properties that will be saved in the database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DOC_ID")
	private Integer docId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Size(min=2, max=30,message="last name must not be longer than 30 or shorter than 2")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="speciality  must not be null")
	@Size(min=2, max=30,message="speciality  must not be longer than 30 or shorter than 2")
	@Column(name="Speciality")
	private String speciality;
	
	@NotBlank(message="date of birth must not be null")
	@Size(min=2, max=30,message="date of birth name must not be longer than 30 or shorter than 2")
	@Column(name = "birthdate")
	private String dateOfBirth;
	
	@NotBlank(message="gender must not be null")
	@Size(min=2, max=30,message="gender must not be longer than 30 or shorter than 2")
	@Column(name="gender")
	private String gender;
	
	@NotNull(message="phone cat not be null")
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
	@JoinTable(name="doctor_address")
	private Address address;
	
	@OneToOne(targetEntity = User.class ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="doctor_account")
	private User account;
	
	//default constructor was generated
	public Doctor() {
		super();
	}
	
	public Doctor( String firstName, String lastName, String speciality, String dateOfBirth,
			String gender, Long phone, String fileName, String filePath, String fileType, String fileSize,
			Address address, User account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
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

	public Doctor(Integer docId, String firstName, String lastName, String speciality, String dateOfBirth,
			String gender, Long phone, String fileName, String filePath, String fileType, String fileSize,
			Address address, User account) {
		super();
		this.docId = docId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
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

	public Integer getDocId() {
		return docId;
	}

	

	public void setDocId(Integer docId) {
		this.docId = docId;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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
		result = prime * result + ((docId == null) ? 0 : docId.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
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
		Doctor other = (Doctor) obj;
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
		if (docId == null) {
			if (other.docId != null)
				return false;
		} else if (!docId.equals(other.docId))
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality="
				+ speciality + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", fileType=" + fileType + ", fileSize="
				+ fileSize + ", address=" + address + ", account=" + account + "]";
	}
	
	

	
	
}
