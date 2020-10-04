package com.infosys.employeeservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.employeeservice.Exception.EmployeeAlreadyExistsException;
import com.infosys.employeeservice.Exception.NoSuchEmployeeException;
import com.infosys.employeeservice.model.Employee;
import com.infosys.employeeservice.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
@Api(value = "EmployeeController, REST APIs that deal with Employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	//creating a get mapping that retrieves all the employee detail from the database 
	@GetMapping("/employee")
	private List<Employee> getAllEmployee() 
	{
	return employeeService.getAllEmployee();
	}
	//creating a get mapping that retrieves the detail of a specific employee
	
	@ApiOperation(value = "Fetch  the employees of specific id", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the employee successfully"),
			@ApiResponse(code = 404, message = "Employee details not found") })

	@GetMapping("/employee/{id}")
	public ResponseEntity <Employee> getEmployeeById(@PathVariable("id") int id) throws NoSuchEmployeeException
	{
		Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new NoSuchEmployeeException("No such Employee exists"));
	        return ResponseEntity.ok().body(employee);
	}
	//creating a delete mapping that deletes a specific employee
	@DeleteMapping("/employee/{id}")
	public Map <String, Boolean> deleteEmployee(@PathVariable("id") int id) throws NoSuchEmployeeException
	{
	return employeeService.deleteEmployee(id);
	}
	//creating post mapping that post the employee detail in the database
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) 
	{
	return employeeService.createEmployee(employee);
	
	}
	@PutMapping("/employee/{id}")
    public ResponseEntity < Employee > Update(@RequestBody Employee employeeDetails) throws EmployeeAlreadyExistsException {
        Employee updatedEmployee = employeeService.Update(employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }
	
}
