package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create operation
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read operation
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // Update operation
    public Employee updateEmployee(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            return null; // Employee with the given id not found
        }
    }

    // Delete operation
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
