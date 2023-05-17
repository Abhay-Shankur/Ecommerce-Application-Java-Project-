package Frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.connection.MyCon;

import javax.swing.JTextArea;

public class Epay implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");

	//Image
	ImageIcon imgicon;
	Image img,newimg;

	//
	public static boolean islink=false;
	
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
	
	
	Epay()
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
		
		if(Main.isloggedin())
		{
			
			try
			{
				//Connection String
//				String dburl="jdbc:ucanaccess://EcommDB.accdb";
				
				//connection
//				Connection conn=DriverManager.getConnection(dburl);
				Connection conn=MyCon.getConnection();
				
				//Sql Query Statement
				String sql1="SELECT Name,Email,Phone,Bank,Account,IFSC,UPI FROM BankDetails WHERE Email ='"+Main.id+"'";
				
				//Statement
				Statement statement1=conn.createStatement();
				
				//to fetch value of Attributes
				ResultSet result1=statement1.executeQuery(sql1);
				
				if(result1.next())
				{
					JPanel panel1=new JPanel();
					panel1.setLocation(20, 40);
					panel1.setSize(260, 400);
					panel1.setBackground(new Color(255,248,220));
					panel1.setLayout(null);
					JLabel name=new JLabel("Name :");
					name.setLocation(20, 50);
					name.setSize(100, 15);
					name.setForeground(Color.black);
					name.setFont(new Font("",Font.BOLD,15));
					JLabel email=new JLabel("Email :");
					email.setLocation(20, 100);
					email.setSize(100, 15);
					email.setForeground(Color.black);
					email.setFont(new Font("",Font.BOLD,15));
					JLabel phn=new JLabel("Phone No :");
					phn.setLocation(20, 150);
					phn.setSize(100, 15);
					phn.setForeground(Color.black);
					phn.setFont(new Font("",Font.BOLD,15));
					JLabel bname=new JLabel("Bank Name :");
					bname.setLocation(20, 200);
					bname.setSize(100, 15);
					bname.setForeground(Color.black);
					bname.setFont(new Font("",Font.BOLD,15));
					JLabel accno=new JLabel("Account No :");
					accno.setLocation(20, 250);
					accno.setSize(100, 15);
					accno.setForeground(Color.black);
					accno.setFont(new Font("",Font.BOLD,15));
					JLabel ifsc=new JLabel("IFSC No :");
					ifsc.setLocation(20, 300);
					ifsc.setSize(100, 15);
					ifsc.setForeground(Color.black);
					ifsc.setFont(new Font("",Font.BOLD,15));
					JLabel upi=new JLabel("UPI Id:");
					upi.setLocation(20, 350);
					upi.setSize(100, 15);
					upi.setForeground(Color.black);
					upi.setFont(new Font("",Font.BOLD,15));
					
					JTextArea txtname=new JTextArea(new String(result1.getString("Name")));
					txtname.setLocation(120, 50);
					txtname.setSize(130, 20);
					txtname.setEditable(false);
					txtname.setBackground(new Color(255,248,220));
					JTextArea txtemail=new JTextArea(new String(result1.getString("Email")));
					txtemail.setLocation(120, 100);
					txtemail.setSize(130, 20);
					txtemail.setEditable(false);
					txtemail.setBackground(new Color(255,248,220));
					JTextArea txtphn=new JTextArea(new String(result1.getString("Phone")));
					txtphn.setLocation(120, 150);
					txtphn.setSize(130, 20);
					txtphn.setEditable(false);
					txtphn.setBackground(new Color(255,248,220));
					JTextArea txtbname=new JTextArea(new String(result1.getString("Bank")));
					txtbname.setLocation(120, 200);
					txtbname.setSize(130, 20);
					txtbname.setEditable(false);
					txtbname.setBackground(new Color(255,248,220));
					JTextArea txtacc=new JTextArea(new String(result1.getString("Account")));
					txtacc.setLocation(120, 250);
					txtacc.setSize(130, 20);	
					txtacc.setEditable(false);
					txtacc.setBackground(new Color(255,248,220));
					JTextArea txtifsc=new JTextArea(new String(result1.getString("IFSC")));
					txtifsc.setLocation(120, 300);
					txtifsc.setSize(130, 20);
					txtifsc.setEditable(false);
					txtifsc.setBackground(new Color(255,248,220));
					JTextArea txtupi=new JTextArea(new String(result1.getString("UPI")));
					txtupi.setLocation(120, 350);
					txtupi.setSize(130, 20);
					txtupi.setEditable(false);
					txtupi.setBackground(new Color(255,248,220));
					
					islink=true;
					
					panel1.add(txtname);
					panel1.add(txtemail);
					panel1.add(txtphn);
					panel1.add(txtbname);
					panel1.add(txtacc);
					panel1.add(txtifsc);
					panel1.add(txtupi);				
					panel1.add(name);
					panel1.add(email);
					panel1.add(phn);
					panel1.add(bname);
					panel1.add(accno);
					panel1.add(ifsc);
					panel1.add(upi);
					
					container.add(panel1);
				}
				else
				{
					JPanel panel1=new JPanel();
					panel1.setLocation(20, 40);
					panel1.setSize(260, 400);
					panel1.setBackground(new Color(255,248,220));
					panel1.setLayout(null);
					JLabel bname=new JLabel("Bank Name :");
					bname.setLocation(20, 60);
					bname.setSize(100, 15);
					bname.setForeground(Color.black);
					bname.setFont(new Font("",Font.BOLD,15));
					JLabel accno=new JLabel("Account No :");
					accno.setLocation(20, 120);
					accno.setSize(100, 15);
					accno.setForeground(Color.black);
					accno.setFont(new Font("",Font.BOLD,15));
					JLabel ifsc=new JLabel("IFSC No :");
					ifsc.setLocation(20, 180);
					ifsc.setSize(100, 15);
					ifsc.setForeground(Color.black);
					ifsc.setFont(new Font("",Font.BOLD,15));
					JLabel upi=new JLabel("UPI Id:");
					upi.setLocation(20, 240);
					upi.setSize(100, 15);
					upi.setForeground(Color.black);
					upi.setFont(new Font("",Font.BOLD,15));
//					
					String bankname[]= {"SBI","IPPB"};
					JComboBox<String> cbbank=new JComboBox<String>(bankname);
					cbbank.setLocation(120, 60);
					cbbank.setSize(130, 20);
					JTextField txtacc=new JTextField();
					txtacc.setLocation(120, 120);
					txtacc.setSize(130, 20);
					JTextField txtifsc=new JTextField();
					txtifsc.setLocation(120, 180);
					txtifsc.setSize(130, 20);
					JTextField txtupi=new JTextField();
					txtupi.setLocation(120, 240);
					txtupi.setSize(130, 20);
//					
					JButton submit=new JButton("Submit");
					submit.setLocation(20, 300);
					submit.setSize(220, 30);
					submit.setBackground(null);
					submit.addActionListener(
							new ActionListener() 
							{ 
								public void actionPerformed(ActionEvent e) 
								{ 
									try
									{
										//Connection String
//										String dburl="jdbc:ucanaccess://EcommDB.accdb";
										
										//connection
//										Connection conn=DriverManager.getConnection(dburl);
										Connection conn=MyCon.getConnection();
										
										//Sql Query Statement
										String sql1="SELECT Name,Email,Phone FROM Profile WHERE Email ='"+Main.id+"'";
										String sql2="INSERT INTO BankDetails(Name,Email,Phone,Bank,Account,IFSC,UPI) VALUES(?,?,?,?,?,?,?)";
										
										//Statement
										Statement statement1=conn.createStatement();
										PreparedStatement preparestatement=conn .prepareStatement(sql2);
										
										//to fetch value of Attributes
										ResultSet result1=statement1.executeQuery(sql1);
										
										if(result1.next())
										{
											preparestatement.setString(1, new String(result1.getString("Name")));
											preparestatement.setString(2, new String(result1.getString("Email")));
											preparestatement.setString(3, new String(result1.getString("Phone")));
											preparestatement.setString(4, new String(cbbank.getSelectedItem().toString()));
											preparestatement.setLong(5, Long.parseLong(txtacc.getText()));
											preparestatement.setString(6, new String(txtifsc.getText()));
											preparestatement.setString(7, new String(txtupi.getText()));
										}
										int rows=preparestatement.executeUpdate();
										if(rows>0)
										{
											JOptionPane.showMessageDialog(frame, "Submited","E-Kart",JOptionPane.PLAIN_MESSAGE);
										}
										//Connection close
										conn.close();
									}
									catch(Exception err)
									{
										err.printStackTrace();
										JOptionPane.showMessageDialog(frame, "Please try again","E-Kart",JOptionPane.PLAIN_MESSAGE);
									}
								}
							}
						);
					
					panel1.add(bname);
					panel1.add(accno);
					panel1.add(ifsc);
					panel1.add(upi);
					panel1.add(cbbank);
					panel1.add(txtacc);
					panel1.add(txtifsc);
					panel1.add(txtupi);
					panel1.add(submit);
					container.add(panel1);
				}
				
				//Connection close
				conn.close();
			}
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(frame, "Please try again","E-Kart",JOptionPane.PLAIN_MESSAGE);
			}

		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Please Sign Up First","E-Kart",JOptionPane.OK_OPTION);
			new FrameLoginSignup();
		}
		
		
		
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
