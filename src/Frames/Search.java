package Frames;


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
import javax.swing.JComboBox;


public class Search implements ActionListener {
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
	JButton btsearch;
	
	//Panel
	JPanel panelbottommenu=new JPanel();
	JPanel panelbody=new JPanel();
	JPanel panelcotent=new JPanel();

	// Container
	JPanel container=new JPanel();
	String srch[]= {"Mobiles","Laptops","Electronics","MensWear","WomensWear","KidsWear","Watches","Shoes"};
	JComboBox<String> cbsearch=new JComboBox<String>(srch);
	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbkart=new JLabel("E-Kart");
	
	
	Search()
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

		
		frame.getContentPane().setBackground(new Color(133,199,197));
		frame.setSize(325, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private void container()
	{
		JLabel text,lbimg;
		
		container=new JPanel();
		container.setLocation(5, 5);
		container.setSize(300, 50);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		text=new JLabel("Search :");
		text.setLocation(20, 5);
		text.setSize(60, 30);
		text.setForeground(Color.black);
		text.setFont(new Font("",Font.BOLD,15));
		cbsearch.setLocation(80, 10);
		cbsearch.setSize(150, 20);
		imgicon=new ImageIcon("./logo/searchlogo.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btsearch=new JButton(imgicon);
		btsearch.setLocation(235, 10);
		btsearch.setSize(20, 20);
		btsearch.addActionListener(this);
		container.add(text);
		container.add(cbsearch);
		container.add(btsearch);
		panelcotent.add(container);
		
		container=new JPanel();
		container.setLocation(5, 60);
		container.setSize(300, 200);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/homepic2.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(25, 70);
		lbimg.setSize(250, 100);
		text=new JLabel("Be Safe ,Wear Mask ");
		text.setLocation(50, 20);
		text.setSize(200,40);
		text.setForeground(Color.black);
		text.setFont(text.getFont().deriveFont(17.0f));
		container.add(lbimg);
		container.add(text);
		panelcotent.add(container);
		
		container=new JPanel();
		container.setLocation(5, 265);
		container.setSize(300, 300);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/card.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(50, 60);
		lbimg.setSize(200, 200);
		text=new JLabel("Do Payment on Single Tap");
		text.setLocation(40, 10);
		text.setSize(250,40);
		text.setForeground(Color.black);
		text.setFont(text.getFont().deriveFont(17.0f));
		container.add(lbimg);
		container.add(text);
		panelcotent.add(container);
		
	}
	
	
	private void scrollpane()
	{

		container();

		
		panelcotent.setLocation(0, 30);
		panelcotent.setPreferredSize(new Dimension(300, 600));
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
		
		if(e.getSource()==btsearch)
		{
			new List(cbsearch.getSelectedItem().toString());
			frame.dispose();
		}
	}

}
