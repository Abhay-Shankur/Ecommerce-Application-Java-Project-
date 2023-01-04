package com.files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.files.Connection.MyCon;

public class MysqlCon {

	public static void main(String args[]){  
		try{  
//			Class.forName("com.mysql.cj.jdbc.Driver");  
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useSSL=false","root","Shankur@3812");  
		//here sonoo is database name, root is username and password  
			Connection conn =MyCon.getConnection();
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from profile");  
			while(rs.next())  
				System.out.println(rs.getInt("USERID")+"  "+rs.getString("USERNAME")+"  "+rs.getString("USEREMAIL"));  
			conn.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  

}
