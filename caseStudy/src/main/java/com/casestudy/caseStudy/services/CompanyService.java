package com.casestudy.caseStudy.services;

import java.io.IOException;
import java.util.UUID;

import com.casestudy.caseStudy.entityModels.Company;

public interface CompanyService {
	public boolean updateCompanyInformation(Company company, Integer id);
	public Company getCompany();
}
