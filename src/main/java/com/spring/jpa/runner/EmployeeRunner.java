package com.spring.jpa.runner;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.spring.jpa.entity.Employee;
import com.spring.jpa.repo.EmployeeRepo;

@Component
public class EmployeeRunner implements CommandLineRunner {
	
	@Autowired
	EmployeeRepo eRepo;

	@Override
	public void run(String... args) throws Exception {
		Employee e = new Employee();
		e.setEmpId(1);
		e.setEmpName("Rengoku");
		e.setDesignation("Hashira");
		e.setSalary(2000);
		
		Employee e1 = new Employee();
		e1.setEmpId(2);
		e1.setEmpName("Akaza");
		e1.setDesignation("Upper 3 Demon");
		e1.setSalary(200000);
		
		Employee e2 = new Employee();
		e2.setEmpId(3);
		e2.setEmpName("Douma");
		e2.setDesignation("Upper 2 Demon");
		e2.setSalary(200);
		
		
		Employee e3 = new Employee();
		e3.setEmpId(4);
		e3.setEmpName("Shinobu");
		e3.setDesignation("Hashira");
		e3.setSalary(20000);
		List<Employee> l1 = Arrays.asList(e,e1,e2,e3);
		eRepo.saveAll(l1);
		
		
		Sort sort = Sort.by("empName");
		eRepo.findAll(sort).forEach(System.out::println);
		
		Sort sort1 = Sort.by("Salary").descending();
		eRepo.findAll(sort1).forEach(System.out::println);
		
			
		Pageable page1 = PageRequest.of(0, 2,sort); //Index Starts From page 0
		Pageable page2 = PageRequest.of(1, 2,sort1); //Index Starts From Page 1
		
		
		Page<Employee> p1 =  eRepo.findAll(page1);
		System.out.println("Page 1");
		p1.forEach(System.out::println);
		
		Page<Employee> p2 =  eRepo.findAll(page2);
		System.out.println("Page 2");
		p2.forEach(System.out::println);
		
		//offset = pageNumber  *  pageSize
		
		//   PageRequest.of(0, 1) --->  0 * 1 = 0
		//                               limit 1 = offset 0 
		
		//PageRequest.of(1, 3) ---> 1 * 3 = 3
									
	//	                            1 * limit = offset
		
		
	}
	
	

}
