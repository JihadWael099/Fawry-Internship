package com.example.task2.controller;

import com.example.task2.dto.FullNameDto;
import com.example.task2.entity.Employee;
import com.example.task2.dto.EmployeeNameSalarClose;
import com.example.task2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }
    @GetMapping("/names-and-salaries")
    public List<EmployeeNameSalarClose> getAllEmployeeNamesAndSalaries() {
        return employeeRepository.findAllEmployeeNamesAndSalaries();
    }

    @GetMapping("/search")
    public List<EmployeeNameSalarClose> getEmployeeNamesAndSalariesByName(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/fullName")
    public List<FullNameDto> getEmployeeFullNames() {
        return employeeRepository.findEmployeeFullNames();
    }
}
