package com.casestudy.caseStudy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Department;
import com.casestudy.caseStudy.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService{
	
	@Autowired
	AddressRepository ar;
	
	@Override
	public boolean addNewAddress(Address address) {
		// insert new address to the data base 
		// insert new Department to the database
				boolean status = false;
				try {
					ar.save(address);
					status = true;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					status = false;
				}
				return status;
	}

	@Override
	public List<Address> getAllAddress() {
		// fetch list of addresses from the database 
				List<Address> addressesList = new ArrayList<Address>();
				try {
					addressesList = ar.findAll();
				}catch(Exception e) {
					System.out.println(e.getMessage());
					addressesList  = null;
				}
				return addressesList;
	}

	@Override
	public Address getAddressById(Integer id) {
		// get address using id value
				Address foundAddress = ar.getOne(id);
				if(foundAddress != null) {
					System.out.println("address with id: " + id + " found");
				}else {
					System.out.println("address with id: " + id + " not found");
				}
				
				return foundAddress;
	}

	@Override
	public boolean updateAddressById(Integer id, Address address) {
		// update address using id value
				boolean status = false;
				Address addressToUpdate =ar.getOne(id);
				if(addressToUpdate != null) {
					System.out.println("department with id: " + id + " found");
					if(address.getApt() != null) addressToUpdate.setApt(address.getApt());
					if(addressToUpdate.getCity() != null) addressToUpdate.setCity(address.getCity());
					if(addressToUpdate.getState() != null) addressToUpdate.setState(address.getState());
					if(addressToUpdate.getStreet() != null) addressToUpdate.setStreet(address.getStreet());
					if(addressToUpdate.getZip() != null) addressToUpdate.setZip(address.getZip());
					ar.save(addressToUpdate);
					status = true;
				}else {
					System.out.println("department with id: " + id + " not found");
					status = false;
				}
				return status;
	}

	@Override
	public boolean deleteDAddressById(Integer id) {
		//delete address using id value
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

}
