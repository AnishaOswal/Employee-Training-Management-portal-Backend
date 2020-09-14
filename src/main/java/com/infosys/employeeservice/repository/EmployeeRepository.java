package com.infosys.employeeservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.infosys.employeeservice.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
