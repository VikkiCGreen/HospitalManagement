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

public class Invoice extends JPanel implements ItemListener {
	JLabel id, date1, date,name,age,cno,title,pname,page,doctor,doa,toa,rov,pdoctor,pdoa,ptoa,prov,pcno,upa,totc;
	Font f,f1,f2;
	Choice cid;
	Calendar cal;
	JTextArea  textarea1=new JTextArea();
	JTextArea  textarea2=new JTextArea();
	JTextArea  textarea3=new JTextArea();
	JTextArea  textarea4=new JTextArea();
	BufferedImage image,image1;
	Connection connection = null;
	Statement stmt = null, stmt1 = null, stmt2= null;
	ResultSet rs,rs1,rs2 = null;

	Invoice()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		f = new Font("Arial",Font.PLAIN,28);
		f1 = new Font("Arial",Font.PLAIN,25);
		f2 = new Font("Arial",Font.PLAIN,18);
		connection = SqliteConnection.dbConnector();
		
		title = new JLabel("INVOICE");
		title.setBounds(540, 5, 400, 40);
		title.setFont(f);
		title.setForeground(Color.BLUE);
		add(title);
		
		id = new JLabel("Patient Id:");
		id.setBounds(50,50,200,50);
		id.setFont(f1);
		add(id);
	/*	
		name = new JLabel("Patient Name:");
		name.setBounds(1250,100,200,50);
		name.setFont(f1);
		add(name);
	 */	
		cno = new JLabel("Contact No:");
		cno.setBounds(700,150,200,50); 
		cno.setFont(f1);
		add(cno);
		
		upa = new JLabel("Upcoming Appointment:");
		upa.setBounds(700,200,300,50); 
		upa.setFont(f1);
		add(upa);
		
		//Declare total cost
		totc = new JLabel("Total Cost:");
		totc.setBounds(700,250,300,50);
		totc.setFont(f1);
		add(totc);
/*		
		cal=Calendar.getInstance();
		date1=new JLabel(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		date1.setBounds(1070, 140, 150, 50);
		add(date1);date1.setFont(f1);
		

		reset=new JButton("Reset");
		reset.setBounds(175, 350, 200,40);reset.setFont(f);
		add(reset);
		
		id1=new JTextField();
		id1.setBounds(300,60,200,40);
		add(id1);
		*/
		
