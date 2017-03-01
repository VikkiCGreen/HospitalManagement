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



class Background extends JPanel
{
	double width,height;
	JLabel jl;
	int i;
	Background()
	{
		setLayout(null);
	setWidthHeight(100,200);
	
	}
	void setWidthHeight(double a,double b)
	{
		
		
		final String im[]={"i1","i2","i3"};
		
		width=a;
		height=b;
		setLayout(null);
		
		jl=new JLabel();
		jl.setBounds(0,0,1500,800);
		add(jl);
		//System.out.println("k2");
		
		
		
		new Thread(new Runnable()
		{
			public void run()
			{
				while(true)
				{
		//	System.out.println("k1");
					try
					{
					Thread.sleep(1000);				
					}
					catch(Exception e)
					{
						
					}
	
						jl.setIcon(new ImageIcon("E://images//"+im[i]+".jpg"));
						i++;
						if((i==im.length))
						{
							i=0;
						}
				
						
						try
						{
						Thread.sleep(2000);				
						}
						catch(Exception e)
						{
							
						}
						
						
						
				}
			}
		}).start();
		
		
	}
	
	
	
}
class Home extends JFrame implements ActionListener,KeyListener,TableModelListener,MouseListener
{
	HomePanel jp=null;
	TabPan1 tp=null;
	Background b=null;
	Register reg=null;
	Generation gen=null;
	 Connection connection=null;
	 Statement stmt=null;
	 int f=0,l=0;
	 String m="",n="";
	 int j=0;
	Home()
	{
		connection= SqliteConnection.dbConnector();
		this.setTitle("Hospital Management System");
		jp=new HomePanel();
		
		jp.b1.addActionListener(this);
		jp.b2.addActionListener(this);
		jp.b3.addActionListener(this);
		jp.b1.addKeyListener(this);
		jp.b2.addKeyListener(this);
		jp.b3.addKeyListener(this);
		
		tp=new TabPan1();
		tp.setBounds(0,0,1500,1000);
		//tp.b1.addActionListener(this);
		//tp.b2.addActionListener(this);
		tp.setVisible(false);
		
		jp.setBounds(0,0,1500,1000);
		jp.setVisible(false);
		
		b=new Background();
			b.setBounds(0,0,1500,800);
			b.setVisible(true);
			add(b);
			b.addMouseListener(this);
			
			reg=new Register("MY REGI");
		    reg.setBounds(0,0,1500,1000);
			reg.b1.addActionListener(this);
			reg.b2.addActionListener(this);
			reg.b1.addKeyListener(this);
			reg.b2.addKeyListener(this);
			reg.setVisible(false);
			
			gen=new Generation("");
			gen.setBounds(0,0,1500,1000);
			//gen.b1.addActionListener(this);
			gen.setVisible(false);
		
		gen.jb1.addActionListener(this);
		gen.jb1.addKeyListener(this);
		tp.a.b1.addActionListener(this);
			 
			
		
		add(jp);
		add(tp);
		add(reg);
		add(gen);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		b.setVisible(false);
		jp.setVisible(true);
		
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String s=ae.getActionCommand();
		 shortcut(s);
		 }	 
		 void shortcut(String s)
		 {
			 int f5=0;
			 if(s.equals("Login"))
			 {
				 String uname=jp.tf1.getText();
				 String pass=jp.tf2.getText();
				 if(uname.equalsIgnoreCase("admin"))
				 {
					 if(pass.equalsIgnoreCase("admin"))
					 {
						 jp.setVisible(false);
						 b.setVisible(false);
						 tp.setVisible(true); 
					 }
					 else
					 {
						 jp.pl.setVisible(true);
			 			   jp.ul.setVisible(false);
					 }
				 }
				 else
				 {
					 jp.pl.setVisible(false);
		 			   jp.ul.setVisible(true);
				 }
			 
			
			 }
			 else if(s.equalsIgnoreCase("close"))
			 {
				 System.exit(0);
			 }
			 else if(s.equalsIgnoreCase("ok"))
			 {
				 jp.setVisible(true);
				 reg.setVisible(false);
				 gen.setVisible(false); 
				 
			 }
			 else if(s.equalsIgnoreCase("Cancel"))
			 {
				 jp.setVisible(true);
				 reg.setVisible(false);
				 
			 }
			 else if (s.equals("Sign Up"))
			 {
				 jp.setVisible(false);
				 b.setVisible(false);
				 reg.setVisible(true);
			 }
			 else if(s.equalsIgnoreCase("Schedule"))
			 {
				 System.out.println("Hello");
				 try
				 {
					 System.out.println("Hello");
					 String doctor=tp.a.cdo.getSelectedItem();
					 System.out.println(doctor);
					 String sql = "UPDATE PATIENT SET Doctor='"+tp.a.cdo.getSelectedItem()+"',Date='"+tp.a.c1.getSelectedItem()+"-"+tp.a.c2.getSelectedItem()+"-"+tp.a.c3.getSelectedItem()+"',Time='"+tp.a.c4.getSelectedItem()+"',Reason='"+tp.a.c5.getSelectedItem()+"' where PID='"+tp.a.cid.getSelectedItem()+"'"; 
						stmt= connection.createStatement();
						stmt.executeUpdate(sql);
						 System.out.println("World");
						stmt.close();
						
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			 }
			 else if (s.equals("Register"))
			 {
				 m=reg.tf2.getText();
				 n=reg.tf1.getText();
					
				 if(m.length()<10 || m.length()>10)
				 {
					 reg.val4.setVisible(true);
					 reg.val5.setVisible(false);
					 reg.val1.setVisible(false);
					 reg.val2.setVisible(false);
					 reg.val3.setVisible(false);
					 f5=1;
					 
				 }
				 else
				 {
					 for(int i=0;i<m.length();i++)
					 {
						int a=(m.charAt(i));
						// System.out.println(a);
						if(a<48 || a>57)
						{  
							reg.val4.setVisible(false);
							 reg.val5.setVisible(true);
							 reg.val1.setVisible(false);
							 reg.val2.setVisible(false);
							 reg.val3.setVisible(false);
						//	 gen.setVisible(false);
							 f5=1;
						}
						
					 

				     }
				    }
				 if(reg.tf1.getText().length()<3)
				 {
					 reg.val1.setVisible(true);
					 reg.val4.setVisible(false);
					 reg.val5.setVisible(false);
					 reg.val2.setVisible(false);
					 reg.val3.setVisible(false);
					 f5=1;
				    
				 }
				 else
				 {
					 for(int i=0;i<n.length();i++)
					 {
						int a=(n.charAt(i));
						// System.out.println(a);
						if(a>=48 && a<=57)
						{  
							reg.val4.setVisible(false);
							 reg.val5.setVisible(false);
							 reg.val1.setVisible(false);
							 reg.val2.setVisible(true);
							 reg.val3.setVisible(false);
						//	 gen.setVisible(false);
							 f5=1;
						}
						
					 

				     }
				 }
				 int j;
				 try
				 {
					 String msg1="";
			         int i=0;
			         if(f5==0)
			         {
			        	 reg.val1.setVisible(false);
			        	 reg.val2.setVisible(false);
			        	 reg.val3.setVisible(false);
			        	 reg.val4.setVisible(false);
			        	 reg.val5.setVisible(false);
			        	 try
			       	  {
			       		   msg1=reg.tf1.getText().substring(0,3);
			       	  }
			        	 catch(Exception e)
			       	  {
			       		  reg.val1.setVisible(true);
			       	  } 
			        	 String s2=reg.c2.getSelectedItem();
			    	     // System.out.println(s2);
						String msg2=reg.c2.getSelectedItem()+msg1+reg.c3.getSelectedItem();
						//System.out.println("user:"+msg1);
						//System.out.println("user:"+msg2);
						gen.username1.setText(msg1);
						gen.password1.setText(msg2);
						String sql = "INSERT INTO REGISTER(NAME,DOB,ADDRESS,GENDER,CNO,TYPE,UNAME,PASSWORD) VALUES(?,?,?,?,?,?,?,?)"; 
						PreparedStatement pst= connection.prepareStatement(sql);
						pst.setString(1,reg.tf1.getText());
						pst.setString(2,reg.c2.getSelectedItem()+reg.c1.getSelectedItem()+reg.c3.getSelectedItem());
						pst.setString(3,reg.ta.getText() );
						pst.setString(4, reg.cbg.getSelectedCheckbox().getLabel());
					    pst.setString(5, reg.tf2.getText());
					    pst.setString(6,reg.cbg1.getSelectedCheckbox().getLabel());
					    pst.setString(7, msg1);
					    pst.setString(8, msg2);
						
				     pst.execute();
				     pst.close();
				     reg.tf1.setText("");
				     reg.ta.setText("");
				     reg.tf2.setText("");
				     
			         reg.setVisible(false);
			   		 jp.setVisible(false);
			   		 gen.setVisible(true);
				    
				     System.out.println("hi"); 
			         }
					
				        
				    
				  		
				  	
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
					
				 }
			 }
			
		
	}
	
}



class TabPan1 extends JPanel implements ActionListener,KeyListener
{
	JTabbedPane jtp1=null;
	Appt a=null;
	Patient p=null;
	Doctor d=null;
	
