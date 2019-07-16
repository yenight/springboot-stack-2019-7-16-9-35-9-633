package com.tw.apistackbase;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyRepository {
    private List<Company> companyList;

    public CompanyRepository() {
        this.companyList = new ArrayList<>();
        companyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
    }

    public List<Company> getCompanies() {
        return companyList;
    }

    public Company getCompaniesById(long id) {
        return companyList.stream().filter(x -> x.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<Employee> getCompanyEmployeesById(long id) {
        return companyList.stream().filter(x -> x.getId() == id).collect(Collectors.toList()).get(0).getEmployees();
    }

    public void add(Company company) {
        companyList.add(company);
    }

}
