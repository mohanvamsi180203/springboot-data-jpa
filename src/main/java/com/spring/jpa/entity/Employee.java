package com.spring.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	private Integer empId;
	private String empName;
	private String designation;
	private double salary;
}