	TabPan1()
	{
		setLayout(null);
		jtp1=new JTabbedPane();
		a=new Appt();
		p=new Patient();
		d=new Doctor();
		jtp1.setBounds(0,0,1500,1000);
		a.setBounds(0,0,1500,1000);
		p.setBounds(0,0,1500,1000);
		jtp1.addTab("SCHEDULE APPOINTMENT",a);
		jtp1.addTab("PATIENT INFO",p);
		jtp1.addTab("DOCTOR APPOINTMENTS",d);
		add(jtp1);
	}
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
            System.exit(0);
		
	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

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
		l3=new JLabel("Name:");l3.setFont(f);
		cno.setFont(f);
		tf2=new JTextField(50);
		l3.setBounds(50,50,75,75);
		tf1=new JTextField(50);
		tf1.setBounds(150,75,200,35);
		
		l4=new JLabel("DOB:");l4.setFont(f);
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
		l5=new JLabel("Address:");l5.setFont(f);
		l5.setBounds(50,220,75,75);
		ta=new JTextArea();
		jsp=new JScrollPane(ta);
		jsp.setBounds(155,220,200,125);
		
		
		
		
		l6=new JLabel("Gender:");l6.setFont(f);
		l6.setBounds(50,350,75,75);
		cbg=new CheckboxGroup();
		m=new Checkbox("Male",cbg,true);m.setFont(f2);
		m.setBounds(150,350,80,80);
		fm=new Checkbox("Female",cbg,false);fm.setFont(f2);
		fm.setBounds(250,350,80,80);
		cbg1=new CheckboxGroup();
		doc=new Checkbox("Doctor",cbg1,true);doc.setFont(f2);
		doc.setBounds(160,500,80,80);
		staff=new Checkbox("Staff",cbg1,false);staff.setFont(f2);
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
		add(l3); add(l4);   add(l5);                                                                                                                                          
		add(c3); add(tf1); add(c1); add(c2);
		add(l6);add(m);add(fm);add(age);add(store);
		add(jsp);add(cno);
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
		
