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
import java.sql.PreparedStatement;
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

class Home extends JFrame implements ActionListener,KeyListener,MouseListener
{
	HomePanel jp=null;
	TabPan1 tp=null;
	Background b=null;
	Register reg=null;
	Generation gen=null;
	
	 Connection connection=null;
	 Statement stmt=null;
	 int f=0,l=0,q=0,x,y,z;
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
		tp.a.b2.addActionListener(this);
		tp.pa.purchase.addActionListener(this);
		
		tp.a.b1.addKeyListener(this);
		tp.a.b2.addKeyListener(this);
		tp.pa.purchase.addKeyListener(this);
			 
			 
			
		
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

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch=e.getKeyChar();
		if(ch=='\n')
		{
		
		Object o=e.getSource();
		if(o==jp.b1)
		{
			shortcut(jp.b1.getText());
		}
		else if(o==jp.b2)
		{
		     shortcut(jp.b2.getText());	
		}
		else if(o==jp.b3)
		{
		     shortcut(jp.b3.getText());	
		}
		else if(o==reg.b1)
		{
		     shortcut(reg.b1.getText());	
		}
		else if(o==reg.b2)
		{
		     shortcut(reg.b2.getText());	
		}
		else if(o==tp.a.b1)
		{
		     shortcut(tp.a.b1.getText());	
		}
		else if(o==tp.a.b2)
		{
		     shortcut(tp.a.b2.getText());	
		}
		else if(o==tp.pa.purchase)
		{
			shortcut(tp.pa.purchase.getText());
		}
		else if(o==gen.jb1)
		{
			shortcut(gen.jb1.getText());
		}
		
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String s = ae.getActionCommand();
		 shortcut(s);
		 }	 
		 void shortcut(String s)
		 {
			 int f5 = 0;
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
			 else if(s.equalsIgnoreCase("Buy"))
			 {
				 try
				 {
					 if(tp.pa.tf.getText().equals(""))
					 {
						 tp.pa.quantity.setVisible(true);
					 }
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
	           
	        	try{
	        		 try
	        		 {
	        			 x = Integer.parseInt(tp.pa.tf.getText());
	        		 }
	        		 catch(Exception e)
	        		 {
	        			 e.printStackTrace();
	        		 }
	  	           y = Integer.parseInt(tp.pa.mquantity.getText());
	           if(x > y)
	        		   {
	        			   tp.pa.qerr.setVisible(true);
	        		   }
	           else
	           {
	        	   tp.pa.qerr.setVisible(false);
	        	   q = 1;
	        	   z = y - x;
	        	   tp.pa.tf.setText("");
	        	   tp.pa.mquantity.setText("" + z);
	           }
	           
	           if(q == 1)
	           {
	        	    String sql = "UPDATE PHARMACY SET QUANTITY= " + z + " where MID='"+tp.pa.cid.getSelectedItem()+"'"; 
					stmt= connection.createStatement();
					stmt.executeUpdate(sql);
					stmt.close(); 
					String sql1 = "INSERT INTO INVOICE(MID,MNAME,QUANTITY,SUPPLIER,PRICE,PID,TOTAL) VALUES(?,?,?,?,?,?,?)"; 
					PreparedStatement pst1= connection.prepareStatement(sql1);
					pst1.setString(1,tp.pa.cid.getSelectedItem());
					pst1.setString(2,tp.pa.mname.getText());
					pst1.setInt(3,x);
					pst1.setString(4,tp.pa.msupplier.getText());
				    pst1.setString(5, tp.pa.mprice.getText());
				    pst1.setString(6,tp.pa.cpid.getSelectedItem());
				    int pri= Integer.parseInt(tp.pa.mprice.getText().substring(1));
				    int total= x * pri;
				    
				    pst1.setInt(7, total);
					
			     pst1.execute();
			     pst1.close();
	           }
	        	}
	        	catch(Exception e)
	        	{
	        		e.printStackTrace();
	        	}
	        	
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
				 reg.tf1.setText("");
			     reg.ta.setText("");
			     reg.tf2.setText("");
			     reg.age.setVisible(false);
			     reg.c1.select(0);

			     reg.c3.select(0);
				 
			 }
			 else if (s.equals("Sign Up"))
			 {
				 jp.setVisible(false);
				 b.setVisible(false);
				 reg.setVisible(true);
			 }
			 else if (s.equalsIgnoreCase("Logout"))
			 {
				 tp.setVisible(false);
				 jp.setVisible(true);
				 jp.tf1.setText("");
				 jp.tf2.setText("");
				
			 }
			 else if(s.equalsIgnoreCase("Schedule"))
			 {
				
				 try
				 {
					 String doctor=tp.a.cdo.getSelectedItem();
					 String sql = "UPDATE PATIENT SET Doctor='"+tp.a.cdo.getSelectedItem()+"',Date='"+tp.a.c1.getSelectedItem()+"-"+tp.a.c2.getSelectedItem()+"-"+tp.a.c3.getSelectedItem()+"',Time='"+tp.a.c4.getSelectedItem()+"',Reason='"+tp.a.c5.getSelectedItem()+"' where PID='"+tp.a.cid.getSelectedItem()+"'"; 
						stmt= connection.createStatement();
						stmt.executeUpdate(sql);
						stmt.close();
						
						
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 
				 }
				 
				tp.a.success.setVisible(true);
				
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
						if(a<48 || a>57)
						{  
							reg.val4.setVisible(false);
							 reg.val5.setVisible(true);
							 reg.val1.setVisible(false);
							 reg.val2.setVisible(false);
							 reg.val3.setVisible(false);
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
						if(a>=48 && a<=57)
						{  
							reg.val4.setVisible(false);
							 reg.val5.setVisible(false);
							 reg.val1.setVisible(false);
							 reg.val2.setVisible(true);
							 reg.val3.setVisible(false);
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
						String msg2=reg.c2.getSelectedItem()+msg1+reg.c3.getSelectedItem();
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
				     
				     
			         reg.setVisible(false);
			   		 jp.setVisible(false);
			   		 gen.setVisible(true);
			   		reg.tf1.setText("");
				     reg.ta.setText("");
				     reg.tf2.setText("");
				     reg.age.setVisible(false);
				     reg.c1.select(0);  
				     reg.c3.select(0);
				    
			
			         }
					
				        
				    
				  		
				  	
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
					
				 }
			 }
			
		
	}
	
}

