package Frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Signup implements ActionListener {
	
	//Frame object
	JFrame frame=new JFrame("E-Kart");
	
	//Image
	ImageIcon imgicon;
	Image img,newimg;
	
	//Button
	JButton btcancel;
	JButton btsignup=new JButton("Sign up");
	
	//Panel
	JPanel panelbody=new JPanel();
	JPanel panelform=new JPanel();
	
	//Labels
	JLabel lbsingup=new JLabel("SIGN UP");
	JLabel lbname=new JLabel("Name :");
	JLabel lbemail=new JLabel("Email id :");
	JLabel lbphn=new JLabel("Phone No :");
	JLabel lbpass=new JLabel("Password :");
	JLabel lbdob=new JLabel("DOB :");
	JLabel lbadd=new JLabel("Address :");
	JLabel lbcity=new JLabel("City :");
	JLabel lbstate=new JLabel("State :");
	JLabel lbcountry=new JLabel("Country :");
	
	//TextField(textbox)
	JTextField tfname=new JTextField();
	JTextField tfemail=new JTextField();
	JTextField tfphn=new JTextField();
	JTextField tfadd=new JTextField();
	
	//PasswordField
	JPasswordField pfpass=new JPasswordField();
	
	//ComboBox
	String phonecode[]= {"091"};
	final JComboBox<String> cbphn=new JComboBox<String>(phonecode);
	String date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
			"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};	
	final JComboBox<String> cbdate=new JComboBox<String>(date);
	String month[]= {"Jan","Feb","March","April","May","Jun","Jully","Aug","Sept","Octo","Nov","Dec"};
	final JComboBox<String> cbmonth=new JComboBox<String>(month);
	String year[]= {"2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993"};
	final JComboBox<String> cbyear=new JComboBox<String>(year);	
	String city[]= {"Mumbai","Delhi","Bangalore","Hyderabad","Ahmedabad","Chennai","Kolkata","Surat","Pune","Jaipur"};
	JComboBox<String> cbcity=new JComboBox<String>(city);
	String state[]= {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand",
			"Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim",
			"Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"," ","Andaman and Nicobar Island","Chandigarh",
			"Dadra and Nagar Haveli and Daman and Diu","Delhi","Ladakh","Lakshadweep","Jammu and Kashmir","Puducherry"};
	JComboBox<String> cbstate=new JComboBox<String>(state);
	String country[]= {"India"};
	JComboBox<String> cbcountry=new JComboBox<String>(country);
	

	
	Signup()
	{
		
		//Function for setting the properties of Panel
		setpanel();
		
		//Function for setting the properties of Button
		setbutton();

		//Function for setting the properties of Label
		setlabel();

		//Function for setting the properties of Textfield
		settextfield();
		
		//Function for setting the properties of Textfield
		setcombobox();
		
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
		
		panelform.add(tfname);
		panelform.add(tfemail);
		panelform.add(pfpass);
		panelform.add(cbphn);
		panelform.add(tfphn);
		panelform.add(cbdate);
		panelform.add(cbmonth);
		panelform.add(cbyear);
		panelform.add(tfadd);
		panelform.add(cbcity);
		panelform.add(cbstate);
		panelform.add(cbcountry);
		panelform.add(lbsingup);
		panelform.add(lbname);
		panelform.add(lbemail);
		panelform.add(lbphn);
		panelform.add(lbpass);
		panelform.add(lbdob);
		panelform.add(lbadd);
		panelform.add(lbcity);
		panelform.add(lbstate);
		panelform.add(lbcountry);
		panelform.add(btsignup);
	}

	private void frameadd()
	{

		frame.add(panelform);
		frame.add(panelbody);
		frame.add(btcancel);
	}
	
	private void setlabel()
	{
		
		lbsingup.setLocation(85, 10);
		lbsingup.setSize(200, 30);
		lbsingup.setFont(lbsingup.getFont().deriveFont(25.0f));
		lbsingup.setForeground(Color.black);
		
		lbname.setLocation(10, 70);
		lbname.setSize(80,15);
		lbname.setFont(lbname.getFont().deriveFont(15.0f));
		lbname.setForeground(Color.black);
		
		lbemail.setLocation(10, 110);
		lbemail.setSize(80,15);
		lbemail.setFont(lbemail.getFont().deriveFont(15.0f));
		lbemail.setForeground(Color.black);
		
		lbphn.setLocation(10, 150);
		lbphn.setSize(80,15);
		lbphn.setFont(lbphn.getFont().deriveFont(15.0f));
		lbphn.setForeground(Color.black);
		
		lbpass.setLocation(10, 190);
		lbpass.setSize(80,15);
		lbpass.setFont(lbpass.getFont().deriveFont(15.0f));
		lbpass.setForeground(Color.black);
		
		lbdob.setLocation(10, 230);
		lbdob.setSize(80,15);
		lbdob.setFont(lbdob.getFont().deriveFont(15.0f));
		lbdob.setForeground(Color.black);
		
		lbadd.setLocation(10, 270);
		lbadd.setSize(80,15);
		lbadd.setFont(lbadd.getFont().deriveFont(15.0f));
		lbadd.setForeground(Color.black);
		
		lbcity.setLocation(10, 310);
		lbcity.setSize(80,15);
		lbcity.setFont(lbcity.getFont().deriveFont(15.0f));
		lbcity.setForeground(Color.black);
		
		lbstate.setLocation(10, 350);
		lbstate.setSize(80,15);
		lbstate.setFont(lbstate.getFont().deriveFont(15.0f));
		lbstate.setForeground(Color.black);
		
		lbcountry.setLocation(10, 390);
		lbcountry.setSize(80,15);
		lbcountry.setFont(lbcountry.getFont().deriveFont(15.0f));
		lbcountry.setForeground(Color.black);
		
	}
	
	private void settextfield()
	{
		tfname.setLocation(100, 65);
		tfname.setSize(170, 25);
		
		tfemail.setLocation(100, 105);
		tfemail.setSize(170, 25);		
		
		pfpass.setLocation(100, 185);
		pfpass.setSize(170, 25);
		
		tfphn.setLocation(155, 145);
		tfphn.setSize(115, 25);
		
		tfadd.setLocation(100, 265);
		tfadd.setSize(170, 25);
		
	}
	
	private void setcombobox()
	{
		cbphn.setLocation(100, 145);
		cbphn.setSize(50, 25);
		
		cbdate.setLocation(100, 225);
		cbdate.setSize(50, 25);
		
		cbmonth.setLocation(155, 225);
		cbmonth.setSize(50, 25);
		
		cbyear.setLocation(210, 225);
		cbyear.setSize(50, 25);
		
		cbcity.setLocation(100, 305);
		cbcity.setSize(170, 25);
		cbcity.setEditable(true);
		
		cbstate.setLocation(100, 345);
		cbstate.setSize(170, 25);
		
		cbcountry.setLocation(100, 385);
		cbcountry.setSize(170, 25);
	}
	
	private void setbutton()
	{
		imgicon=new ImageIcon("./logo/back.jpg");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(30,30, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		btcancel=new JButton(imgicon);
		btcancel.setLocation(0, 0);
		btcancel.setSize(50, 30);
		btcancel.setBackground(new Color(25,25,25));
		btcancel.addActionListener(this);
		btcancel.setBorder(null);

		btsignup.setLocation(10,423);
		btsignup.setSize(260,35);
		btsignup.setBackground(new Color(245,245,245));
		btsignup.setForeground(Color.black);
		btsignup.setFont(btcancel.getFont().deriveFont(20.0f));
		btsignup.setBorderPainted(true);
		btsignup.addActionListener(this);
		btsignup.setVisible(true);
		
	}
	
	private void setpanel()
	{

		panelbody.setLocation(0, 30);
		panelbody.setSize(320, 550);
		panelbody.setBackground(Color.darkGray);
		panelbody.setLayout(null);
		
		panelform.setLocation(15, 65);
		panelform.setSize(280, 470);
		panelform.setLayout(null);
				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btcancel)
		{
			new Home();
			frame.dispose();
		}
		if(e.getSource()==btsignup)
		{
			try
			{				
				String str;
				User user=new User();
				
				str=tfname.getText();
				user.setUserName(str);
				str=tfemail.getText();
				user.setUserEmail(str);
				str=tfphn.getText();
				user.setUserPhone(str);
				str=new String(pfpass.getPassword());
				user.setUserPassword(str);
				str=cbdate.getSelectedItem().toString();
				str=str+"/"+cbmonth.getSelectedItem().toString();
				str=str+"/"+cbyear.getSelectedItem().toString();
				user.setUserDob(str);
				str=tfadd.getText();
				user.setUserAddress(str);
				str=cbcity.getSelectedItem().toString();
				user.setUserCity(str);
				str=cbstate.getSelectedItem().toString();
				user.setUserState(str);
				str=cbcountry.getSelectedItem().toString();
				user.setUserCountry(str);
				
				if(user.insertUserData())
				{
					new Home();
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(frame, "Already a Customer","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(frame, "Something Went Wrong !","ERROR",JOptionPane.WARNING_MESSAGE);
			}		
		}
	}		
}
