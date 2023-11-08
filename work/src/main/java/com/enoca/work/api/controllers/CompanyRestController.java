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

import com.enoca.work.dtos.CompanyDto;
import com.enoca.work.services.concretes.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyRestController {
	
	CompanyService companyService;

	@Autowired
	public CompanyRestController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping("/company")
	public ResponseEntity<List<CompanyDto>> getAllCompanies(){
		List<CompanyDto> companies = this.companyService.getAllCompanies();
		return ResponseEntity.ok(companies);
	}
	
	@GetMapping("/company/{companyId}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("companyId") int companyId){
		CompanyDto company = this.companyService.getCompanyById(companyId);
		return ResponseEntity.ok(company);
	}
	
	@PostMapping("/company/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
		CompanyDto company = this.companyService.addCompany(companyDto);
		return new ResponseEntity<>(company, HttpStatus.CREATED);
	}
	
	@PutMapping("/company/{companyId}/update")
	public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable("companyId") int companyId){
		
		CompanyDto company = this.companyService.updateCompany(companyDto, companyId);
		return ResponseEntity.ok(company);
	}
	
	@DeleteMapping("/company/{companyId}/delete")
	public ResponseEntity<String> removeCompany(@PathVariable("companyId") int companyId){
		
		this.companyService.removeCompany(companyId);
		return ResponseEntity.ok("Company deleted successfuly");
	}
	
	
}