		c1.add("jan"); c1.add("feb"); c1.add("march"); c1.add("april");
		c1.add("may"); c1.add("june"); c1.add("july"); c1.add("aug");
		c1.add("sept"); c1.add("oct"); c1.add("nov"); c1.add("dec");
		
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

class Appt extends JPanel implements KeyListener, ItemListener
{
	JLabel id,name,age,cno,title,pname,page,doctor,doa,toa,rov;
	Choice cid,cdo,c1,c2,c3,c4,c5;
	JButton b1,b2;
	 Connection connection=null;
	 Statement stmt=null,stmt1=null,stmt2=null;
	
	Font f,f1,f2;
	BufferedImage image,image1;
	String a,b,c;
	Appt()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		f=new Font("Arial",Font.PLAIN,28);
		f1=new Font("Arial",Font.PLAIN,25);
		f2=new Font("Arial",Font.PLAIN,18);
		connection= SqliteConnection.dbConnector();
		
		
		title=new JLabel("SCHEDULE APPOINTMENT");
		title.setBounds(540, 5, 400, 40);title.setFont(f);title.setForeground(Color.BLUE);
		add(title);
		
		id=new JLabel("Patient Id:");
		id.setBounds(50,50,200,50);id.setFont(f1);
		add(id);
		
		name=new JLabel("Patient Name:");
		name.setBounds(50,150,200,50);name.setFont(f1);
		add(name);
		
