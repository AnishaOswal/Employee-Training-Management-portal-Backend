package com.infosys.employeeservice.Exception;

public class EmployeeAlreadyExistsException extends Exception {
private static final long serialVersionUID=1L;
public EmployeeAlreadyExistsException() {
	super();
}
public EmployeeAlreadyExistsException(String errormsg) {
	super(errormsg);
}
}
