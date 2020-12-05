package com.sandcoder.repository;

import java.sql.SQLException;

import com.sandcoder.model.Student;

public interface StudentRepository {

	String getAllStudents() throws SQLException;

	String getStudent(int id) throws SQLException;

	String createStudent(Student student) throws SQLException;

	String updateStudent(int id, Student student) throws SQLException;

	String deleteStudent(int id) throws SQLException;

}