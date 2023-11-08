package com.enoca.work.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.work.dtos.EmployeeDto;
import com.enoca.work.services.concretes.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getAllEmplooyes()
	{
		List<EmployeeDto> employees = this.employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeDto> getAllEmplooyes(@PathVariable("employeeId") int employeeId)
	{
		EmployeeDto employee = this.employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping("/employee/{companyId}/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee, @PathVariable("companyId") int companyId)
	{
		EmployeeDto savedEmployee = this.employeeService.addEmployee(employee, companyId);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{employeeId}/update")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee, @PathVariable("employeeId") int employeeId)
	{
		EmployeeDto savedEmployee = this.employeeService.updateEmployee(employee, employeeId);
		return ResponseEntity.ok(savedEmployee);
	}
	
	@DeleteMapping("/employee/{emloyeeId}/delete")
	public ResponseEntity<String> removeEmployee(@PathVariable("emloyeeId") int emloyeeId)
	{
		this.employeeService.removeEmployee(emloyeeId);
		return ResponseEntity.ok("Employee deleted successfully");
	}
	
	
}
