package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeRepository;
import com.demo.model.Employee;

@Service
public class EmployeeService 	{
	@Autowired
	private EmployeeRepository employeeRepository ;

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void delete(Integer id) {
		employeeRepository.delete(id);
		
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public void save(List<Employee> employeeList) {
		employeeRepository.save(employeeList);
		
	}

	public void deleteAll() {
		employeeRepository.deleteAll();		
	}

	public Employee findOne(Integer id) {
		return employeeRepository.findOne(id);
	}
	
	
	
}
