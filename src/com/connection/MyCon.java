package com.connection;
import java.sql.*;  

public class MyCon {
//	For Anonymous User :
//	final static private String HOST="192.168.1.14";
//	final static private String PORT="3306";
//	final static private String ATTR="?allowPublicKeyRetrieval=true&useSSL=false";
//	static private String USERNAME="anonymous";
//	static private String PASSWORD="anonymous@3812";
//	final static private String DBNAME="ecomdb";
	
//	For Registered User :
//	final static private String HOST="192.168.1.14";
//	final static private String PORT="3306";
//	final static private String ATTR="?allowPublicKeyRetrieval=true&useSSL=false";
//	final static private String USERNAME="user";
//	final static private String PASSWORD="user@3812";
//	final static private String DBNAME="db";
	
//	For Local Host :
	final static private String HOST="localhost";
	final static private String PORT="3306";
	final static private String ATTR="?allowPublicKeyRetrieval=true&useSSL=false";
	static private String USERNAME="root";
	static private String PASSWORD="Shankur@3812";
	final static private String DBNAME="ecomdb";
	
	private static Connection conn;
	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME+ATTR,USERNAME,PASSWORD);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("SQL Exception : ");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class Not Found : ");
//			e.printStackTrace();
//		}
//	}
	
//	private static boolean reInit() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME+ATTR,USERNAME,PASSWORD);
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("SQL Exception : ");
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class Not Found : ");
//			e.printStackTrace();
//		}
//		return false;
//	}
	
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
	
//	public static boolean changeToUser() {
//		USERNAME="user";
//		PASSWORD="user@3812";
//		if(USERNAME=="user" && PASSWORD=="user@3812") {
////			if(reInit())
//				return true;
//		}
//		return false;
//	}
//	try{  
//	  
//	  
//	//here sonoo is database name, root is username and password  
//	Statement stmt=con.createStatement();  
//	ResultSet rs=stmt.executeQuery("select * from emp");  
//	while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//	con.close();  
//	} catch(Exception e){ 
//		System.out.println(e);
//	}  
}