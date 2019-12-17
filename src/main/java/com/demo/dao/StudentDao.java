package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public class StudentDao // extends JpaRepository<Student, Integer>
{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> findAll() {
		String sql = "select id , address , city , first_name , last_name  from student_info";
		;
		return this.jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override 
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setAddress(rs.getString("address"));
				student.setCity(rs.getString("city"));
				student.setFirstName(rs.getString("first_name"));
				student.setFirstName(rs.getString("last_name"));
				return student;
			}

		});
	}

	public boolean add(Student student) {
		String sql = "insert into student_info(id, last_name, first_name, address, city) values" + 
				"(?, ?, ?, ?, ?);";
		 int count = jdbcTemplate.update(sql, new Object[] {
				student.getId(), student.getLastName(), student.getFirstName(), student.getAddress(), student.getCity()}) ;
		 return count > 0  ;
	}

	public boolean update(Student student) {
		String sql = "update student_info set last_name=?, first_name=?, address=?, city=? where id = ? ";
		 int count = jdbcTemplate.update(sql, new Object[] {
				student.getLastName(), student.getFirstName(), student.getAddress(), student.getCity(),student.getId()}) ;
		 return count > 0  ;
	}

	public boolean delete(int id) {
		String sql = "delete from student_info  where id = ? ";
		 int count = jdbcTemplate.update(sql, new Object[] {id}) ;
		 return count > 0  ;
	}

}
