package com.demo.controller;

import com.demo.DTO.EmployeeDTO;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import com.demo.repository.EmployeeRepository;
import com.demo.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
@RestController
public class EmployeeController {

        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private ReportService reportService;
        @Autowired
        private EmployeeService employeeService;
        @GetMapping("/getEmployees")
        public List<Employee> getEmployees(){
            return employeeRepository.findAll();
        }
        @GetMapping("/report/{format}")
        public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
            return reportService.exportReport(format);

        }
        @PostMapping("/employees")
        public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
            try {
                // Map EmployeeDTO to your Employee entity
                Employee employee = new Employee();
                employee.setName(employeeDTO.getName());
                employee.setDesignation(employeeDTO.getDesignation());
                employee.setSalary(employeeDTO.getSalary());
                employee.setDoj(employeeDTO.getDoj());

                // Save the entity using your service
                employeeService.createEmployee(employee);

                return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Failed to create employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
                    }

    }
