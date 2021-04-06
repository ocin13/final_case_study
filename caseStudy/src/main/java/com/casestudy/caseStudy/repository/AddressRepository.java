package com.casestudy.caseStudy.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.caseStudy.entityModels.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
