package com.acn.demo.main.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.demo.main.rest.dao.EmployeeRepository;
import com.acn.demo.main.rest.model.Employee;
import com.acn.demo.main.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController 
{
    
    @Autowired EmployeeRepository employeeRepo;
    
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) 
    {
        return ResponseEntity.ok(employeeRepo.save(employee));
    }
     
    @GetMapping(path="/retrieve", produces = "application/json")
    public Employees getEmployees() 
    {
    	Employees employeeList = new Employees();
    	Iterable<Employee> employees = employeeRepo.findAll();
    	employees.forEach(employee->{
    		employeeList.getEmployeeList().add(employee);
    	});
    	return employeeList;
    }
     
    
}
