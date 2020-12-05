package com.sandcoder.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sandcoder.literal.StudentQueries;
import com.sandcoder.model.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	private Connection con;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Boolean result;
	
	
	public StudentRepositoryImpl() {
		con = DatabaseConnector.getConnection();
		if(con == null) {
			System.out.println("Error in Establishing Connection");
		}
		else {
			System.out.println("Connected to the Database");
		}
	}
	
	@Override
	@SuppressWarnings("finally")
	public String getAllStudents() throws SQLException {
		
		try {
			preparedStatement = con.prepareStatement(StudentQueries.selectAll);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)
						+ " "+
						resultSet.getString(2)
						+" "+ 
						resultSet.getString(3));
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {			
		con.close();
		return "";
		}
		
	}
	
	@Override
	@SuppressWarnings("finally")
	public String getStudent(int id) throws SQLException {
		try {
			preparedStatement = con.prepareStatement(StudentQueries.selectOne);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)
						+ " "+
						resultSet.getString(2)
						+" "+ 
						resultSet.getString(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		con.close();
		return "";
		}
	}
	
	@Override
	@SuppressWarnings("finally")
	public String createStudent(Student student) throws SQLException {
		
		try {

		preparedStatement = con.prepareStatement(StudentQueries.insertOne);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getAddress());
		
		result = preparedStatement.execute();
		
		if(result) {
			System.out.println("An error occurred");
		}
		else {
			System.out.println("Created the following Student\n"
					+student.getId()+" "+student.getName()+" "+student.getAddress());
			
		}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			return "";
		}
		
	}
	
	@Override
	@SuppressWarnings("finally")
	public String updateStudent(int id, Student student) throws SQLException {
		
		try {
			preparedStatement = con.prepareStatement(StudentQueries.updateOne);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getAddress());
			result = preparedStatement.execute();
			if(result) {
				System.out.println("An Error Occurred");
			}
			else {
				System.out.println("The updated Student:\n"
			+" "+
						student.getId()
			+" "+
						student.getName()
			+" "+
						student.getAddress());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			return "";
		}
	}
	
	@Override
	@SuppressWarnings("finally")
	public String deleteStudent(int id) throws SQLException {
		try {
			preparedStatement = con.prepareStatement(StudentQueries.deleteOne);
			preparedStatement.setInt(1, id);
			result = preparedStatement.execute();
			if(result) {
				System.out.println("An Error Occurred");
			}
			else {
				System.out.println("1 Row Deleted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			return "";
		}
		
	}

}
