package Frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class Home implements ActionListener {
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
	HashMap <Integer,JPanel> panelcontainer=new HashMap <Integer,JPanel>();
	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbkart=new JLabel("E-Kart");
	
	
	Home()
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
		container.setLocation(5, 65);
		container.setSize(300, 100);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/homepic3.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(280,80, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(5, 0);
		lbimg.setSize(280, 100);
		container.add(lbimg);
		panelcontainer.put(0, container);	
			
		container=new JPanel();
		container.setLocation(5, 170);
		container.setSize(300, 200);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/homepic2.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(250, 130, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(25, 50);
		lbimg.setSize(250, 130);
		text=new JLabel("Be Safe ,Wear Mask ");
		text.setLocation(60, 5);
		text.setSize(200,40);
		text.setForeground(Color.black);
		text.setFont(text.getFont().deriveFont(17.0f));
		container.add(lbimg);
		container.add(text);
		panelcontainer.put(1, container);	
			
		container=new JPanel();
		container.setLocation(5, 375);
		container.setSize(300, 100);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/homepic1.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(280,80, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(5, 10);
		lbimg.setSize(280, 80);
		container.add(lbimg);
		panelcontainer.put(2, container);	
		
		container=new JPanel();
		container.setLocation(5, 480);
		container.setSize(300, 300);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/card.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(50, 70);
		lbimg.setSize(200, 200);
		text=new JLabel("Do Payment on Single Tap");
		text.setLocation(40, 15);
		text.setSize(250,40);
		text.setForeground(Color.black);
		text.setFont(text.getFont().deriveFont(17.0f));
		container.add(lbimg);
		container.add(text);
		panelcontainer.put(3, container);	
		
		container=new JPanel();
		container.setLocation(5, 785);
		container.setSize(300, 80);
		container.setBackground(new Color(255,248,220));
		container.setLayout(null);
		imgicon=new ImageIcon("./logo/eKartLogo.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(250, 70, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(25, 5);
		lbimg.setSize(250, 70);
		container.add(lbimg);
		panelcontainer.put(4, container);	
		
		panelcotent.add(paneltopmenu);
		panelcotent.add(panelcontainer.get(0));
		panelcotent.add(panelcontainer.get(1));
		panelcotent.add(panelcontainer.get(2));
		panelcotent.add(panelcontainer.get(3));
		panelcotent.add(panelcontainer.get(4));
		
	}
	
	
	private void scrollpane()
	{

		container();


		panelcotent.setLocation(0, 30);
		panelcotent.setPreferredSize(new Dimension(300, 870));
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
			new List("mobiles");
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
