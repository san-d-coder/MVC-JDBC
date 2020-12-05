package com.sandcoder.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnector {
	
	private static Connection con = null;
	private static FileInputStream fis = null;
	private static Properties prop = null;
	private static String url = "";
	private static String username = "";
	private static String password = "";
	
	
	@SuppressWarnings("finally")
	public static Connection getConnection() {
		
		try {
			//Initialize Input Stream to read Properties
			fis = new FileInputStream("connection.prop");
			
			//Load Properties File
			prop = new Properties();
			prop.load(fis);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			//Setup DB Connection
			con = DriverManager.getConnection(url,username,password);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
		return con;
		}
	}

}
