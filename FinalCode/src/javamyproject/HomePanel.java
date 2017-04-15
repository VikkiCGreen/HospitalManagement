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


class HomePanel extends JPanel
{
	private BufferedImage image,image1;
	Font f,f1,f2,f3;
	JLabel lab;
	JLabel lab1,lab2,lab3,pl,ul;
	JTextField  tf1;
	JPasswordField tf2;
	JButton b1,b2,b3;
	JLabel head;

		HomePanel()
		{
	    setLayout(null);	

	f=new Font("Arial",Font.BOLD,16);
	f1=new Font("Arial",Font.BOLD,30);
	f2=new Font("Arial",Font.PLAIN,25);	
	f3=new Font("Arial",Font.BOLD,16);

	setFont(f);

	lab=new JLabel("Enter UserName");
	 lab1=new JLabel("Enter Password");
	 lab2=new JLabel("Are you a new user?");
	
	 tf1=new JTextField(50);
	 tf2=new JPasswordField(30);
	 tf1.setText("");
	 tf2.setText("");
	 head=new JLabel("WELCOME");
		head.setBounds(525,0,350,50);
		
		head.setFont(f1);
		head.setForeground(Color.BLUE);
		lab.setFont(f);
		lab1.setFont(f);
		lab2.setFont(f3);
	 
	 
	 
	 b1=new JButton("Login");
	 b2=new JButton("Close");
	 b3=new JButton("Sign Up");
	 lab.setBounds(50,50,170,50);
	 lab1.setBounds(50,105,170,50);
	 lab2.setBounds(150,280,170,40);
	 
	 
	 add(lab);
	 add(lab1);
	 add(lab2);
	 add(head);
	
	 

	 add(b3);
	 tf1.setBounds(230,60,180,30);
	 tf2.setBounds(230,115,180,30);
	 b1.setFont(f2); 
	 b2.setFont(f2);
	 b3.setFont(f2);

	 
	 b1.setBounds(230,200,120,40);
	 b2.setBounds(380,200,120,40);
	 b3.setBounds(320,280,130,40);
	add(tf1);
	 add(tf2);
	 add(b1);
	add(b2);
	add(b3);

	ul=new JLabel("INVALID USERNAME");
	pl=new JLabel("USERNAME PASSWORD NOT MATCHED");
	ul.setBounds(420,50,250,50);
	pl.setBounds(420,105,300,50);
	add(ul);
	add(pl);

	Font f9=new Font("Arial",Font.BOLD,12);
	ul.setFont(f9);
	ul.setForeground(Color.red);
	pl.setFont(f9);
	pl.setForeground(Color.red);
	pl.setVisible(false);
	ul.setVisible(false);

try {     
    image = ImageIO.read(new File("E:\\images\\i5.jpg"));
    
 } catch (IOException ex) {       }
	
}
		
		protected void paintComponent(Graphics g) {
			  
			   super.paintComponent(g);
			   g.drawImage(image,650,100,650,375,null);
			   
			  }

}
