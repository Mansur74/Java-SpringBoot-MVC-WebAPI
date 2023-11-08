package com.enoca.work.services.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.work.dtos.CompanyDto;
import com.enoca.work.exceptions.CompanyNotFoundException;
import com.enoca.work.mappers.CompanyMapper;
import com.enoca.work.models.Company;
import com.enoca.work.repositories.CompanyRepository;
import com.enoca.work.services.abstracts.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	CompanyRepository companyRepository;
	
	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		return this.companyRepository.findAll().stream().map(c -> CompanyMapper.mapToCompanyDto(c)).collect(Collectors.toList());
	}

	@Override
	public CompanyDto getCompanyById(int companyId) {
		Company company = this.companyRepository.findById(companyId)
				.orElseThrow(() -> new CompanyNotFoundException("Company does not exists"));
		return CompanyMapper.mapToCompanyDto(company);
	}

	@Override
	public CompanyDto addCompany(CompanyDto companyDto) {
		Company company = CompanyMapper.mapToCompany(companyDto);
		Company savedCompany = this.companyRepository.save(company);
		return CompanyMapper.mapToCompanyDto(savedCompany);
	}
	
	@Override
	public CompanyDto updateCompany(CompanyDto companyDto, int companyId) {
		Company company = this.companyRepository.findById(companyId)
				.orElseThrow(() -> new CompanyNotFoundException("Company does not exists"));
		company.setName(companyDto.getName());
		company.setDescription(companyDto.getDescription());
		company.setImgUrl(companyDto.getImgUrl());
		company.setLocation(companyDto.getLocation());
		Company updatedCompany = this.companyRepository.save(company);
		return CompanyMapper.mapToCompanyDto(updatedCompany);
	}

	@Override
	public void removeCompany(int companyId) {
		Company company = this.companyRepository.findById(companyId)
				.orElseThrow(() -> new CompanyNotFoundException("Company does not exists"));
		this.companyRepository.delete(company);
	
	}


}
