package com.enoca.work.services.abstracts;

import java.util.List;

import com.enoca.work.dtos.CompanyDto;


public interface ICompanyService {
	List<CompanyDto> getAllCompanies();
	CompanyDto getCompanyById(int companyId);
	CompanyDto addCompany(CompanyDto companyDto);
	CompanyDto updateCompany(CompanyDto companyDto, int companyId);
	void removeCompany(int companyId);
}
