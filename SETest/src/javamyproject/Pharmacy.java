package javamyproject;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pharmacy extends JPanel implements ItemListener 
{
		JLabel mid,name,price,quantity,quantity1,supplier,title,pid,mname,mquantity,msupplier,mprice,qerr,qty;
		Choice cid,cpid;
		JTextField tf;
		JButton purchase;
		
		 Connection connection = null;
		 Statement stmt = null, stmt1 = null;
		
		Font f,f1,f2;
		BufferedImage image;
		
	
		{
			setLayout(null);
			this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
			f = new Font("Arial",Font.PLAIN,28);
			f1 = new Font("Arial",Font.PLAIN,25);
			f2 = new Font("Arial",Font.PLAIN,18);
			connection= SqliteConnection.dbConnector();
			
			
			title = new JLabel("PHARMACY");
			title.setBounds(540, 5, 400, 40);
			title.setFont(f);
			title.setForeground(Color.BLUE);
			add(title);
			
			mid = new JLabel("Medicine ID:");
			mid.setBounds(50,50,200,50);
			mid.setFont(f1);
			add(mid);
			
			name = new JLabel("Medicine Name:");
			name.setBounds(50,100,200,50);
			name.setFont(f1);
			add(name);
			
			price = new JLabel("Price:");
			price.setBounds(450,105,100,40);
			price.setFont(f1);
			add(price);
			
			mprice = new JLabel("Price:");
			mprice.setBounds(555,105,100,40);
			mprice.setFont(f1);
			add(mprice);
			
			
			quantity = new JLabel("Quantity Available:");
			quantity.setBounds(50,150,300,50);
			quantity.setFont(f1);
			add(quantity);
			
			supplier = new JLabel("Supplier:");
			supplier.setBounds(50,200,200,50); 
			supplier.setFont(f1);
			add(supplier);
			
			pid = new JLabel("Patient ID:");
			pid.setBounds(50,250,200,50); 
			pid.setFont(f1);
			add(pid);
			
			mquantity = new JLabel("Quantity:");
			mquantity.setBounds(50,300,100,50);
			mquantity.setFont(f1);
			add(mquantity);
			
			qty=new JLabel("Please enter quantity");
			qty.setBounds(50,450,300,50);
			qty.setFont(f1);
			add(qty);
			qty.setVisible(false);
			qty.setForeground(Color.RED);
			
			
			
			
			cid=new Choice();
			cid.setBounds(300,55,150,40);
			cid.setFont(f1);
			add(cid);
			
			cpid=new Choice();
			cpid.setBounds(300,250,150,40);
			cpid.setFont(f1);
			add(cpid);
			
			mname = new JLabel("Name");
			mname.setBounds(300,105,200,40);
			mname.setFont(f1);
			add(mname);
			
			mquantity = new JLabel("Quantity");
			mquantity.setBounds(300,155,200,40);
			mquantity.setFont(f1);
			add(mquantity);
			
			qerr=new JLabel("Not enough Quantity available");
			qerr.setBounds(350,155,400,40);
			qerr.setFont(f1);
			qerr.setForeground(Color.RED);
			add(qerr);
			qerr.setVisible(false);
			
			
			msupplier = new JLabel("Supplier");
			msupplier.setBounds(300,205,300,40);
			msupplier.setFont(f1);
			add(msupplier);
			
			tf=new JTextField("");
			tf.setBounds(300,300,100,30);
			tf.setFont(f1);
			add(tf);
			
			purchase=new JButton("Buy");
			purchase.setBounds(50,400,100,50);
			purchase.setFont(f1);
			add(purchase);
			//exception handling
			 try {     
				    image = ImageIO.read(new File("E:\\images\\i9.jpg"));
				    
				 } catch (IOException ex) {       }
					
				
						
						
			try
			{
				stmt = connection.createStatement();
				stmt1=connection.createStatement();
				ResultSet rs = stmt.executeQuery("Select MID from PHARMACY;");
				ResultSet rs1=stmt1.executeQuery("SELECT PID from PATIENT;");
				
				
				
				while(rs.next())
				{
					int mid = rs.getInt("MID");
					cid.add(""+mid);
				}
				
				while(rs1.next())
				{
					int pid=rs1.getInt("PID");
					cpid.add(""+pid);
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
				int mid=Integer.parseInt(cid.getSelectedItem());
				//System.out.println(""+pid);
				stmt1 = connection.createStatement();
				ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PRICE from PHARMACY where MID='"+cid.getSelectedItem()+"'");
				System.out.println(""+mid);
				while(rs2.next())
				{
				String  name = rs2.getString(1);
				System.out.println(name);
		         String quantity  = rs2.getString(2);
		         System.out.println(""+quantity);
		         String supplier = rs2.getString(3);
		         System.out.println(""+supplier);
		         String price= rs2.getString(4);
		         
		         
		         mname.setText(name);
		         mquantity.setText(""+quantity);
		         msupplier.setText(""+supplier);
		         mprice.setText(""+price);
		         
				}
				
		        rs2.close();
			    stmt1.close();
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	cid.addItemListener(new ItemListener() 
	{
				
				public void itemStateChanged(ItemEvent arg0) 
				{
					qerr.setVisible(false);
					qty.setVisible(false);
					try
					{
						int mid = Integer.parseInt(cid.getSelectedItem());
						stmt1 = connection.createStatement();
						ResultSet rs2=stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PRICE from PHARMACY where MID='"+cid.getSelectedItem()+"'");
						System.out.println(""+mid);
						while(rs2.next())
						{
						String  name = rs2.getString(1);
						System.out.println(name);
				         String quantity  = rs2.getString(2);
				         System.out.println(""+quantity);
				         String supplier= rs2.getString(3);
				         String price= rs2.getString(4);
				         
				         mname.setText(name);
				         mquantity.setText(""+quantity);
				         msupplier.setText(""+supplier);
				         mprice.setText(""+price);
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
		private void setTitle(String string) 
		{
			// TODO Auto-generated method stub
			
		}
		public void itemStateChanged(ItemEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}
		protected void paintComponent(Graphics g) {
			  
			   super.paintComponent(g);
			   g.drawImage(image,750,100,500,300,null);
			   
			  }
}
