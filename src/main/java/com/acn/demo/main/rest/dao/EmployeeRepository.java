package com.acn.demo.main.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.acn.demo.main.rest.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
