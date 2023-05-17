package com.files;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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


public class List {
	//Frame object
	JFrame frame;

	//Image
	ImageIcon imgicon;
	Image img,newimg;

	//Panel
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
	
	List(JFrame frame) {
		this.frame=frame;
	}
	
	public JPanel getList(String category) {
		productlist(category);
		
		int y=container(category);
		for(int i=0;i<index;i++)
		{
			panelcotent.add(panelcontainer.get(i));
		}
		
		panelcotent.setLocation(0, 90);
		panelcotent.setPreferredSize(new Dimension(300, y));
		panelcotent.setBackground(new Color(225,105,0));	//orange
		panelcotent.setLayout(null);
		return panelcotent;
	}
	private void productlist(String category)
	{
		
		try
		{
			//connection
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
			e.printStackTrace();
		}
			
	}
	

	private int container(String category)
	{
		String imgstr=null,prd=null;
		int x=5,y=5;
		for(int i=0;i<index;i++)
		{
			try
			{
				//connection
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
			btimg.addActionListener(
					new ActionListener() { 
						public void actionPerformed(ActionEvent e) { 
							new Product(category,id);frame.dispose();
						}
					}
				);
			
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
	
}
