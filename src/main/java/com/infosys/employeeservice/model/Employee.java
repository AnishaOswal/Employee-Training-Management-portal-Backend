package com.infosys.employeeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	public Employee(int id,String first_name, String middle_name, String last_name,int dob,String city,int contact_number) {
		  this.id = id;
		  this.first_name = first_name;
		  this.middle_name = middle_name;
		  this.last_name = last_name;
		  this.dob = dob;
		  this.city=city;
		  this.contact_number=contact_number;
		  
		 }
		 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String first_name;
	
	@Column
	private String middle_name;
	
	@Column
	private String last_name;
	
	@Column
	private int dob;
	
	@Column
	private String city;
	
	@Column
	private int contact_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContact_number() {
		return contact_number;
	}

	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	@Override
    public String toString() {
		return "Employee [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", middleName=" + middle_name + ", dob=" +dob+",city=" + city +",contact_number=" + contact_number+
	            "]";
    }
	
}
