import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pharmacy extends JPanel implements ItemListener 
{
		JLabel mid,name,quantity,supplier,title,pid,mname,mquantity,msupplier;
		Choice cid;
		
		 Connection connection = null;
		 Statement stmt = null, stmt1 = null;
		
		Font f,f1,f2;
		BufferedImage image,image1;
		
	
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
			
			quantity = new JLabel("Quantity:");
			quantity.setBounds(50,150,200,50);
			quantity.setFont(f1);
			add(quantity);
			
			supplier = new JLabel("Supplier:");
			supplier.setBounds(50,200,200,50); 
			supplier.setFont(f1);
			add(supplier);
			
			pid = new JLabel("Patient ID:");
			pid.setBounds(50,250,300,50); 
			pid.setFont(f1);
			add(pid);
			
			cid=new Choice();
			cid.setBounds(300,55,150,40);cid.setFont(f1);
			add(cid);
			
			mname = new JLabel("Name");
			mname.setBounds(300,105,200,40);
			mname.setFont(f1);
			add(mname);
			
			mquantity = new JLabel("Quantity");
			mquantity.setBounds(300,155,200,40);
			mquantity.setFont(f1);
			add(mquantity);
			
			msupplier = new JLabel("Supplier");
			msupplier.setBounds(300,205,300,40);
			msupplier.setFont(f1);
			add(msupplier);
			
			//exception handling
			try
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("Select MID from PHARMACY;");
				
				while(rs.next())
				{
					int mid = rs.getInt("MID");
					cid.add(""+mid);
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
				ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PID from PHARMACY where MID='"+cid.getSelectedItem()+"'");
				System.out.println(""+mid);
				while(rs2.next())
				{
				String  name = rs2.getString(1);
				System.out.println(name);
		         String quantity  = rs2.getString(2);
		         System.out.println(""+quantity);
		         String supplier = rs2.getString(3);
		         System.out.println(""+supplier);
		         
		         
		         mname.setText(name);
		         mquantity.setText(""+quantity);
		         msupplier.setText(""+supplier);
		         
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
					try
					{
						int mid = Integer.parseInt(cid.getSelectedItem());
						stmt1 = connection.createStatement();
						ResultSet rs2=stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PID from PHARMACY where MID='"+cid.getSelectedItem()+"'");
						System.out.println(""+mid);
						while(rs2.next())
						{
						String  name = rs2.getString(1);
						System.out.println(name);
				         String quantity  = rs2.getString(2);
				         System.out.println(""+quantity);
				         String supplier= rs2.getString(3);
				         
				         mname.setText(name);
				         mquantity.setText(""+quantity);
				         msupplier.setText(""+supplier);
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
		
}
