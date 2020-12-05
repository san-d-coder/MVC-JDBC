package com.sandcoder.service;

import java.sql.SQLException;

import com.sandcoder.model.Student;
import com.sandcoder.repository.StudentRepository;
import com.sandcoder.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl() {
		studentRepository = new StudentRepositoryImpl();
	}
	
	
	@Override
	public void getAllStudents() throws SQLException {
		studentRepository.getAllStudents();
	}
	
	@Override
	public void getStudent(int id) throws SQLException {
		if(id > 0)
			studentRepository.getStudent(id);
		else
			System.out.println("Invalid Input for Id: "+id);
	}
	
	
	@Override
	public void createStudent(Student student) throws SQLException {
		if(student.getId()>0 && student.getName() != null && student.getAddress() != null)
			studentRepository.createStudent(student);
		else
			System.out.println("Invalid Input for Student: "+student.toString());
	}
	
	@Override
	public void updateStudent(int id, Student student) throws SQLException {
		if(student.getId()>0 && student.getName() != null && student.getAddress() != null)
			studentRepository.updateStudent(id,student);
		else
			System.out.println("Invalid Input for Student: "+student.toString());
	}
	
	@Override
	public void deleteStudent(int id) throws SQLException {
		if(id > 0)
			studentRepository.deleteStudent(id);
		else
			System.out.println("Invalid Input for Id: "+id);
	}

}
