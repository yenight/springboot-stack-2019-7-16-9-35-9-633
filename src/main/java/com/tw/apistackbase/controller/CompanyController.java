package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.CompanyRepository;
import com.tw.apistackbase.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {
    private CompanyRepository companyRepository = new CompanyRepository();

    @GetMapping("/companies")
    public ResponseEntity getCompanies(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "0") int pageSize) {
        if (page == 0 || pageSize == 0)
            return ResponseEntity.ok(companyRepository.getCompanies());
        if (page * pageSize > companyRepository.getCompanies().size())
            pageSize = companyRepository.getCompanies().size();
        return ResponseEntity.ok(companyRepository.getCompanies().subList(page, pageSize - 1));
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
