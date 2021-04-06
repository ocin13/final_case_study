package com.casestudy.caseStudy.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.caseStudy.entityModels.Company;

public interface CompanyRepository extends JpaRepository <Company, Integer>{

}
