package com.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private String name;
    private String designation;
    private Double salary;
    private String doj;

    // Default constructor
    public EmployeeDTO() {
    }

    // Parameterized constructor
    public EmployeeDTO(String name, String designation, Double salary, String doj) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.doj = doj;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
