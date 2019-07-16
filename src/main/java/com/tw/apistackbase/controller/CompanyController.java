package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    private CompanyRepository companyRepository = new CompanyRepository();

    @GetMapping("/companies")
    public ResponseEntity getCompanies() {
        return ResponseEntity.ok(companyRepository.getCompanies());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity getCompaniesById(@PathVariable long id) {
        return ResponseEntity.ok(companyRepository.getCompaniesById(id));
    }

    @GetMapping("/companies/{id}/employees")
    public ResponseEntity getCompanyEmployeesById(@PathVariable long id) {
        return ResponseEntity.ok(companyRepository.getCompanyEmployeesById(id));
    }



    @PostMapping("/companies")
    public ResponseEntity createCompany(@RequestBody Company company) {
        companyRepository.add(company);
        return ResponseEntity.ok(company);
    }

}
