package com.casestudy.caseStudy.services;

import java.util.List;
import java.util.UUID;

import com.casestudy.caseStudy.entityModels.Address;



public interface AddressService {
	public boolean addNewAddress(Address address);
	//get all Address from the data base
	public List<Address> getAllAddress();
	//get specific Address using id
	public Address getAddressById(Integer id);

	//update Address information
	public boolean updateAddressById(Integer id, Address address);
	//delete Address from the database 
	public boolean deleteDAddressById(Integer id);
}
