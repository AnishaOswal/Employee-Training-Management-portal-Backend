package com.infosys.employeeservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.employeeservice.Exception.EmployeeAlreadyExistsException;
import com.infosys.employeeservice.Exception.NoSuchEmployeeException;
import com.infosys.employeeservice.model.Employee;
import com.infosys.employeeservice.repository.EmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	//getting all employee records
	public List<Employee> getAllEmployee() 
	{
	List<Employee> employees = new ArrayList<Employee>();
	employeeRepository.findAll().forEach(employee -> employees.add(employee));
	return employees;
	}
	//getting a specific record
	public Optional <Employee> getEmployeeById(int id) throws NoSuchEmployeeException
	{
	Employee employee=employeeRepository.findById(id).orElseThrow(() -> new NoSuchEmployeeException("No such Employee exists"));
	return employeeRepository.findById(id);
	}
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public Employee Update(Employee employeeDetails) throws EmployeeAlreadyExistsException
	{
		Employee employee=employeeRepository.findById(employeeDetails.getId()).orElseThrow(()->new EmployeeAlreadyExistsException("Employee already exists for this id"));
		employee.setId(employeeDetails.getId());
		employee.setFirst_name(employeeDetails.getFirst_name());
		employee.setMiddle_name(employeeDetails.getMiddle_name());
		employee.setLast_name(employeeDetails.getLast_name());
		employee.setDob(employeeDetails.getDob());
		employee.setCity(employeeDetails.getCity());
		employee.setContact_number(employeeDetails.getContact_number());
		final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
	}
	//deleting a specific record
	public Map<String, Boolean> deleteEmployee(int id) throws NoSuchEmployeeException
	{
		Employee employee=employeeRepository.findById(id).orElseThrow(()->new NoSuchEmployeeException("No such Employee exists"));
		employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
}
