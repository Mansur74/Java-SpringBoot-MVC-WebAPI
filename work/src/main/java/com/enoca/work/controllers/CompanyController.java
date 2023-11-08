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

import com.enoca.work.dtos.CompanyDto;
import com.enoca.work.services.concretes.CompanyService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/web")
public class CompanyController {
	
	CompanyService companyService;
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}


	@GetMapping("/company")
    public String listCompanies(Model model) {
		
		List<CompanyDto> companies = this.companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company-list";
    }
	
	@GetMapping("/company/{companyId}")
    public String getCompany(Model model, @PathVariable("companyId") int companyId) {
		
		CompanyDto company = this.companyService.getCompanyById(companyId);
        model.addAttribute("company", company);
        return "company-detail";
    }
	
	@GetMapping("/company/{companyId}/update")
	public String updateCompany(Model model, @PathVariable("companyId") int companyId){
		
		CompanyDto company = this.companyService.getCompanyById(companyId);
	    model.addAttribute("company", company);
		return "company-update";
	}
	
	@PostMapping("/company/{companyId}/update")
	public String updateCompany(@Valid @ModelAttribute("company") CompanyDto companyDto, BindingResult result, @PathVariable("companyId") int companyId){
		
		if(result.hasErrors())
		{
			return "company-update";
		}
		this.companyService.updateCompany(companyDto, companyId);
		return "redirect:/web/company";
	}
	
	@GetMapping("/company/new")
	public String createompany(Model model){
		
		CompanyDto company = new CompanyDto();
	    model.addAttribute("company", company);
		return "company-create";
	}
	
	@PostMapping("/company/new")
	public String createCompany(@Valid @ModelAttribute("company") CompanyDto companyDto, BindingResult result){
		
		if(result.hasErrors())
		{
			return "company-create";
		}
		this.companyService.addCompany(companyDto);
		return "redirect:/web/company";
	}
	
	@GetMapping("/company/{companyId}/remove")
	public String removeCompany(@PathVariable("companyId") int companyId){
		
		this.companyService.removeCompany(companyId);
		return "redirect:/web/company";
	}
}
