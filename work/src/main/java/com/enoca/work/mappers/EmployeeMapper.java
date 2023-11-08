package com.enoca.work.mappers;

import com.enoca.work.dtos.EmployeeDto;
import com.enoca.work.models.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee)
	{
		return EmployeeDto.builder()
				.id(employee.getId())
				.firstname(employee.getFirstname())
				.lastname(employee.getLastname())
				.summary(employee.getSummary())
				.age(employee.getAge())
				.gender(employee.getGender())
				.salary(employee.getSalary())
				.imgUrl(employee.getImgUrl())
				.createdAt(employee.getCreatedAt())
				.updatedAt(employee.getUpdatedAt())
				.build();
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto)
	{
		return Employee.builder()
				.id(employeeDto.getId())
				.firstname(employeeDto.getFirstname())
				.lastname(employeeDto.getLastname())
				.summary(employeeDto.getSummary())
				.age(employeeDto.getAge())
				.gender(employeeDto.getGender())
				.salary(employeeDto.getSalary())
				.imgUrl(employeeDto.getImgUrl())				
				.createdAt(employeeDto.getCreatedAt())
				.updatedAt(employeeDto.getUpdatedAt())
				.build();
	}
}
