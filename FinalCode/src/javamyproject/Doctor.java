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

class Doctor extends JPanel implements ItemListener
{
	JLabel dname,cno,dcno,title,date1,date;
	Font f,f1,f2;
	Choice c1;
	Calendar cal;
	JTextArea  textarea1=new JTextArea();
	JTextArea  textarea2=new JTextArea();
	JTextArea  textarea3=new JTextArea();
	JTextArea  textarea4=new JTextArea();
    BufferedImage image;
	Connection connection=null;
	Statement stmt,stmt1,stmt2=null;
	ResultSet rs,rs1,rs2=null;
	Doctor()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		connection= SqliteConnection.dbConnector();
		f=new Font("Arial",Font.PLAIN,28);
		f1=new Font("Arial",Font.PLAIN,25);
		f2=new Font("Arial",Font.PLAIN,18);
		
		title=new JLabel("DOCTOR APPOINTMENTS");
		title.setBounds(540, 5, 400, 40);
		title.setFont(f);
		title.setForeground(Color.BLUE);
		add(title);
		
		dname=new JLabel("Doctor:");
		dname.setBounds(50,50,200,50);
		dname.setFont(f1);
		add(dname);
		
		c1=new Choice();
		c1.setBounds(260,50,200,50);
		c1.setFont(f1);
		add(c1);
		
		cno=new JLabel("Contact Number:");
		cno.setBounds(850,100,200,50);
		cno.setFont(f1);
		add(cno);
		
		dcno=new JLabel("Contact");
		dcno.setBounds(1070,100,200,50);
		dcno.setFont(f1);
		add(dcno);
		
		date=new JLabel("Date:");
		date.setBounds(850, 140, 150, 50);
		add(date);
		date.setFont(f1);
		
		cal=Calendar.getInstance();
		date1=new JLabel(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
		date1.setBounds(1070, 140, 150, 50);
		add(date1);
		date1.setFont(f1);
	
		
		
		try
		{
			stmt=connection.createStatement();
			 rs=stmt.executeQuery("select NAME,CNO from REGISTER where TYPE='Doctor'");
			while(rs.next())
			{
				String a=rs.getString(1);
				c1.add(""+a);
			}
			rs.close();
			stmt.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
c1.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
				
				
				try
				{
					stmt2=connection.createStatement();
					int rows=0;
					rs2=stmt2.executeQuery("select PID,PNAME,Date,Time from PATIENT where DOCTOR='"+c1.getSelectedItem()+"'");
					while(rs2.next())
					{
						rows++;
					}
					
					String data[][]=new String[rows][4];
					int i=0;
					
					rs2=stmt2.executeQuery("select PID,PNAME,Date,Time from PATIENT where DOCTOR='"+c1.getSelectedItem()+"'");
					while(rs2.next())
					{
						int a=rs2.getInt(1);
						String b=rs2.getString(2);
						String c=rs2.getString(3);
						String d=rs2.getString(4);
						
						
						data[i][0]=""+a;
						
						data[i][1]=""+b;
						
						data[i][2]=""+c;
						data[i][3]=""+d;
						
						System.out.println(""+data[i][0]+" "+data[i][1]+" "+data[i][2]+" "+data[i][3]);
					     i++;
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
					String b=c1.getSelectedItem();
					System.out.println(b);
					rs1=stmt1.executeQuery("select CNO from REGISTER where NAME='"+c1.getSelectedItem()+"'");
					String a=rs1.getString(1);
					dcno.setText(""+a);
					rs1.close();
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

add(textarea1);
//System.out.println("test3");
 textarea2.setText("");
 textarea2.setBackground(aColor);
 textarea2.setFont(f4);
 textarea2.setBounds(280,150,130,450);
	
 add(textarea2);
 textarea3.setText("");
 textarea3.setBackground(aColor);
 textarea3.setFont(f4);
 textarea3.setBounds(410,150,130,450);
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

	
	
	
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	public void itemStateChanged(ItemEvent arg0) {
		
	}
	
}