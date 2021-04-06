package com.casestudy.caseStudy.entityModels;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Company {
	
	@Id
	@NotNull
	@Column(name="company_id", unique=true)
	Integer id;
	@Column(name="name")
	String name;
	@Column(name="contact")
	String contact;
	@Column(name="phone")
	String phone;
	@Column(name="email")
	String email;
	@Column(name="mobile")
	String mobile;
	@Column(name="fax")
	String fax;
	@Column(name="website")
	String website;
	@Column(name="address")
	String address;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="zip")
	Integer zip;
	@Column(name="country")
	String country;
	public Company() {
		super();
		this.id = 123456789;
		this.name = "demo company";
		this.contact = "demo contact";
		this.phone = "999-999-9999";
		this.email = "demo@company.com";
		this.mobile = "999-999-9999";
		this.website = "https://www.demo.com";
		this.fax = "";
		this.address = "demo street";
		this.city = "demo city";
		this.state = "DM";
		this.zip = 99999;
		this.country = "United State";
	}
	public Company(@NotNull @NotNull Integer id, String name, String contact, String phone, String email, String mobile, String fax,
			String address, String city, String state, Integer zip, String country) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.email = email;
		this.mobile = mobile;
		this.fax = fax;
		this.website = website;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public @NotNull Integer getId() {
		return id;
	}
	public void setId(@NotNull Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Company other = (Company) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", contact=" + contact + ", phone=" + phone + ", email=" + email
				+ ", mobile=" + mobile + ", fax=" + fax + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", country=" + country + "]";
	}
	
}
