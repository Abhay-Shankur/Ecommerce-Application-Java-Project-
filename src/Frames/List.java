package Frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.connection.MyCon;

import javax.swing.JScrollPane;


public class List implements ActionListener {
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
	JButton btoffer,btmobile,btfashion,btelectronics,btappliances;
	
	//Panel
	JPanel panelbottommenu=new JPanel();
	JPanel panelbody=new JPanel();
	JPanel paneltopmenu=new JPanel();
	JPanel panelcotent=new JPanel();

	// Container
	JPanel container=new JPanel();
	JLabel prdbrand,prdname,prdprice;
	JTextArea txtbrand,txtname,txtprice,txtdesc;
	JButton btimg;
	HashMap <Integer,JPanel> panelcontainer=new HashMap <Integer,JPanel>();
	ArrayList<String> items=new ArrayList<String>();
	ArrayList<Integer> prdid=new ArrayList<Integer>();
	int index=0;
	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbkart=new JLabel("E-Kart");
	
	
	List(String category)
	{
		
		productlist(category);
		
		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of ScrollPane
		scrollpane(category);
		
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

	private void productlist(String category)
	{
		
		try
		{
			//Connection String
//			String dburl="jdbc:ucanaccess://EcommDB.accdb";
//			
//			//connection
//			Connection conn=DriverManager.getConnection(dburl);
			Connection conn=MyCon.getConnection();
			
			//Sql Query Statement
			String sql="SELECT Product_Id FROM "+category;
			
			//Statement
			Statement statement=conn.createStatement();
			
			//to fetch value of Attributes
			ResultSet result=statement.executeQuery(sql);
			
			while(result.next())
			{
				int id=result.getInt("Product_Id");
				prdid.add(index,id);
				index++;
			}
			
			//Connection close
			conn.close();
		}
		catch(Exception e)
		{
			
		}
			
	}
	

	private int container(String category)
	{
		String imgstr=null,prd=null;
		int x=5,y=65;
		for(int i=0;i<index;i++)
		{
			try
			{
//				//Connection String
//				String dburl="jdbc:ucanaccess://EcommDB.accdb";
//				
//				//connection
//				Connection conn=DriverManager.getConnection(dburl);
				Connection conn=MyCon.getConnection();
				
				//Sql Query Statement
				String sql="SELECT * FROM "+category+" WHERE Product_Id="+prdid.get(i);
				
				//Statement
				Statement statement=conn.createStatement();
				
				//to fetch value of Attributes
				ResultSet result=statement.executeQuery(sql);
				if(result.next())
				{
					this.txtbrand=new JTextArea(result.getString("Brand"));
					this.txtname=new JTextArea(result.getString("Name"));
					this.txtprice=new JTextArea(result.getString("Price"));
					imgstr=result.getString("Picture");
					prd=result.getString("Product_Id");
				}
				
				//Connection close
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			container=new JPanel();
			container.setLocation(x, y);
			container.setSize(280, 100);
			container.setBackground(new Color(255,248,220));	//cornsilk
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
			Float nh=(80*ph);
			Float nw=(80*pw);
			img=imgicon.getImage();
			newimg=img.getScaledInstance(nw.intValue(),nh.intValue(), Image.SCALE_SMOOTH);
			imgicon=new ImageIcon(newimg);
			btimg=new JButton(imgicon);
			btimg.setName(prd);
			btimg.setLocation(10, 10);
			btimg.setSize(80,80);
			btimg.setBackground(Color.WHITE);
			final String id=prd;
			btimg.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { new Product(category,id);frame.dispose();}});
			
			txtbrand.setLocation(100, 10);
			txtbrand.setSize(200,15);
			txtbrand.setEditable(false);
			txtbrand.setBackground(new Color(255,248,220));
			
			txtname.setLocation(100, 40);
			txtname.setSize(200,15);
			txtname.setEditable(false);
			txtname.setBackground(new Color(255,248,220));
			
			txtprice.setLocation(100, 70);
			txtprice.setSize(200,15);
			txtprice.setEditable(false);
			txtprice.setBackground(new Color(255,248,220));
			
			container.add(btimg);
			container.add(txtbrand);
			container.add(txtname);
			container.add(txtprice);
			panelcontainer.put(i, container);
			y=y+105;
		}
		return y;
	}
	
	
	private void scrollpane(String category)
	{

		int y=container(category);
		panelcotent.add(paneltopmenu);
		for(int i=0;i<index;i++)
		{
			panelcotent.add(panelcontainer.get(i));
		}
		
		
		panelcotent.setLocation(0, 30);
		panelcotent.setPreferredSize(new Dimension(300, y));
		panelcotent.setBackground(new Color(225,105,0));	//orange
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
 		
 		paneltopmenu.add(btoffer);
 		paneltopmenu.add(btmobile);
 		paneltopmenu.add(btfashion);
 		paneltopmenu.add(btelectronics);
 		paneltopmenu.add(btappliances);
 		
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
					
		paneltopmenu.setLocation(0, 0);
		paneltopmenu.setSize(310,60);
		paneltopmenu.setBackground(Color.white);
		paneltopmenu.setLayout(null);
		
		panelbottommenu.setLocation(0, 530);
		panelbottommenu.setSize(310, 30);
		panelbottommenu.setBackground(Color.white);
		panelbottommenu.setLayout(null);
	}
		
	private void setbutton()
	{
		//Top menu	
		imgicon=new ImageIcon("./logo/offer.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btoffer=new JButton(imgicon);
		btoffer.setLocation(0, 0);
		btoffer.setSize(55, 60);
		btoffer.setBackground(Color.white);
		btoffer.setBorderPainted(false);
		btoffer.addActionListener(this);
		
		imgicon=new ImageIcon("./logo/mobileslogo.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btmobile=new JButton(imgicon);
		btmobile.setLocation(60, 0);
		btmobile.setSize(55, 60);
		btmobile.setBackground(Color.white);
		btmobile.setBorderPainted(false);
		btmobile.addActionListener(this);
		
		imgicon=new ImageIcon("./logo/fashionlogo.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btfashion=new JButton(imgicon);
		btfashion.setLocation(120, 0);
		btfashion.setSize(55, 60);
		btfashion.setBackground(Color.white);
		btfashion.setBorderPainted(false);
		btfashion.addActionListener(this);
		
		imgicon=new ImageIcon("./logo/electroniclogo.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btelectronics=new JButton(imgicon);
		btelectronics.setLocation(180, 0);
		btelectronics.setSize(55, 60);
		btelectronics.setBackground(Color.white);
		btelectronics.setBorderPainted(false);
		btelectronics.addActionListener(this);
		
		imgicon=new ImageIcon("./logo/applianceslogo.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btappliances=new JButton(imgicon);
		btappliances.setLocation(240, 0);
		btappliances.setSize(55, 60);
		btappliances.setBackground(Color.white);
		btappliances.setBorderPainted(false);
		btappliances.addActionListener(this);
		
		
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
		if(e.getSource()==btoffer)
		{
			new List("Offer");
			frame.dispose();
		}
		if(e.getSource()==btmobile)
		{
			new List("Mobiles");
			frame.dispose();
		}
		if(e.getSource()==btfashion)
		{
			new List("WomensWear");
			frame.dispose();
		}
		if(e.getSource()==btelectronics)
		{
			new List("Laptops");
			frame.dispose();
		}
		if(e.getSource()==btappliances)
		{
			new List("Electronics");
			frame.dispose();
		}
		
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
