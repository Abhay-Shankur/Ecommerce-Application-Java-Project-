package Frames;

import java.io.File;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;


public class Profile implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");
	
	//Image
	ImageIcon imgicon;
	Image img,newimg;
	
	//Button
	JButton home;
	JButton search;
	JButton profile;
	JButton cart;
	JButton more;	
	JButton signin=new JButton("Please Sign In");
	
	//TextArea
	JTextArea txtname,txtemail,txtphone,txtdob,txtadd;
	
	//Panel
	JPanel panelbottommenu=new JPanel();
	JPanel panelbody=new JPanel();
	JPanel panelprofile=new JPanel();
	

	// Container
	JPanel container=new JPanel();
	HashMap <Integer,JPanel> panelcontainer=new HashMap <Integer,JPanel>();
	
	//Scroll pane
	JScrollPane scrollpanebody=new JScrollPane();
	
	//Label 
	JLabel lbimg;
	JLabel lbkart=new JLabel("E-Kart");
	JLabel lbname=new JLabel("Name :");
	JLabel lbemail=new JLabel("Email :");
	JLabel lbphone=new JLabel("Phone :");
	JLabel lbdob=new JLabel("DOB :");
	JLabel lbadd=new JLabel("Address :");
	
	
	Profile()
	{

		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of ScrollPane
		scrollpane();
		
		//Function for setting the properties of Button
		setbutton();
		
		//Function for setting the properties of Label
		setlabel();

		//Function for setting the properties of TextArea
		settextarea();
		
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
	
	private void scrollpane()
	{


	
	}
	
 	private void paneladd()
 	{
 		panelbottommenu.add(home);
 		panelbottommenu.add(search);
 		panelbottommenu.add(profile);
 		panelbottommenu.add(cart);
 		panelbottommenu.add(more);
 		
 		panelbody.add(panelprofile);
 		
 		File file=new File("UserData.txt");
		if(file.exists())
		{
			panelprofile.add(lbimg);
	 		panelprofile.add(lbname);
	 		panelprofile.add(lbemail);
	 		panelprofile.add(lbphone);
	 		panelprofile.add(lbdob);
	 		panelprofile.add(lbadd);
	 		panelprofile.add(txtname);
	 		panelprofile.add(txtemail);
	 		panelprofile.add(txtphone);
	 		panelprofile.add(txtdob);
	 		panelprofile.add(txtadd);
		}
		else
		{
			panelprofile.add(signin);
		}
 		
 	}
 	
	private void frameadd()
	{
		frame.add(lbkart);
		frame.add(panelbottommenu);
		frame.add(panelbody);
	}
	
	private void setlabel()
	{		
		imgicon=new ImageIcon("./logo/profileimg.png");
		img=imgicon.getImage();
		Image newimg=img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbimg=new JLabel(imgicon);
		lbimg.setLocation(65,10);
		lbimg.setSize(140, 140);
		lbimg.setBackground(new Color(255,248,220));
		
		lbkart.setLocation(120, 0);
		lbkart.setSize(100, 30);
		lbkart.setForeground(Color.black);
		lbkart.setFont(lbkart.getFont().deriveFont(17.0f));
		
		lbname.setLocation(30, 170);
		lbname.setSize(100, 30);
		lbname.setForeground(Color.black);
		lbname.setFont(lbname.getFont().deriveFont(15.0f));

		lbemail.setLocation(30, 220);
		lbemail.setSize(100, 30);
		lbemail.setForeground(Color.black);
		lbemail.setFont(lbemail.getFont().deriveFont(15.0f));
		
		lbphone.setLocation(30,270);
		lbphone.setSize(100, 30);
		lbphone.setForeground(Color.black);
		lbphone.setFont(lbphone.getFont().deriveFont(15.0f));
		
		lbdob.setLocation(30, 320);
		lbdob.setSize(100, 30);
		lbdob.setForeground(Color.black);
		lbdob.setFont(lbdob.getFont().deriveFont(15.0f));
		
		lbadd.setLocation(30, 370);
		lbadd.setSize(100, 30);
		lbadd.setForeground(Color.black);
		lbadd.setFont(lbadd.getFont().deriveFont(15.0f));
	}
	
	private void settextarea()
	{
		String str=null;
		try
		{
			File file=new File("UserData.txt");
			if(file.exists())
			{
				Scanner read=new Scanner(file);
				if(read.hasNext())
				{
					str=read.nextLine();
				}
				read.close();
				

				User user=new User();
				user.retrieveUserData(str);		
				str=user.getUserName();
				txtname=new JTextArea(str);
				txtname.setLocation(120, 175);
				txtname.setSize(130, 20);
				txtname.setBackground(new Color(255,248,220));
				txtname.setForeground(Color.black);
				txtname.setFont(txtname.getFont().deriveFont(15.0f));
				txtname.setEditable(false);
				
				str=user.getUserEmail();
				txtemail=new JTextArea(str);
				txtemail.setLocation(120, 225);
				txtemail.setSize(130, 20);
				txtemail.setBackground(new Color(255,248,220));
				txtemail.setForeground(Color.black);
				txtemail.setFont(txtemail.getFont().deriveFont(15.0f));
				txtemail.setEditable(false);
				
				str=user.getUserPhone();
				txtphone=new JTextArea(str);
				txtphone.setLocation(120, 275);
				txtphone.setSize(130, 20);
				txtphone.setBackground(new Color(255,248,220));
				txtphone.setForeground(Color.black);
				txtphone.setFont(txtphone.getFont().deriveFont(15.0f));
				txtphone.setEditable(false);
				
				str=user.getUserDob();
				txtdob=new JTextArea(str);
				txtdob.setLocation(120, 320);
				txtdob.setSize(130, 20);
				txtdob.setBackground(new Color(255,248,220));
				txtdob.setForeground(Color.black);
				txtdob.setFont(txtdob.getFont().deriveFont(15.0f));
				txtdob.setEditable(false);
				
				str=user.getUserAddress()+","+user.getUserCity()+","+user.getUserCountry();
				txtadd=new JTextArea(str);
				txtadd.setLocation(120, 375);
				txtadd.setSize(130, 40);
				txtadd.setBackground(new Color(255,248,220));
				txtadd.setForeground(Color.black);
				txtadd.setFont(txtadd.getFont().deriveFont(15.0f));
				txtadd.setEditable(false);
				txtadd.setLineWrap(true);
				
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
	private void setpanel()
	{
		panelprofile.setLocation(20, 25);
		panelprofile.setSize(270,460);
		panelprofile.setBackground(new Color(255,248,220));
		panelprofile.setLayout(null);
		
		panelbody.setLocation(0, 30);
		panelbody.setSize(310, 500);
		panelbody.setBackground(new Color(225,105,0));
		panelbody.setLayout(null);

		
		panelbottommenu.setLocation(0, 530);
		panelbottommenu.setSize(310, 30);
		panelbottommenu.setBackground(Color.white);
		panelbottommenu.setLayout(null);
		

		
	}
		
	private void setbutton()
	{
		
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
		
		
		signin.setLocation(20, 220);
		signin.setSize(230, 30);
		signin.setFont(signin.getFont().deriveFont(15.0f));
		signin.setBackground(Color.LIGHT_GRAY);
		signin.setForeground(Color.BLACK);
		signin.setBorderPainted(false);
		signin.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { new FrameLoginSignup();frame.dispose();}});
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
