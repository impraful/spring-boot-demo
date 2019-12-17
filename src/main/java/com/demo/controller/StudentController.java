package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.service.StudentService;

@RestController
/*
 * if we used @RestController, don't need to add @ResponseBody add method level.
 * 
 * @RestController = @Controller + @ResponseBody
 */
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping("/getall")
	public List<Student> getAllStudent() {
		return service.getAllStudent();
	}

	/*
	 * sample request
	 * 
	 * { "address": "baner", "city": "pune", "firstName": "mb", "id": 11,  "lastName": "fh" }
	 */
	@PostMapping("/add")
	public boolean add(@RequestBody Student student) {
		return service.add(student);
	}

	/*
	 * sample request
	 * 
	 * { "address": "baner", "city": "pune", "firstName": "mb", "id": 10, "lastName": "fh" }
	 */
	@PutMapping("/update")
	public boolean update(@RequestBody Student student) {
		return service.update(student);
	}
	
	@DeleteMapping("/delete")
	public boolean update(@RequestParam int id) {
		return service.delete(id);
	}
}
