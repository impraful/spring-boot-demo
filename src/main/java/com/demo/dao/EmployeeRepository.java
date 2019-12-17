package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employee;
	
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
