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
import javax.swing.JTextArea;

import com.connection.MyCon;


public class Product implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");

	//Image
	ImageIcon imgicon;
	Image img,newimg;

	// Container
	JPanel container=new JPanel();
	JLabel prdbrand,prdname,prdprice,prdimg;
	JButton prdbuy;
	JTextArea txtbrand,txtname,txtprice,txtdesc;
	
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

	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbkart=new JLabel("E-Kart");
	JLabel lbbrand=new JLabel("Brand :");
	JLabel lbname=new JLabel("Name :");
	JLabel lbprice=new JLabel("Price :");
	JLabel lbdesc=new JLabel("Description :");
	
	private int item=0;
	
	Product(String table,String index)
	{

		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of ScrollPane
		scrollpane(table,index);
		
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

		
		frame.getContentPane().setBackground(new Color(133,199,197));
		frame.setSize(325, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private int container(String table,String prdid)
	{
		
		String imgstr=null,prd=null;
		try
		{
			//Connection String
//			String dburl="jdbc:ucanaccess://EcommDB.accdb";
			
			//connection
//			Connection conn=DriverManager.getConnection(dburl);
			Connection conn=MyCon.getConnection();
			
			//Sql Query Statement
			String sql="SELECT * FROM "+table+" WHERE Product_Id='"+prdid+"'";
			
			//Statement
			Statement statement=conn.createStatement();
			
			//to fetch value of Attributes
			ResultSet result=statement.executeQuery(sql);
			if(result.next())
			{
				
				txtbrand=new JTextArea(result.getString("Brand"));
				txtname=new JTextArea(result.getString("Name"));
				txtprice=new JTextArea(result.getString("Price"));
				txtdesc=new JTextArea(result.getString("Description"));
				imgstr=result.getString("Picture");
				
			}
			
			//Connection close
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		
		
		container=new JPanel();
		container.setLocation(5,5);
		container.setSize(300, 490);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		
		imgicon=new ImageIcon(imgstr);
		float h=imgicon.getIconHeight();
		float w=imgicon.getIconWidth();
		Float ph,pw;
		if(h>w)
		{
			ph=1.0f;
			pw=(w/h);
		}
		else if(w>h)
		{
			pw=1.0f;
			ph=(h/w);
		}
		else
		{
			ph=1.0f;
			pw=1.0f;
		}
		Float nh=(150*ph);
		Float nw=(150*pw);
		img=imgicon.getImage();
		newimg=img.getScaledInstance(nw.intValue(),nh.intValue(), Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		prdimg=new JLabel(imgicon);
		prdimg.setName(prd);
		prdimg.setLocation(65, 10);
		prdimg.setSize(150,150);
		prdimg.setBackground(Color.WHITE);
		
		lbbrand.setLocation(10, 250);
		lbbrand.setSize(100,30);
		lbbrand.setForeground(Color.black);
		lbbrand.setFont(new Font("",Font.BOLD,15));
		lbbrand.setBackground(new Color(255,248,220));
		txtbrand.setLocation(120, 250);
		txtbrand.setSize(150,30);
		txtbrand.setEditable(false);
		txtbrand.setBackground(new Color(255,248,220));
		
		lbname.setLocation(10, 290);
		lbname.setSize(100,30);
		lbname.setForeground(Color.black);
		lbname.setFont(new Font("",Font.BOLD,15));
		lbname.setBackground(new Color(255,248,220));
		txtname.setLocation(120, 290);
		txtname.setSize(150,30);
		txtname.setEditable(false);
		txtname.setBackground(new Color(255,248,220));
		
		lbprice.setLocation(10, 330);
		lbprice.setSize(100,30);
		lbprice.setForeground(Color.black);
		lbprice.setFont(new Font("",Font.BOLD,15));
		lbprice.setBackground(new Color(255,248,220));
		txtprice.setLocation(120, 330);
		txtprice.setSize(150,30);
		txtprice.setEditable(false);
		txtprice.setBackground(new Color(255,248,220));
		
		lbdesc.setLocation(10, 375);
		lbdesc.setSize(100,15);
		lbdesc.setForeground(Color.black);
		lbdesc.setFont(new Font("",Font.BOLD,15));
		lbdesc.setBackground(new Color(255,248,220));
		txtdesc.setLocation(120, 375);
		txtdesc.setSize(150,50);
		txtdesc.setEditable(false);
		txtdesc.setBackground(new Color(255,248,220));
		txtdesc.setLineWrap(true);
		
		prdbuy=new JButton("BUY NOW");
		prdbuy.setLocation(30, 450);
		prdbuy.setSize(220,30);
		prdbuy.setForeground(Color.black);
		prdbuy.setBackground(new Color(225,105,0));
		prdbuy.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { buy(table,prdid); frame.dispose();}});
		
		container.add(prdimg);
		container.add(lbbrand);
		container.add(lbname);
		container.add(lbprice);
		container.add(lbdesc);
		container.add(txtbrand);
		container.add(txtname);
		container.add(txtprice);
		container.add(txtdesc);
		container.add(prdbuy);



		panelcotent.add(container);
		return 490;
	}
	
	
	private void scrollpane(String table,String prdid)
	{

		int y=container(table,prdid);
		
		panelcotent.setLocation(0, 30);
		panelcotent.setPreferredSize(new Dimension(300, y));
		panelcotent.setBackground(new Color(255,248,220));
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
		lbkart.setForeground(Color.black);
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
	
	private void buy(String table,String prdid)
	{
		if(item<3)
		{
			if(Main.isloggedin() && Epay.islink)
			{
				try
				{
					//Connection String
//					String dburl="jdbc:ucanaccess://EcommDB.accdb";
					
					//connection
//					Connection conn=DriverManager.getConnection(dburl);
					Connection conn=MyCon.getConnection();
					
					//Sql Query Statement
					String sql1="SELECT Customer_id,Name,Email,Password,Address,City,State,Country FROM Profile WHERE Email ='"+Main.id+"'";
					String sql2="SELECT Product_Id,Brand,Name,Price,Description,Picture FROM "+table+" WHERE Product_Id='"+prdid+"'";
					String sql3="INSERT INTO OrderList(Customer_id,Name,Email,Address,Product_Id,Brand,Product_Name,Price,Description,Picture) Values(?,?,?,?,?,?,?,?,?,?)";
					
					//Statement
					Statement statement1=conn.createStatement();
					Statement statement2=conn.createStatement();
					PreparedStatement preparestatement=conn .prepareStatement(sql3);
					
					//to fetch value of Attributes
					ResultSet result1=statement1.executeQuery(sql1);
					ResultSet result2=statement2.executeQuery(sql2);
					if(result1.next() && result2.next())
					{
						String str,pass1=null,pass2;
						pass1=JOptionPane.showInputDialog(frame, "Enter Password for Payment Confirmation", "E-Kart", JOptionPane.OK_OPTION);
						pass2=result1.getString("Password");
						int check=pass1.compareTo(pass2);
						if(check==0)
						{
							str=result1.getString("Customer_id");
							preparestatement.setString(1, str);
							str=result1.getString("Name");
							preparestatement.setString(2, str);
							str=result1.getString("Email");
							preparestatement.setString(3, str);
							str= result1.getString("Address")+","+result1.getString("City")+","+result1.getString("State")+","+result1.getString("Country");
							preparestatement.setString(4,str);
							str=result2.getString("Product_Id");
							preparestatement.setString(5, str);
							str=result2.getString("Brand");
							preparestatement.setString(6, str);
							str=result2.getString("Name");
							preparestatement.setString(7, str);
							str=result2.getString("Price");
							preparestatement.setString(8, str);
							str=result2.getString("Description");
							preparestatement.setString(9, str);
							str=result2.getString("Picture");
							preparestatement.setString(10, str);
							item++;
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Password Incorrect","E-Kart",JOptionPane.ERROR_MESSAGE);
						}
						
					}
					int rows=preparestatement.executeUpdate();
					if(rows>0)
					{
						JOptionPane.showMessageDialog(frame, "Order Placed","E-Kart",JOptionPane.PLAIN_MESSAGE);
					}
					//Connection close
					conn.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Order not placed","E-Kart",JOptionPane.ERROR_MESSAGE);					
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Please Sign Up First","E-Kart",JOptionPane.OK_OPTION);
				new FrameLoginSignup();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Cart Full","E-Kart",JOptionPane.WARNING_MESSAGE);
		}		
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
