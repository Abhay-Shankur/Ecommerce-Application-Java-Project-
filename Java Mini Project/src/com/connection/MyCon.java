package com.connection;
import java.sql.*;  

public class MyCon {
	
//	For Local Host :
	final static private String HOST="localhost";
	final static private String PORT="3306";
	final static private String ATTR="?allowPublicKeyRetrieval=true&useSSL=false";
	static private String USERNAME="root";
	static private String PASSWORD="Shankur@3812";
	final static private String DBNAME="ecomdb";
	
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME+ATTR,USERNAME,PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Exception : MyCon.java"+conn.toString());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found : ");
			e.printStackTrace();
		}
		return conn;
	}
	
}