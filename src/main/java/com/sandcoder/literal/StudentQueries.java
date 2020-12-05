package com.sandcoder.literal;

public class StudentQueries {
	
	public static final String selectAll = "select * from student";
	public static final String selectOne = "select * from student where id=?";
	public static final String insertOne = "insert into student values(?,?,?)";
	public static final String updateOne = "update student set name=?,address=? where id=?";
	public static final String deleteOne = "delete from student where id=?";

}
