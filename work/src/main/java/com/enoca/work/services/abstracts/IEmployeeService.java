package com.enoca.work.services.abstracts;

import java.util.List;

import com.enoca.work.dtos.EmployeeDto;

public interface IEmployeeService {
	List<EmployeeDto> getAllEmployees();
	EmployeeDto getEmployeeById(int employeeId);
	EmployeeDto addEmployee(EmployeeDto employeeDto, int companyId);
	EmployeeDto updateEmployee(EmployeeDto employeeDto, int employeeId);
	void removeEmployee(int employeeId);
}
