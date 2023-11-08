package com.enoca.work.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enoca.work.dtos.EmployeeDto;
import com.enoca.work.services.concretes.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web")
public class EmployeeController {

	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public String listEmplooyes(Model model)
	{
		List<EmployeeDto> employees = this.employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
	
	@GetMapping("/employee/{employeeId}")
	public String getEmployee(Model model, @PathVariable("employeeId") int employeeId)
	{
		EmployeeDto employee = this.employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return "employee-detail";
	}
	
	@GetMapping("/employee/{companyId}/new")
	public String createEmployee(Model model, @PathVariable int companyId)
	{
		EmployeeDto employeeDto = new EmployeeDto();
		model.addAttribute("employee", employeeDto);
		model.addAttribute("companyId", companyId);
		return "employee-create";
	}
	
	@PostMapping("/employee/{companyId}/new")
	public String createEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result, @PathVariable int companyId)
	{
		if(result.hasErrors())
		{
			return "employee-create";
		}

		this.employeeService.addEmployee(employeeDto, companyId);
		return "redirect:/web/employee";
	}
	
	@GetMapping("/employee/{employeeId}/update")
	public String updateEmployee(Model model, @PathVariable int employeeId)
	{
		EmployeeDto employeeDto = this.employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employeeDto);
		return "employee-update";
	}
	
	@PostMapping("/employee/{employeeId}/update")
	public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result, @PathVariable int employeeId)
	{

		if(result.hasErrors())
		{
			return "employee-update";
		}
		this.employeeService.updateEmployee(employeeDto, employeeId);
		return "redirect:/web/employee";
	}
	
	@GetMapping("/employee/{employeeId}/remove")
	public String removeEmplooyes(@PathVariable("employeeId") int employeeId)
	{
		this.employeeService.removeEmployee(employeeId);
		return "redirect:/web/employee";
	}
	

}
