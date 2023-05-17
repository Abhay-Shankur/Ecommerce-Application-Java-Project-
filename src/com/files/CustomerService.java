package com.files;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerService implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");

	//Image
	ImageIcon imgicon;
	Image img,newimg;

	
	//Button
	JButton home=new JButton("HOME");
	JButton search=new JButton("SEARCH");
	JButton profile=new JButton("PROFILE");
	JButton cart=new JButton("CART");
	JButton more=new JButton("MORE");	
	
	//Panel
	JPanel panelbottommenu=new JPanel();
	JPanel panelbody=new JPanel();
	JPanel panelcotent=new JPanel();

	// Container
	JPanel container=new JPanel();
	
	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbkart=new JLabel("E-Kart");
	
	
	CustomerService()
	{

		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of ScrollPane
		scrollpane();
		
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

	private void container()
	{
		container=new JPanel();
		container.setLocation(3,5);
		container.setSize(300, 485);
		container.setBackground(new Color(225,105,0));
		container.setLayout(null);
		
		JPanel panel1=new JPanel();
		panel1.setLocation(20, 40);
		panel1.setSize(260, 400);
		panel1.setBackground(new Color(255,248,220));
		panel1.setLayout(null);
		JLabel email=new JLabel("Email :");
		email.setLocation(20, 100);
		email.setSize(100, 15);
		email.setForeground(Color.black);
		email.setFont(new Font("",Font.BOLD,15));
		JLabel phn=new JLabel("Contact :");
		phn.setLocation(20, 150);
		phn.setSize(100, 15);
		phn.setForeground(Color.black);
		phn.setFont(new Font("",Font.BOLD,15));
		JLabel instaid=new JLabel("Instagram :");
		instaid.setLocation(20, 200);
		instaid.setSize(100, 15);
		instaid.setForeground(Color.black);
		instaid.setFont(new Font("",Font.BOLD,15));
		JLabel fbid=new JLabel("Facebook :");
		fbid.setLocation(20, 250);
		fbid.setSize(100, 15);
		fbid.setForeground(Color.black);
		fbid.setFont(new Font("",Font.BOLD,15));
		
		
		JTextArea txtemail=new JTextArea(new String("ekartservice@gmail.com"));
		txtemail.setLocation(120, 100);
		txtemail.setSize(130, 20);
		txtemail.setEditable(false);
		txtemail.setBackground(new Color(255,248,220));
		JTextArea txtphn=new JTextArea(new String("+91 99999 99999"));
		txtphn.setLocation(120, 150);
		txtphn.setSize(130, 20);
		txtphn.setEditable(false);
		txtphn.setBackground(new Color(255,248,220));
		JTextArea txtinstaid=new JTextArea(new String("@EKartService"));
		txtinstaid.setLocation(120, 200);
		txtinstaid.setSize(130, 20);	
		txtinstaid.setEditable(false);
		txtinstaid.setBackground(new Color(255,248,220));
		JTextArea txtfbid=new JTextArea(new String("E-Kart Service"));
		txtfbid.setLocation(120, 250);
		txtfbid.setSize(130, 20);
		txtfbid.setEditable(false);
		txtfbid.setBackground(new Color(255,248,220));
		
		panel1.add(txtemail);
		panel1.add(txtphn);
		panel1.add(txtinstaid);
		panel1.add(txtfbid);
		panel1.add(email);
		panel1.add(phn);
		panel1.add(instaid);
		panel1.add(fbid);
		
		container.add(panel1);
		
		
		panelcotent.add(container);
	}


	
	private void scrollpane()
	{

		container();	
		
		panelcotent.setLocation(0, 30);
		panelcotent.setPreferredSize(new Dimension(300, 490));
		panelcotent.setBackground(new Color(225,105,0));
		panelcotent.setLayout(null);
	
		scrollpanebody.setLocation(0, 0);
		scrollpanebody.setSize(310, 500);
		scrollpanebody.setViewportView(panelcotent);
		scrollpanebody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpanebody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
	}
	
 	private void paneladd()
 	{
 		panelbottommenu.add(home);
 		panelbottommenu.add(search);
 		panelbottommenu.add(profile);
 		panelbottommenu.add(cart);
 		panelbottommenu.add(more);
 				
 		panelbody.add(scrollpanebody);
 	}
 	
	private void frameadd()
	{
		frame.add(lbkart);
		frame.add(panelbottommenu);
		frame.add(panelbody);
	}
	
	private void setlabel()
	{		
		lbkart.setLocation(120, 0);
		lbkart.setSize(100, 30);
		lbkart.setForeground(Color.white);
		lbkart.setFont(lbkart.getFont().deriveFont(17.0f));

	}
	
	private void settextfield()
	{
		
	}
	
	private void setpanel()
	{

		panelbody.setLocation(0, 30);
		panelbody.setSize(310, 500);
		panelbody.setBackground(Color.darkGray);
		panelbody.setLayout(null);
		
		panelbottommenu.setLocation(0, 530);
		panelbottommenu.setSize(310, 30);
		panelbottommenu.setBackground(Color.white);
		panelbottommenu.setLayout(null);
	}
		
	private void setbutton()
	{

		
		//Bottom Menu
		imgicon=new ImageIcon("./logo/home.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		home=new JButton(imgicon);
		home.setLocation(0, 0);
		home.setSize(60, 30);
		home.setBackground(Color.white);	
		home.setForeground(Color.black);
		home.setFont(home.getFont().deriveFont(20.0f));
		home.setBorderPainted(false);
		home.addActionListener(this);
		home.setBorder(null);		
		home.setFont(home.getFont().deriveFont(13.0f));

		imgicon=new ImageIcon("./logo/search.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		search=new JButton(imgicon);
		search.setLocation(60, 0);
		search.setSize(60, 30);
		search.setBackground(Color.white);
		search.setForeground(Color.black);
		search.setFont(search.getFont().deriveFont(20.0f));
		search.setBorderPainted(false);
		search.addActionListener(this);
		search.setBorder(null);	
		search.setFont(search.getFont().deriveFont(13.0f));
		
		imgicon=new ImageIcon("./logo/profile.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		profile=new JButton(imgicon);
		profile.setLocation(125, 0);
		profile.setSize(60, 30);
		profile.setBackground(Color.white);		
		profile.setForeground(Color.black);
		profile.setFont(profile.getFont().deriveFont(20.0f));
		profile.setBorderPainted(false);
		profile.addActionListener(this);
		profile.setBorder(null);	
		profile.setFont(profile.getFont().deriveFont(13.0f));
		
		imgicon=new ImageIcon("./logo/cartlogo1.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		cart=new JButton(imgicon);
		cart.setLocation(190, 0);
		cart.setSize(60, 30);
		cart.setBackground(Color.white);		
		cart.setForeground(Color.black);
		cart.setFont(cart.getFont().deriveFont(20.0f));
		cart.setBorderPainted(false);
		cart.addActionListener(this);
		cart.setBorder(null);	
		cart.setFont(cart.getFont().deriveFont(13.0f));
		
		imgicon=new ImageIcon("./logo/Menu1.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		more=new JButton(imgicon);
		more.setLocation(250, 0);
		more.setSize(60, 30);
		more.setBackground(Color.white);		
		more.setForeground(Color.black);
		more.setFont(more.getFont().deriveFont(20.0f));
		more.setBorderPainted(false);
		more.addActionListener(this);
		more.setBorder(null);	
		more.setFont(more.getFont().deriveFont(13.0f));
	}
	
	
	public void actionPerformed(ActionEvent e)
	{

		
		if(e.getSource()==home)
		{
			new Home();
			frame.dispose();
		}
		if(e.getSource()==search)
		{
			new Search();
			frame.dispose();
		}
		if(e.getSource()==profile)
		{
			new Profile();
			frame.dispose();
		}
		if(e.getSource()==cart)
		{
			new Cart();
			frame.dispose();
		}
		if(e.getSource()==more)
		{
			new More();
			frame.dispose();
		}
	}

}
