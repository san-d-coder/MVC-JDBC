package com.sandcoder.service;

import java.sql.SQLException;

import com.sandcoder.model.Student;

public interface StudentService {

	void getAllStudents() throws SQLException;

	void getStudent(int id) throws SQLException;

	void createStudent(Student student) throws SQLException;

	void updateStudent(int id, Student student) throws SQLException;

	void deleteStudent(int id) throws SQLException;

}