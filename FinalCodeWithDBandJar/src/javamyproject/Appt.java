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

class Appt extends JPanel implements KeyListener, ItemListener
{
	JLabel id,name,age,cno,title,pname,page,doctor,doa,toa,rov,success;
	Choice cid,cdo,c1,c2,c3,c4,c5;
	JButton b1,b2;
	Connection connection=null;
	Statement stmt=null,stmt1=null,stmt2=null;
	
	Font f,f1,f2;
	BufferedImage image;
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
		title.setBounds(540, 5, 400, 40);
		title.setFont(f);
		title.setForeground(Color.BLUE);
		add(title);
		
		id=new JLabel("Patient Id:");
		id.setBounds(50,50,200,50);
		id.setFont(f1);
		add(id);
		
		name=new JLabel("Patient Name:");
		name.setBounds(50,150,200,50);
		name.setFont(f1);
		add(name);
		
		age=new JLabel("Patient Age:");
		age.setBounds(50,250,200,50);
		age.setFont(f1);
		add(age);
		
		doctor=new JLabel("Doctor:");
		doctor.setBounds(50,350,200,50);
		doctor.setFont(f1);
		add(doctor);
		
		doa=new JLabel("Date:");
		doa.setBounds(50,440,200,50); 
		doa.setFont(f1);
		add(doa);
		
		toa=new JLabel("Time:");
		toa.setBounds(660,440,100,50); 
		toa.setFont(f1);
		add(toa);
		
		rov=new JLabel("Reason of Visit:");
		rov.setBounds(50,500,200,50);
		rov.setFont(f1);
		add(rov);
		
		
		
		cid=new Choice();
		cid.setBounds(300,55,150,40);
		cid.setFont(f1);
		add(cid);
		
		pname=new JLabel("Name");
		pname.setBounds(300,155,200,40);
		pname.setFont(f1);
		add(pname);
		
		page=new JLabel("Age");
	    page.setBounds(300,255,200,40);
	    page.setFont(f1);
		add(page);
		
		cdo=new Choice();
		cdo.setBounds(300,355,150,40);
		cdo.setFont(f1);
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
		
		b2=new JButton("Logout");
		b2.setBounds(300,580,200,50);
		b2.setFont(f1);
		add(b2);
		
		success=new JLabel("Congratulations! Your appointment has been successfully scheduled");
		success.setFont(f2);
		success.setBounds(50,620,600,50);
		add(success);
		success.setVisible(false);
		
		
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
		
		
		
		for(int i=17;i<=20;i++)
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
			stmt1=connection.createStatement();
			ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE from PATIENT where PID='"+cid.getSelectedItem()+"'");
			while(rs2.next())
			{
			String  name = rs2.getString(1);
	         String age  = rs2.getString(2);
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
				try
				{
					stmt1=connection.createStatement();
					ResultSet rs2=stmt1.executeQuery("select PNAME,PAGE from PATIENT where PID='"+cid.getSelectedItem()+"'");
					while(rs2.next())
					{
					String  name = rs2.getString(1);
			         String age  = rs2.getString(2);
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
try {     
    image = ImageIO.read(new File("E:\\images\\i6.jpg"));
    
 } catch (IOException ex) {       }
	
	}
		
		protected void paintComponent(Graphics g) {
			  
			   super.paintComponent(g);
			   g.drawImage(image,650,100,550,300,null);
			   
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
							
					for(int i=1;i<=29;i++)
					{
					c2.add(""+i);
					}
		
			}
			else if(val1%4!=0 && val.equalsIgnoreCase("feb"))
			{
				
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