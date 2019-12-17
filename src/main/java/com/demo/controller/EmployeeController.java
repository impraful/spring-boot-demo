package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

// When we used @RestController, no need to use @ResponseBody at mwthod
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Select, Insert, Delete, Update Operations for an Employee

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    Employee getEmployee(@RequestParam Integer id){
        return  employeeService.findOne(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    String addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    Map deleteEmployee(@RequestParam Integer id){
        employeeService.delete(id);

        Map<String, String> status = new HashMap<>();
        status.put("Status", "Success");
        return status;
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    String addAllEmployees(@RequestBody List<Employee> employeeList){
        employeeService.save(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE)
    String addAllEmployees(){
        employeeService.deleteAll();
        return "SUCCESS";
    }
}
