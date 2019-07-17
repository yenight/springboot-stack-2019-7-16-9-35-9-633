package com.tw.apistackbase;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "a", 10, "male", 6000));
        employees.add(new Employee(2, "b", 20, "female", 8000));
        employees.add(new Employee(3, "c", 30, "male", 9000));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeesById(long id) {
        return employees.stream().filter(x->x.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}
