package com.casestudy.caseStudy.services;

import java.io.IOException;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Company;
import com.casestudy.caseStudy.repository.CompanyRepository;



@Service
public class CompanyServiceImp implements CompanyService{
	
	@Autowired
	CompanyRepository cr;
	
	@Override
	public boolean updateCompanyInformation(Company company, Integer id) {
		// update company information
		boolean status = false;
		Company companyToUpdate = cr.getOne(id);
		if(companyToUpdate != null) {
			System.out.println("company with id: " + id + " found");
			if( company.getName() != null)  companyToUpdate.setName( company.getName());
			if( company.getContact() != null)  companyToUpdate.setContact( company.getContact());
			if( company.getPhone() != null)  companyToUpdate.setPhone( company.getPhone());
			if( company.getEmail() != null)  companyToUpdate.setEmail(company.getEmail());
			if( company.getMobile() != null)  companyToUpdate.setMobile(company.getMobile());
			if( company.getFax() != null)  companyToUpdate.setFax(company.getFax());
			if( company.getAddress() != null)  companyToUpdate.setAddress(company.getAddress());
			if( company.getCity() != null)  companyToUpdate.setCity(company.getCity());
			if( company.getState()!= null)  companyToUpdate.setState(company.getState());
			if( company.getCountry() != null)  companyToUpdate.setCountry(company.getCountry());
			if( company.getZip() != null)  companyToUpdate.setZip(company.getZip());
			if( company.getEmail() != null)  companyToUpdate.setEmail(company.getEmail());
			if( company.getWebsite() != null)  companyToUpdate.setWebsite(company.getWebsite());
			companyToUpdate.setId(company.getId());
			cr.save(companyToUpdate );
			status = true;
		}else {
			System.out.println("department with id: " + id + " not found");
			status = false;
		}
		return status;
	}

	@Override
	public Company getCompany(){
		boolean status = cr.findAll().isEmpty();
		Company company = null;
		if(!status) {
			return  company = cr.findAll().get(0);
		}else {
			company = new Company();
			cr.save(company);
			return company;
		}
		
	}

}
