package com.enoca.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.work.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
