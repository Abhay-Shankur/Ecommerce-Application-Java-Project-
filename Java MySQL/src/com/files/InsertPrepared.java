package com.files;
import java.sql.*;

import com.files.Connection.MyCon;  
public class InsertPrepared {
	public static void main(String args[]){  
		try{  
//			Class.forName("oracle.jdbc.driver.OracleDriver");  
//			  
//			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  

			Connection conn =MyCon.getConnection();
			PreparedStatement stmt=conn.prepareStatement("insert into profile values(?,?,?)");  
			stmt.setInt(1,1546);//1 specifies the first parameter in the query  
			stmt.setString(2,"Akash");
			stmt.setString(3,"akash@gmail.com");
//			stmt.setInt(3,29);
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			conn.close();  
			  
		}catch(Exception e){ System.out.println(e);}  
		
		MyCon.changeToUser();
		try {
			Connection conn =MyCon.getConnection();
			PreparedStatement stmt=conn.prepareStatement("insert into profile(Name,Email,Phone,Password,DOB,Address,City,State,Country) values(?,?,?,?,?,?,?,?,?)");  
//			stmt.setInt(1, null);//1 specifies the first parameter in the query  
			stmt.setString(1,"Akash");
			stmt.setString(2,"akash@gmail.com");
			stmt.setString(3, "8989898989");
			stmt.setString(4, "akash@3812");
			stmt.setString(5, "21/Feb/2003");
			stmt.setString(6, "abc");
			stmt.setString(7, "Pune");
			stmt.setString(8, "Maharashtra");
			stmt.setString(9, "India");
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			conn.close();
		}catch(Exception e){ System.out.println(e);}  
	}  

}