package com.tw.apistackbase.controller;

import com.tw.apistackbase.Company;
import com.tw.apistackbase.Employee;
import com.tw.apistackbase.EmployeeRepository;
import javafx.print.Collation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public ResponseEntity getEmployees(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "0") int pageSize,
                                       @RequestParam(required = false) String gender) {
        if (gender != null && !gender.isEmpty()) {
            return ResponseEntity.ok(employeeRepository.getEmployees().stream().filter(x->x.getGender().equals(gender)).collect(Collectors.toList()));
        }
        if (page == 0 || pageSize == 0)
            return ResponseEntity.ok(employeeRepository.getEmployees());
        if (page * pageSize > employeeRepository.getEmployees().size())
            pageSize = employeeRepository.getEmployees().size();
            return ResponseEntity.ok(employeeRepository.getEmployees().subList(page, pageSize - 1));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployees(@PathVariable long id) {
        if (id >= 0)
            return ResponseEntity.ok(employeeRepository.getEmployeesById(id));
        else
            return (ResponseEntity) ResponseEntity.badRequest();
    }

    @PostMapping(value = "/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        if (employee.getId() == 0) {
            Employee createdEmployee = new Employee();
            BeanUtils.copyProperties(employee, createdEmployee);
            createdEmployee.setId(employeeRepository.getEmployees().size());
            employeeRepository.add(createdEmployee);
            return ResponseEntity.ok(createdEmployee);
        } else {
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        if (id >= 0) {
            Employee updatedEmployee = employeeRepository.getEmployees().stream()
                    .filter(x -> x.getId() == id)
                    .findFirst().orElse(null);
            if (updatedEmployee != null) {
                BeanUtils.copyProperties(employee, updatedEmployee);
                updatedEmployee.setId(id);
            }
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }


}
