package com.he.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	
	
	
	

}
