package com.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.sql.Statement;

import com.connection.MyCon;

import java.sql.ResultSet;

public class User {

	//Connection String
//	String dburl="jdbc:ucanaccess://EcommDB.accdb";
	
	private static String userid,username,useremail,userphone,userpassword,userdob,useradd,usercity,userstate,usercountry;
//	public static String ;
	
	public void setUserId(String id)
	{	userid=id;	}
	public void setUserName(String name)
	{	username=name;	}
	public void setUserEmail(String email)
	{	useremail=email;	}
	public void setUserPhone(String phone)
	{	userphone=phone;	}
	public void setUserPassword(String password)
	{	userpassword=password;	}
	public void setUserDob(String dob)
	{	userdob=dob;	}
	public void setUserAddress(String add)
	{	useradd=add;	}
	public void setUserCity(String city)
	{	usercity=city;	}
	public void setUserState(String state)
	{	userstate=state;	}
	public void setUserCountry(String country)
	{	usercountry=country;	}
	
	
	public String getUserId()
	{	return userid;	}
	public String getUserName()
	{	return username;	}
	public String getUserEmail()
	{	return useremail;	}
	public String getUserPhone()
	{	return userphone;	}
	public String getUserPassword()
	{	return userpassword;	}
	public String getUserDob()
	{	return userdob;	}
	public String getUserAddress()
	{	return useradd;	}
	public String getUserCity()
	{	return usercity;	}
	public String getUserState()
	{	return userstate;	}
	public String getUserCountry()
	{	return usercountry;	}
	
	
	//Inserting User Data
	public boolean insertUserData()
	{				
		try 
		{
			//connection
//			Connection conn=DriverManager.getConnection(dburl);
			Connection conn=MyCon.getConnection();
			
			//Sql Query Statement
			String sql1="SELECT USEREMAIL FROM Profile WHERE USEREMAIL='"+useremail+"'";
			
			//Statement
			Statement statement1=conn.createStatement();
			
			//to fetch value of Attributes
			ResultSet result=statement1.executeQuery(sql1);
			
			if(result.next())
			{
				return false;
			}
			else
			{
				//Sql Query Statement
				String sql2="INSERT INTO Profile (USERNAME,USEREMAIL,USERPHONE,USERPASSWORD,DOB,ADDRESS,CITY,STATE,COUNTRY) VALUES(?,?,?,?,?,?,?,?,?)";
				
				//PreparedStatement
				PreparedStatement statement= conn.prepareStatement(sql2);
				statement.setString(1, getUserName());
				statement.setString(2, getUserEmail());
				statement.setString(3, getUserPhone());
				statement.setString(4, getUserPassword());
				statement.setString(5, getUserDob());
				statement.setString(6, getUserAddress());
				statement.setString(7, getUserCity());
				statement.setString(8, getUserState());
				statement.setString(9, getUserCountry());
				
				int rows=statement.executeUpdate();
				
				statement.close();
				
				//Connection close
				conn.close();
				
				if(rows==0)
				{
					throw new SQLException("Something went wrong !");
				}
				else
				{		
					try
					{
						File file=new File("UserData.txt");
						if(file.exists())
							file.delete();
						if(file.createNewFile())
						{
							FileWriter filewrite=new FileWriter("UserData.txt");
							filewrite.write(useremail);
							filewrite.write("\n"+userpassword);
							filewrite.close();
							return true;
						}
						else
							throw new IOException("Log in Failed ! Please Re-Try Log in");						
					}
					catch(IOException e)
					{
						e.printStackTrace();
						return false;
					}
				}				
			}
		}	
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
		}		
	}
	
	//Retrieving User Data
	public boolean retrieveUserData(String Email)
	{		
		try {

			//connection
//			Connection conn=DriverManager.getConnection(dburl);			
			Connection conn=MyCon.getConnection();
			
			//Sql Query Statement
			String sql="SELECT * FROM Profile WHERE USEREMAIL='" + Email + "'";
			
			//Statement
			Statement statement =conn.createStatement();
			
			//to fetch value of Attributes
			ResultSet result=statement.executeQuery(sql);
			if(result.next())
			{

				userid=result.getString("USERID");
				setUserId(userid);
				username=result.getString("USERNAME");
				setUserName(username);
				useremail=result.getString("USEREMAIL");
				setUserEmail(useremail);
				userphone=result.getString("USERPHONE");
				setUserPhone(userphone);
				userpassword=result.getString("USERPASSWORD");
				setUserPassword(userpassword);
				userdob=result.getString("DOB");
				setUserDob(userdob);
				useradd=result.getString("ADDRESS");
				setUserAddress(useradd);
				usercity=result.getString("CITY");
				setUserCity(usercity);
				userstate=result.getString("STATE");
				setUserState(userstate);
				usercountry=result.getString("COUNTRY");
				setUserCountry(usercountry);
				return true;
			}
			
			//Connection close
			conn.close();		
			return false;
		}
		catch(SQLException e) 
		{
			return false;
		}
	}	
}
