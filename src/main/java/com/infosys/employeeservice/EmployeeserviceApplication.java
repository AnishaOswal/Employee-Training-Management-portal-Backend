package com.infosys.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infosys.employeeservice.model.Employee;
import com.infosys.employeeservice.service.EmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeserviceApplication implements CommandLineRunner{
	@Autowired
	ApplicationContext context;
	@Autowired
	EmployeeService service;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee emp1= new Employee(00,"Anisha","N.A.","Oswal",201097,"Ajmer",0000);
		service.Update(emp1);
		
	}

}