		age=new JLabel("Patient Age:");
		age.setBounds(50,250,200,50);age.setFont(f1);
		add(age);
		
		doctor=new JLabel("Doctor:");
		doctor.setBounds(50,350,200,50); doctor.setFont(f1);
		add(doctor);
		
		doa=new JLabel("Date:");
		doa.setBounds(50,440,200,50); doa.setFont(f1);
		add(doa);
		
		toa=new JLabel("Time:");
		toa.setBounds(660,440,100,50); toa.setFont(f1);
		add(toa);
		
		rov=new JLabel("Reason of Visit:");
		rov.setBounds(50,500,200,50);
		rov.setFont(f1);
		add(rov);
		
		/*
		reset=new JButton("Reset");
		reset.setBounds(175, 350, 200,40);reset.setFont(f);
		add(reset);
		
		id1=new JTextField();
		id1.setBounds(300,60,200,40);
		add(id1);
		*/
		cid=new Choice();
		cid.setBounds(300,55,150,40);cid.setFont(f1);
		add(cid);
		
		pname=new JLabel("Name");
		pname.setBounds(300,155,200,40);pname.setFont(f1);
		add(pname);
		
		page=new JLabel("Age");
	page.setBounds(300,255,200,40);page.setFont(f1);
		add(page);
		
		cdo=new Choice();
		cdo.setBounds(300,355,150,40);cdo.setFont(f1);
		add(cdo);
		
		c1=new Choice();
		c1.setBounds(300,455,100,30);
		c2=new Choice();
		c2.setBounds(410,455,100,30);
		c3=new Choice();
		c3.setBounds(520,455,100,30);
		c4=new Choice();
		c5=new Choice();
		c5.setBounds(300,510,200,100);
		c4.setBounds(770,455,200,50);
		c1.setFont(f2);
		c2.setFont(f2);
		c3.setFont(f2);
		c4.setFont(f2);
		c5.setFont(f2);
		
		
		b1=new JButton("Schedule");
		b1.setBounds(50,580,200,50);
		b1.setFont(f1);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBounds(300,580,200,50);
		b2.setFont(f1);
		add(b2);
		
		
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		
		
		
		cid.addItemListener(this);
		c1.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		cdo.addItemListener(this);
		c5.addItemListener(this);
		c1.add("Jan");
		c1.add("Feb"); 
		c1.add("March");
		c1.add("April");
		c1.add("May");
		c1.add("June");
		c1.add("July");
		c1.add("Aug");
		c1.add("Sept");
		c1.add("Oct"); 
		c1.add("Nov"); 
		c1.add("Dec");
		
		c4.add("10:00"); 
		c4.add("11:00"); 
		c4.add("12:00"); 
		c4.add("13:00");
		c4.add("14:00");
		c4.add("15:00");
		c4.add("16:00");
		c4.add("17:00");
		
		c5.add("General Consultation");
		c5.add("Surgery-related");
		c5.add("Critical");
		
		
		
		for(int i=2017;i<=2020;i++)
		{
			c3.add(""+i);
		}
		try
		{
			stmt=connection.createStatement();
			stmt2=connection.createStatement();
			ResultSet rs=stmt.executeQuery("Select PID from PATIENT;");
			ResultSet rs2=stmt2.executeQuery("select NAME from REGISTER where TYPE='Doctor'");
			while(rs.next())
			{
				int pid=rs.getInt("PID");
				cid.add(""+pid);
				
			}
			while(rs2.next())
			{
				String dname=rs2.getString("NAME");
				cdo.add(""+dname);
				
			}
			rs.close();
			stmt.close();
			rs2.close();
			stmt2.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		cid.select(0);
		try
		{
			int pid=Integer.parseInt(cid.getSelectedItem());
			//System.out.println(""+pid);
			stmt1=connection.createStatement();
			ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE from PATIENT where PID='"+cid.getSelectedItem()+"'");
			System.out.println(""+pid);
			while(rs2.next())
			{
			String  name = rs2.getString(1);
			System.out.println(name);
	         String age  = rs2.getString(2);
	         System.out.println(""+age);
	         pname.setText(name);
	         page.setText(""+age);
			}
			
	        rs2.close();
				stmt1.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

cid.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
				
				int pid=Integer.parseInt(cid.getSelectedItem());
				//System.out.println(""+pid);
				try
				{
					System.out.println("hi");
					stmt1=connection.createStatement();
					ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE from PATIENT where PID='"+cid.getSelectedItem()+"'");
					while(rs2.next())
					{
					System.out.println(""+pid);
					String  name = rs2.getString(1);
					System.out.println(name);
			         String age  = rs2.getString(2);
			        System.out.println(""+age);
			         pname.setText(name);
			         page.setText(""+age);
					}
			        rs2.close();
						stmt1.close();
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				}
		});
	}
		
