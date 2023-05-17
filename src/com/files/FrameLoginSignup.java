package com.files;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FrameLoginSignup implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");

	//Image
	ImageIcon imgicon;
	Image img,newimg;
	
	//Panel object
	JPanel panelTop=new JPanel();
	JPanel panelMiddle=new JPanel();
	JPanel panelBottom=new JPanel();
	JPanel panelBody=new JPanel();
	
	//Button object
	JButton btlogin=new JButton("Log In");
	JButton btSignup=new JButton("Sign Up");
	JButton btcancel;
	
	//Label Object
	JLabel lbtext=new JLabel("---------------------- OR ----------------------");
	JLabel lbkart=new JLabel("E-Kart");
	
	//Constructor
	FrameLoginSignup()
	{
	
		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of Button
		setbutton();

		//Function for setting the properties of Label
		setlabel();

		//Function for setting the properties of Textfield
		settextfield();
		
		//Function for adding components to Panel
		paneladd();
		
		//Function for adding components to frame
		frameadd();	

		frame.getContentPane().setBackground(new Color(25,25,25));
		frame.setSize(325, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}


 	private void paneladd()
 	{
 		
 	}
 	
	private void frameadd()
	{
		
		frame.add(lbkart);
		frame.add(btcancel);
		frame.add(btlogin);
		frame.add(lbtext);
		frame.add(btSignup);

	}
	
	private void setlabel()
	{		
		
		lbtext.setLocation(30, 360);
		lbtext.setForeground(Color.white);
		lbtext.setSize(250, 30);
		lbtext.setFont(lbtext.getFont().deriveFont(14.0f));
		
		
		lbkart.setLocation(30, 150);
		lbkart.setForeground(Color.white);
		lbkart.setSize(250, 100);
		lbkart.setFont(lbkart.getFont().deriveFont(50.0f));
	}
	
	private void settextfield()
	{
		
	}
	
	private void setpanel()
	{
		
	}
		
	private void setbutton()
	{
		
		imgicon=new ImageIcon("./logo/cancel.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(30,30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btcancel=new JButton(imgicon);
		btcancel.setLocation(0, 0);
		btcancel.setSize(50, 30);
		btcancel.setBackground(new Color(250,250,250));
		btcancel.addActionListener(this);
		btcancel.setBorder(null);
		
		btlogin.setLocation(30, 320);
		btlogin.setSize(250, 30);
		btlogin.setBackground(new Color(255,255,255));
		btlogin.setForeground(Color.black);
		btlogin.setFont(btlogin.getFont().deriveFont(15.0f));
		btlogin.addActionListener(this);
				
		btSignup.setLocation(30, 400);
		btSignup.setSize(250, 30);
		btSignup.setBackground(new Color(255,255,255));
		btSignup.setForeground(Color.black);
		btSignup.setFont(btlogin.getFont().deriveFont(15.0f));		
		btSignup.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btcancel)
		{
			new Home();
			frame.dispose();
		}
		if(e.getSource()==btlogin)
		{
			new Login();
			frame.dispose();
		}
		if(e.getSource()==btSignup)
		{
			new Signup();
			frame.dispose();
		}
	}	
}
