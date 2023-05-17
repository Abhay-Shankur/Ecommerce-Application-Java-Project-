package Frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Login implements ActionListener {
	//Frame object
	JFrame frame=new JFrame("E-Kart");
	
	//Image
	ImageIcon imgicon;
	Image img,newimg;
	
	//Button
	JButton btcancel=new JButton("<");
	JButton btlogin=new JButton("Log In");
			
	//Panel
	JPanel panelbody=new JPanel();
	JPanel panelform=new JPanel();
	
	//Labels
	JLabel lblogin=new JLabel("LOG IN");
	JLabel lbemail;
	JLabel lbpass;
	
	//TextField(textbox)
	JTextField tfemail=new JTextField();
	
	//PasswordField
	JPasswordField pfpass=new JPasswordField();
	
	//Checkbox
	JCheckBox cbshowpass=new JCheckBox("Show Password");
	
 	Login()
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
		
//		frame.setIconImage(createNewImageIcon());
		frame.getContentPane().setBackground(new Color(25,25,25));
		frame.setSize(325, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
 	private void paneladd()
 	{
	
 		panelform.add(lblogin);
 		panelform.add(lbemail);
 		panelform.add(lbpass);
 		panelform.add(tfemail);
 		panelform.add(pfpass);
 		panelform.add(cbshowpass);
 		panelform.add(cbshowpass);
 		panelform.add(btlogin);
 	}
 	
	private void frameadd()
	{

		frame.add(btcancel);
		frame.add(panelform);
		frame.add(panelbody);
		
	}
	
	private void setlabel()
	{
		lblogin.setLocation(90, 40);
		lblogin.setSize(200, 30);
		lblogin.setFont(lblogin.getFont().deriveFont(25.0f));
		lblogin.setForeground(Color.black);
		
		imgicon=new ImageIcon("./logo/user.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbemail=new JLabel(imgicon);
		lbemail.setLocation(40, 145);
		lbemail.setSize(25,25);
		lbemail.setFont(lbemail.getFont().deriveFont(15.0f));
		lbemail.setForeground(Color.black);
		
		imgicon=new ImageIcon("./logo/password.png");
		img=imgicon.getImage();
		newimg=img.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		imgicon=new ImageIcon(newimg);
		lbpass=new JLabel(imgicon);
		lbpass.setLocation(40, 195);
		lbpass.setSize(25,25);
		lbpass.setFont(lbpass.getFont().deriveFont(15.0f));
		lbpass.setForeground(Color.black);
		
	}
	
	private void settextfield()
	{
		tfemail.setLocation(75, 145);
		tfemail.setSize(170, 25);		
		
		pfpass.setLocation(75, 195);
		pfpass.setSize(170, 25);
		
		cbshowpass.setLocation(70,220);
		cbshowpass.setSize(150, 20);
		cbshowpass.addActionListener(this);
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

		btlogin.setLocation(10, 300);
		btlogin.setSize(255,35);
		btlogin.setBackground(new Color(245,245,245));
		btlogin.setForeground(Color.black);
		btlogin.setFont(btlogin.getFont().deriveFont(20.0f));
		btlogin.setBorderPainted(true);
		btlogin.addActionListener(this);

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
			try
			{
				String str;
				int check;
				User user=new User();
				
				str=tfemail.getText();
				user.retrieveUserData(str);
				check=str.compareTo(user.getUserEmail());
				if(check==0)
				{
					str=new String(pfpass.getPassword());
					check=str.compareTo(user.getUserPassword());
					if(check==0)
					{					
						try
						{
							File file=new File("UserData.txt");
							if(file.createNewFile())
							{
								FileWriter filewrite=new FileWriter("UserData.txt");
								filewrite.write(tfemail.getText());
								filewrite.write("\n"+new String(pfpass.getPassword()));
								filewrite.close();
								new Home();
								frame.dispose();
							}
							else
								throw new IOException("Log in Failed ! Please Re-Try Log in");						
						}
						catch(IOException err)
						{
							JOptionPane.showMessageDialog(frame, "Couldn't Log In","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(frame, "Incorrect Password","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(frame, "Incorrect Email Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(frame, "Something Went Wrong !","ERROR",JOptionPane.WARNING_MESSAGE);
			}			
		}
		if(e.getSource()==cbshowpass)
		{
			if(cbshowpass.isSelected())
			{
				pfpass.setEchoChar((char)0);
			}
			else
			{
				pfpass.setEchoChar('*');
			}
		}
	}		
}