		public void itemStateChanged(ItemEvent ie) {
			
			
		    int val1=Integer.parseInt(c3.getSelectedItem());
			String val=c1.getSelectedItem();
			
			
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
	



	
	
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}



	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		String msg=ke.getKeyCode()+"";
	
	}



	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
class Doctor extends JPanel implements ItemListener
{
	JLabel dname,cno,dcno,title;
	Font f,f1,f2;
	Choice c1;
	Connection connection=null;
	Statement stmt=null;
	Doctor()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		connection= SqliteConnection.dbConnector();
		f=new Font("Arial",Font.PLAIN,28);
		f1=new Font("Arial",Font.PLAIN,25);
		f2=new Font("Arial",Font.PLAIN,18);
		title=new JLabel("DOCTOR APPOINTMENTS");
		title.setBounds(540, 5, 400, 40);title.setFont(f);title.setForeground(Color.BLUE);
		add(title);
		
		dname=new JLabel("Doctor:");
		dname.setBounds(50,50,200,50);dname.setFont(f1);
		add(dname);
		
		c1=new Choice();
		c1.setBounds(260,50,200,50);
		c1.setFont(f1);
		add(c1);
		
		cno=new JLabel("Contact Number:");
		cno.setBounds(50,100,200,50);cno.setFont(f1);
		add(cno);
		
		dcno=new JLabel("Contact");
		dcno.setBounds(260,100,200,50);
		dcno.setFont(f1);
		add(dcno);
	}
	
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
class Patient extends JPanel implements ItemListener
{
	JLabel id,name,age,cno,title,pname,page,doctor,doa,toa,rov,pdoctor,pdoa,ptoa,prov,pcno,upa;
	Choice cid;
	
	 Connection connection=null;
	 Statement stmt=null,stmt1=null;
	
	Font f,f1,f2;
	BufferedImage image,image1;
	
	Patient()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		f=new Font("Arial",Font.PLAIN,28);
		f1=new Font("Arial",Font.PLAIN,25);
		f2=new Font("Arial",Font.PLAIN,18);
		connection= SqliteConnection.dbConnector();
		
		
		title=new JLabel("PATIENT HISTORY");
		title.setBounds(540, 5, 400, 40);title.setFont(f);title.setForeground(Color.BLUE);
		add(title);
		
		id=new JLabel("Patient Id:");
		id.setBounds(50,50,200,50);id.setFont(f1);
		add(id);
		
		name=new JLabel("Patient Name:");
		name.setBounds(50,100,200,50);name.setFont(f1);
		add(name);
		
		age=new JLabel("Patient Age:");
		age.setBounds(50,150,200,50);age.setFont(f1);
		add(age);
		
		cno=new JLabel("Contact No:");
		cno.setBounds(50,200,200,50); cno.setFont(f1);
		add(cno);
		
		upa=new JLabel("Upcoming Appointment");
		upa.setBounds(50,250,300,50); upa.setFont(f1);
		add(upa);
		
		doctor=new JLabel("Doctor:");
		doctor.setBounds(50,300,200,50); doctor.setFont(f1);
		add(doctor);
		
		doa=new JLabel("Date:");
		doa.setBounds(50,350,200,50); doa.setFont(f1);
		add(doa);
		
		toa=new JLabel("Time:");
		toa.setBounds(50,400,100,50); toa.setFont(f1);
		add(toa);
		
		rov=new JLabel("Reason of Visit:");
		rov.setBounds(50,450,200,50);
		rov.setFont(f1);
		add(rov);
		
