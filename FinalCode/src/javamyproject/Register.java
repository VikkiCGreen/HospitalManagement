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



class Register extends JPanel implements ItemListener
{
	
	private BufferedImage image,image1;
	JLabel l3,l4,l6,l5,l7,age,store,val1,val2,val3,val4,val5,cno,stype;
	JButton b1,b2;
	JTextField tf1,tf2;
	JTextArea ta;
	Font f,f1,f2,f3;
	Choice c1,c2,c3,c4;
	Checkbox m,fm,ch1,ch2,ch3,doc,staff;
	CheckboxGroup cbg,cbg1;
	static String forag,msg;
	JScrollPane jsp;
	//BufferedImage image;
   	
	Register(String s)
	{
		
		//this.settitle("HOSPITAL MANAGEMENT SYSTEM");
		setLayout(null);
		try {     
		    image = ImageIO.read(new File("E:\\images\\i5.jpg"));
		    
		 } catch (IOException ex) {       }

		f=new Font("Arial",Font.BOLD,16);
		f1=new Font("Arial",Font.BOLD,30);
		f2=new Font("Arial",Font.PLAIN,16);
		f3=new Font("Arial",Font.PLAIN,25);
		cno=new JLabel("Contact_No:");
		
		
		store=new JLabel("NEW USER REGISTRATION");
		store.setBounds(480,0,450,50);
		store.setFont(f1);
		store.setForeground(Color.blue);
		l3=new JLabel("Name:");
		l3.setFont(f);
		cno.setFont(f);
		tf2=new JTextField(50);
		l3.setBounds(50,50,75,75);
		tf1=new JTextField(50);
		tf1.setBounds(150,75,200,35);
		
		l4=new JLabel("DOB:");
		l4.setFont(f);
		l4.setBounds(50,135,75,75);
		
		c1=new Choice();
		c1.setBounds(150,160,100,30);
		c2=new Choice();
		c2.setBounds(260,160,100,30);
		c3=new Choice();
		c3.setBounds(370,160,100,30);
		
		jsp=new JScrollPane(ta);
		add(jsp);
		
		
		
		age=new JLabel("Age:");
		age.setBounds(500,120,100,100);
		age.setVisible(false);
		l5=new JLabel("Address:");
		l5.setFont(f);
		l5.setBounds(50,220,75,75);
		ta=new JTextArea();
		jsp=new JScrollPane(ta);
		jsp.setBounds(155,220,200,125);
		
		
		
		
		l6=new JLabel("Gender:");
		l6.setFont(f);
		l6.setBounds(50,350,75,75);
		cbg=new CheckboxGroup();
		m=new Checkbox("Male",cbg,true);
		m.setFont(f2);
		m.setBounds(150,350,80,80);
		fm=new Checkbox("Female",cbg,false);
		fm.setFont(f2);
		fm.setBounds(250,350,80,80);
		cbg1=new CheckboxGroup();
		doc=new Checkbox("Doctor",cbg1,true);
		doc.setFont(f2);
		doc.setBounds(160,500,80,80);
		staff=new Checkbox("Staff",cbg1,false);
		staff.setFont(f2);
		staff.setBounds(260,500,80,80);
		add(doc);
		add(staff);
		
		stype=new JLabel("Staff Type:");
		stype.setBounds(50, 500, 100, 75);
		stype.setFont(f);
		add(stype);
		
		
		
		
		val3=new JLabel("Please enter address");
		val3.setForeground(Color.RED);
		val3.setBounds(370,220,200,50);
		val3.setVisible(false);
		add(val3);
		
		val4=new JLabel("Please enter 10 digits");
		val4.setForeground(Color.RED);
		val4.setBounds(320,420,200,100);
		val4.setVisible(false);
		add(val4);
		
		val5=new JLabel("Please enter numerical data only");
		val5.setForeground(Color.RED);
		val5.setBounds(320,420,200,100);
		val5.setVisible(false);
		add(val5);
		
		val1=new JLabel("Please enter min three character in name field");
		val1.setBounds(350,50,300,100);
		add(val1);
		val1.setVisible(false);
		cno.setBounds(50,430,100,75);
		tf2.setBounds(150,457,150,20);
		
		val2=new JLabel("Numeric data not allowed");
		val2.setBounds(350,50,300,100);
		val1.setForeground(Color.RED);
		val2.setForeground(Color.RED);
		add(val2);
		val2.setVisible(false);
		add(l3); 
		add(l4);  
		add(l5);                                                                                                                                          
		add(c3);
		add(tf1);
		add(c1);
		add(c2);
		add(l6);
		add(m);
		add(fm);
		add(age);
		add(store);
		add(jsp);
		add(cno);
		add(tf2);
		
		//c2.addItemListener(this);
		
		/*for(int i=1;i<=31;i++)
		{
			c2.add(""+i);
		}*/
		b1=new JButton("Register");
		 b1.setBounds(150,600,150,40);
		 b1.setFont(f3);
		 
		 add(b1);
		
		 b2=new JButton("Cancel");
		 b2.setBounds(350,600,150,40);
		 b2.setFont(f3);
		 
		 add(b2);
		 
		c1.addItemListener(this);
		c3.addItemListener(this);
		
		c1.add("jan"); 
		c1.add("feb"); 
		c1.add("march");
		c1.add("april");
		c1.add("may");
		c1.add("june");
		c1.add("july");
		c1.add("aug");
		c1.add("sept");
		c1.add("oct"); 
		c1.add("nov"); 
		c1.add("dec");
		
		for(int i=1965;i<=2017;i++)
		{
			c3.add(""+i);
		}
		
		c3.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
				age.setVisible(true);
				final int xxx;
				int yy=Calendar.getInstance().get(Calendar.YEAR);
				xxx=yy-Integer.parseInt(c3.getSelectedItem().toString());
				age.setText("Age : "+xxx);
				forag=age.getText().substring(6, 8);
				}
		});
		

	}
	/*protected void paintComponent(Graphics g) {
		  
		  
		   setBackground(Color.WHITE);
		   g.drawImage(image,700,100,null);
		  
	}*/
	
	protected void paintComponent(Graphics g) {
		  
		   super.paintComponent(g);
		   g.drawImage(image,650,100,650,375,null);
		   
		  }
	

	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		
		
		int val1=Integer.parseInt(c3.getSelectedItem());
		String val=c1.getSelectedItem();
		
		System.out.println("Check entring");
		if(val.equalsIgnoreCase("jan") || val.equalsIgnoreCase("march") || val.equalsIgnoreCase("may") || 
				val.equalsIgnoreCase("july") || val.equalsIgnoreCase("aug") || val.equalsIgnoreCase("oct") ||
				val.equalsIgnoreCase("dec"))
		{   
			
			for(int i=1;i<=31;i++)
			{
				c2.add(""+i);
			}
		}
		else if(val1%4==0 && val.equalsIgnoreCase("feb") )
		{
						
			System.out.println("LEAP");
				for(int i=1;i<=29;i++)
				{
				c2.add(""+i);
				}
	
		}
		else if(val1%4!=0 && val.equalsIgnoreCase("feb"))
		{
			
			
			System.out.println("Not LEAP");
				for(int i=1;i<=28;i++)
				{
				c2.add(""+i);
				}
		}
		else 
		{ 
			
			for(int i=1;i<=30;i++)
			{
				c2.add(""+i);
			}
		}
	}
}
