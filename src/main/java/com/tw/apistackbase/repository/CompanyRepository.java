package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
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
        companyList.add(new Company(0, "a", 10, new EmployeeRepository().getEmployees()));
        companyList.add(new Company(1, "b", 20, new EmployeeRepository().getEmployees()));
        companyList.add(new Company(2, "c", 30, new EmployeeRepository().getEmployees()));
        companyList.add(new Company(3, "d", 40, new EmployeeRepository().getEmployees()));
        companyList.add(new Company(4, "e", 50, new EmployeeRepository().getEmployees()));
        companyList.add(new Company(5, "f", 60, new EmployeeRepository().getEmployees()));
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

    public int getCompanyIndex(Company company) {
        return companyList.indexOf(company);
    }

    public void remove(Company company) {
        companyList.remove(company);
    }
}