		/*
		reset=new JButton("Reset");
		reset.setBounds(175, 350, 200,40);reset.setFont(f);
		add(reset);
		
		id1=new JTextField();
		id1.setBounds(300,60,200,40);
		add(id1);
		*/
		cid=new Choice();
		cid.setBounds(300,55,150,40);cid.setFont(f1);
		add(cid);
		
		pname=new JLabel("Name");
		pname.setBounds(300,105,200,40);pname.setFont(f1);
		add(pname);
		
		page=new JLabel("Age");
	page.setBounds(300,155,200,40);page.setFont(f1);
		add(page);
		
		pcno=new JLabel("Patient Contact");
		pcno.setBounds(300,205,300,40);
		pcno.setFont(f1);
		add(pcno);
		
	    pdoctor=new JLabel("Doctor Name:");
		pdoctor.setBounds(300,300,200,50); pdoctor.setFont(f1);
		add(pdoctor);
		
		pdoa=new JLabel("Date:");
		pdoa.setBounds(300,350,300,50); pdoa.setFont(f1);
		add(pdoa);
		
		ptoa=new JLabel("Time:");
		ptoa.setBounds(300,400,100,50); ptoa.setFont(f1);
		add(ptoa);
		
		prov=new JLabel("Reason of Visit:");
		prov.setBounds(300,450,300,50);
		prov.setFont(f1);
		add(prov);
		
		
		
		
		
		
		
		
		try
		{
			stmt=connection.createStatement();
			
			ResultSet rs=stmt.executeQuery("Select PID from PATIENT;");
			
			while(rs.next())
			{
				int pid=rs.getInt("PID");
				cid.add(""+pid);
				
			}
			
			rs.close();
			stmt.close();
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		cid.select(0);
		try
		{
			int pid=Integer.parseInt(cid.getSelectedItem());
			//System.out.println(""+pid);
			stmt1=connection.createStatement();
			ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE,CNO,DOCTOR,DATE,TIME,REASON from PATIENT where PID='"+cid.getSelectedItem()+"'");
			System.out.println(""+pid);
			while(rs2.next())
			{
			String  name = rs2.getString(1);
			System.out.println(name);
	         String age  = rs2.getString(2);
	         System.out.println(""+age);
	         String cno= rs2.getString(3);
	         System.out.println(""+cno);
	         
	         String doctor=rs2.getString(4);
	         String date=rs2.getString(5);
	         String time=rs2.getString(6);
	         String reason=rs2.getString(7);
	         
	         pname.setText(name);
	         page.setText(""+age);
	         pcno.setText(""+cno);
	         pdoctor.setText(doctor);
	         pdoa.setText(date);
	         ptoa.setText(time);
	         prov.setText(reason);
	         
	         
			}
			
	        rs2.close();
				stmt1.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

cid.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
				try
				{
					int pid=Integer.parseInt(cid.getSelectedItem());
					stmt1=connection.createStatement();
					ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE,CNO,DOCTOR,DATE,TIME,REASON from PATIENT where PID='"+cid.getSelectedItem()+"'");
					System.out.println(""+pid);
					while(rs2.next())
					{
					String  name = rs2.getString(1);
					System.out.println(name);
			         String age  = rs2.getString(2);
			         System.out.println(""+age);
			         String cno= rs2.getString(3);
			         String doctor=rs2.getString(4);
			         String date=rs2.getString(5);
			         String time=rs2.getString(6);
			         String reason=rs2.getString(7);
			         
			         pname.setText(name);
			         page.setText(""+age);
			         pcno.setText(""+cno);
			         pdoctor.setText(doctor);
			         pdoa.setText(date);
			         ptoa.setText(time);
			         prov.setText(reason);
			         
			         
					}
					
			        rs2.close();
						stmt1.close();
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				}
		});

	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
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
	 b1.setFont(f2); b2.setFont(f2);

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
class Generation extends JPanel
{
	JLabel username,hlabel;
	JLabel password;
	JLabel username1;
	JLabel password1;
	Register reg1;
	JButton jb1;
	Font f,f1;
	private BufferedImage image,image1;

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
public class Project2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home h=new Home();
		h.setVisible(true);
		h.setSize(1500,1000);
		
		
	}
	}



