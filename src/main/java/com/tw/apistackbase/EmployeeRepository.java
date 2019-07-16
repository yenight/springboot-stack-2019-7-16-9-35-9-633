package com.tw.apistackbase;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "a", 10, "male", 6000));
        employees.add(new Employee(2, "b", 20, "female", 8000));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }
}
