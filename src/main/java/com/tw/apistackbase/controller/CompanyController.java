package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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

    @PostMapping(value = "/companies")
    public ResponseEntity createCompany(@RequestBody Company company) {
        System.out.println("testtt:" + company.getId());
        if (company.getId() == 0) {
            Company createdCompany = new Company();
            BeanUtils.copyProperties(company, createdCompany);
            createdCompany.setId(companyRepository.getCompanies().size());
            companyRepository.add(createdCompany);
            return ResponseEntity.ok(createdCompany);
        } else {
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity updateCompany(@PathVariable long id, @RequestBody Company company) {
        if (id >= 0) {
            Company updatedCompany = companyRepository.getCompanies().stream().filter(x -> x.getId() == company.getId()).collect(Collectors.toList()).get(0);
            if (updatedCompany != null) {
                BeanUtils.copyProperties(company, updatedCompany);
                updatedCompany.setId(id);
            }
            return ResponseEntity.ok(updatedCompany);
        } else {
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }

}
