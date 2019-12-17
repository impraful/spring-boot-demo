package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getAllStudent() {
		List<Student> findAll = studentDao.findAll();
		System.out.println("list "+ findAll);
		System.out.println("list1 "+ studentDao.findAll());
		return findAll;
	}

	public boolean add(Student student) {
		return studentDao.add(student);
	}

	public boolean update(Student student) {
		return studentDao.update(student);
	}

	public boolean delete(int id) {
		return studentDao.delete(id);
	}

}
