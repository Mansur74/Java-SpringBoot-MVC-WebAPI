package com.enoca.work.mappers;

import java.util.stream.Collectors;

import com.enoca.work.dtos.CompanyDto;
import com.enoca.work.models.Company;

public class CompanyMapper {
	public static CompanyDto mapToCompanyDto(Company company)
	{
		return CompanyDto.builder()
				.id(company.getId())
				.name(company.getName())
				.location(company.getLocation())
				.description(company.getDescription())
				.imgUrl(company.getImgUrl())
				.createdAt(company.getCreatedAt())
				.updatedAt(company.getUpdatedAt())
				.employees(company.getEmployees() == null ? null : company.getEmployees().stream().map(e -> EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList()))
				.build();
	}
	
	public static Company mapToCompany(CompanyDto companyDto)
	{
		return Company.builder()
				.id(companyDto.getId())
				.name(companyDto.getName())
				.location(companyDto.getLocation())
				.description(companyDto.getDescription())
				.imgUrl(companyDto.getImgUrl())
				.createdAt(companyDto.getCreatedAt())
				.updatedAt(companyDto.getUpdatedAt())
				.build();
	}
}
