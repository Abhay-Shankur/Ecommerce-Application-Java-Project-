package Frames;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static String id,pass;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(isloggedin())
		{
			new Home();
//			new struct();
		}
		else
		{
			new FrameLoginSignup();
		}		
	}
	//is Already logged in 
	public static boolean isloggedin()
	{
		try
		{
			File file=new File("./UserData.txt");
			if(file.exists())
			{
				Scanner fileread=new Scanner(file);
				if(fileread .hasNextLine())
				{
					id=fileread.nextLine();
					pass=fileread.nextLine();
					fileread.close();
					return true;
				}
				else	
				{
					fileread.close();
					throw new IOException("File Content Missing !");		
				}
			}
			else
				return false;
		}
		catch(IOException e)
		{
			return false;
		}
	}
}
