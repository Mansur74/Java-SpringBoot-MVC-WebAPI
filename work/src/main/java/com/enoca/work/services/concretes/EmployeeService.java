package com.enoca.work.services.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.work.dtos.EmployeeDto;
import com.enoca.work.exceptions.CompanyNotFoundException;
import com.enoca.work.exceptions.EmployeeNotFoundException;
import com.enoca.work.mappers.EmployeeMapper;
import com.enoca.work.models.Company;
import com.enoca.work.models.Employee;
import com.enoca.work.repositories.CompanyRepository;
import com.enoca.work.repositories.EmployeeRepository;
import com.enoca.work.services.abstracts.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{
	
	EmployeeRepository employeeRepository;
	CompanyRepository companyRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
		this.employeeRepository = employeeRepository;
		this.companyRepository = companyRepository;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return this.employeeRepository.findAll().stream().map(e -> EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}


	@Override
	public EmployeeDto getEmployeeById(int employeeId) {
		return EmployeeMapper.mapToEmployeeDto(this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exists")));
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto, int companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new CompanyNotFoundException("Company does not exist")); 
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		employee.setCompany(company);
		Employee savedEmployee = this.employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public void removeEmployee(int employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist"));
		this.employeeRepository.delete(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, int employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist"));	
		employee.setFirstname(employeeDto.getFirstname());
		employee.setLastname(employeeDto.getLastname());
		employee.setSummary(employeeDto.getSummary());
		employee.setImgUrl(employeeDto.getImgUrl());
		employee.setAge(employeeDto.getAge());
		employee.setGender(employeeDto.getGender());
		employee.setSalary(employeeDto.getSalary());
		
		Employee updatedEmployee = this.employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
		
	}

}
