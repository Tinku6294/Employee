package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path="c:\\Users\\basan\\Desktop\\Report";
        List<Employee> employees=employeeRepository.findAll();
        File file= ResourceUtils.getFile("classpath:employ.jrxml");
        JasperReport jasperReport=JasperCompileManager.compileReport(String.valueOf(file.getAbsoluteFile()));
        JRBeanCollectionDataSource dataSource=new  JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters=new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\employees.html");

        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\employees.pdf");

        }
return "report generated in path : "+path;
    }
}
