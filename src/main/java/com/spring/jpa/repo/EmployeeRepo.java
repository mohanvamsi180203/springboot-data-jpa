package com.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