		cid = new Choice();
		cid.setBounds(300,55,150,40);
		cid.setFont(f1);
		add(cid);
/* = new JLabel("Name");
		pname.setBounds(300,105,200,40);
		pname.setFont(f1);
		add(pname);

		pcno = new JLabel("Patient Contact");
		pcno.setBounds(300,205,300,40);
		pcno.setFont(f1);
		add(pcno);
*/		
		pdoctor = new JLabel("Doctor Name:");
		pdoctor.setBounds(700,300,200,50); 
		pdoctor.setFont(f1);
		add(pdoctor);
		
/*
		page = new JLabel("Age");
		page.setBounds(300,155,200,40);
		page.setFont(f1);
		add(page);
		
		pdoa = new JLabel("Date:");
		pdoa.setBounds(300,350,300,50); 
		pdoa.setFont(f1);
		add(pdoa);
			
		ptoa = new JLabel("Time:");
		ptoa.setBounds(300,400,100,50); 
		ptoa.setFont(f1);
		add(ptoa);
		
		prov = new JLabel("Reason of Visit:");
		prov.setBounds(300,450,300,50);
		prov.setFont(f1);
		add(prov);
*/
		
//exception handling
		try
		{
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select PID from PATIENT;");
			while(rs.next())
			{
				int pid = rs.getInt("PID");
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
			int rows = 0;
			int pid=Integer.parseInt(cid.getSelectedItem());
			stmt1 = connection.createStatement();
			ResultSet rs2 = stmt1.executeQuery("select PNAME,CNO from PATIENT where PID='"+cid.getSelectedItem()+"'");
//while loop
			while(rs2.next())
			{ 
				rows++;
			}
			String data[][]=new String[rows][4];
			int i = 0;
			rs2=stmt2.executeQuery("select PNAME,CNO from PATIENT where PID='"+cid.getSelectedItem()+"'");
		while(rs2.next()){
			int a = rs2.getInt(1);
			
			String  name = rs2.getString(1);
				String age = rs2.getString(2);
				String cno = rs2.getString(3);
	         
				String doctor = rs2.getString(4);
				String date = rs2.getString(5);
				String time = rs2.getString(6);
				String reason = rs2.getString(7);
				
				String b = rs2.getString(2);
				String c=rs2.getString(3);
				String d=rs2.getString(4);
				
				data[i][0]=""+a;
				data[i][1]=""+b;
				data[i][2]=""+c;
				data[i][3]=""+d;
				
				System.out.println(""+data[i][0]+" "+data[i][1]+" "+data[i][2]+" "+data[i][3]);
			     i++;
		
				pname.setText(name);
				page.setText(""+age);
				pcno.setText(""+cno);
				pdoctor.setText(doctor);
				pdoa.setText(date);
				ptoa.setText(time);
				prov.setText(reason);
		}
		String sr="";
		String ab="";
		String cd="";
		String ef="";
		for(int l=0;l<data.length;l++)
		{
			sr=sr+data[l][0];
			sr=sr+"\n";
			ab=ab+data[l][1]+"\n";
			cd=cd+data[l][2]+"\n";
			ef=ef+data[l][3]+"\n";
					
		}
		textarea1.setText(sr);
		  textarea2.setText(ab);
		  textarea3.setText(cd);
		  textarea4.setText(ef);
		stmt1=connection.createStatement();
		String b=cid.getSelectedItem();
		System.out.println(b);
		rs1=stmt1.executeQuery("select CNO from REGISTER where NAME='"+cid.getSelectedItem()+"'");
		String a=rs1.getString(1);
		pcno.setText(""+a);
		rs1.close();
		stmt1.close();
	        rs2.close();
				stmt1.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
//itemListener!!!
		cid.addItemListener(new ItemListener() 
		{
			
			public void itemStateChanged(ItemEvent arg0) 
			{
				try
				{
					int pid = Integer.parseInt(cid.getSelectedItem());
					stmt1 = connection.createStatement();
					ResultSet rs2 = stmt1.executeQuery("select PNAME,CNO from PATIENT where PID='"+cid.getSelectedItem()+"'");
					System.out.println(""+pid);
					while(rs2.next())
					{
					String  name = rs2.getString(1);
					System.out.println(name);
//			         String age  = rs2.getString(2);
//			         System.out.println(""+age);
			         String cno = rs2.getString(3);
			         String doctor = rs2.getString(4);
//			         String date = rs2.getString(5);
//			         String time = rs2.getString(6);
//			         String reason = rs2.getString(7);
			         
			         pname.setText(name);
//			         page.setText(""+age);
			         pcno.setText(""+cno);
			         pdoctor.setText(doctor);
//			         pdoa.setText(date);
//			         ptoa.setText(time);
//			         prov.setText(reason);  
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
		
String head[]={"Patient ID","NAME","DATE","TIME"};
textarea1.setEditable(false);
textarea2.setEditable(false);
textarea3.setEditable(false);
textarea4.setEditable(false);
textarea1.setText("");
JLabel lab=new JLabel(""+head[0]+"               "+head[1]+"             "+head[2]+"             "+head[3]);
lab.setBounds(100,110,600,30);
add(lab);
Font f4=new Font("Arial",Font.PLAIN,20);
lab.setFont(f4);
Color aColor = new Color(0xBAD0E3);
textarea1.setText("");
textarea1.setBackground(aColor);
textarea1.setFont(f4);
textarea1.setBounds(100,150,180,450);
//setLayout(null);
add(textarea1);
//System.out.println("test3");
 textarea2.setText("");
    textarea2.setBackground(aColor);
    textarea2.setFont(f4);
    textarea2.setBounds(280,150,130,450);
	//setLayout(null);
    add(textarea2);
    textarea3.setText("");
    textarea3.setBackground(aColor);
    textarea3.setFont(f4);
    textarea3.setBounds(410,150,130,450);
	//setLayout(null);
    add(textarea3);
	System.out.println("test3");
	 textarea4.setText("");
	    textarea4.setBackground(aColor);
	    textarea4.setFont(f4);
	    textarea4.setBounds(540,150,130,450);
	    add(textarea4);
	    textarea1.setVisible(true);
		 textarea2.setVisible(true);
		 textarea3.setVisible(true);
		 textarea4.setVisible(true);
		 try {     
			    image = ImageIO.read(new File("E:\\images\\i7.jpg"));
			    
			 } catch (IOException ex) {       }
				
			}
					
					protected void paintComponent(Graphics g) {
						  
						   super.paintComponent(g);
						   g.drawImage(image,850,300,400,300,null);
						   
						  }

		//setLayout(null);

	
	
	private void setTitle(String string) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
