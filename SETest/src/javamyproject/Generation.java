package javamyproject;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.sqlite.SQLiteConnection;



class Generation extends JPanel
{
	JLabel username,hlabel;
	JLabel password;
	JLabel username1;
	JLabel password1;
	Register reg1;
	JButton jb1;
	Font f,f1;
	private BufferedImage image;

	 Generation(String s)
	 {
		 reg1=new Register("");
		 this.setTitle("Username-Password Generation");
		 setLayout(null);
		 
		 f=new Font("Arial",Font.PLAIN,18);
		 f1=new Font("Arial",Font.BOLD,30);
		 setFont(f);
		 setFont(f1);
		 
		hlabel=new JLabel("CONGRATULATIONS!");
		hlabel.setBounds(480,0,450,50);
		hlabel.setFont(f1);
		hlabel.setForeground(Color.BLUE);
		add(hlabel);
		// reg1.password();
		 username=new JLabel("User Name:");
		 username.setBounds(50, 20, 150, 50);username.setFont(f);
		 
		 username1=new JLabel();
		// username1.setText("c_"+reg1.msg1);
		 username1.setBounds(175, 20, 150, 50);username1.setFont(f);
		 jb1=new JButton("OK");
		 jb1.setBounds(200,200,70,30);
		 jb1.setFont(f);
		 
		 add(jb1);
		//username1=new JLabel("c_"+reg1.msg1);
		
		 password1=new JLabel();
		 password=new JLabel("Password:");
		 password.setBounds(50, 80, 150, 50);password.setFont(f);
		// password1=new JLabel(""+reg1.msg2);
		
		// password1.setText(""+reg1.msg2);
		 password1.setBounds(175, 80, 150, 50);password1.setFont(f);
		 
		 
		 add(username); add(password); add(username1); add(password1);
		 try {     
			    image = ImageIO.read(new File("E:\\images\\i5.jpg"));
			    
			 } catch (IOException ex) {       }
		
			}
private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
protected void paintComponent(Graphics g) {
	  
	   super.paintComponent(g);
	   g.drawImage(image,650,100,650,375,null);
	   
	  }

}