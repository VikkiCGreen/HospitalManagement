import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

public class Pharmacy extends JPanel implements ItemListener 
{
	
	private static final long serialVersionUID = 1L;
		JLabel mid,name,quantity,supplier,title,pid,mname,mquantity,msupplier;
		Choice cid;
		
		Connection connection = null;
		Statement stmt = null, stmt1 = null, getquantity = null;
		
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
			
//			pid = new JLabel("Patient ID:");
//			pid.setBounds(50,250,300,50); 
//			pid.setFont(f1);
//			add(pid);
			
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

				stmt1 = connection.createStatement();
				ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PID from PHARMACY where MID='"+cid.getSelectedItem()+"'");
				while(rs2.next())
				{
					String  name = rs2.getString(1);
			        String quantity  = rs2.getString(2);
			        String supplier = rs2.getString(3);
	
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
						ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PID from PHARMACY where MID='"+cid.getSelectedItem()+"'");
						while(rs2.next())
						{
							String  name = rs2.getString(1);
					        String quantity  = rs2.getString(2);
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
		
		public void resupplyWindow()
		{
			HashMap<String,String> resupply = new HashMap<>();
			try 
			{
				getquantity = connection.createStatement();
				ResultSet rsquantity = getquantity.executeQuery("select MNAME,QUANTITY from PHARMACY where QUANTITY <= 100;");
				
				while(rsquantity.next())
				{
					String name = rsquantity.getString(1);
					System.out.println(name);
					String quan  = rsquantity.getString(2);
					System.out.println(quan);
					resupply.put(name, quan);
				}
				rsquantity.close();
				getquantity.close();
			} 
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			if(resupply.size() > 0)
			{
				for(String name : resupply.keySet())
				{
					makeWindow(name, resupply.get(name));
				}
			}
		}
		
		private void makeWindow(String name, String quan) 
		{
			//notification for low quantity
			String msg = "<html>" + name + " needs resupply! <br>Current quantity: " + quan + 
					"<br><font color=\"red\">Please enter a number to reorder. </font></html>";
			String header = "<html><font color=\"red\">LOW QUANTITY ALERT</font></html>";
			JTextField jtf = new JTextField(10);
			JDialog frame = new JDialog();
			JButton button1 = new JButton();
			button1.setText("Submit");
			PlainDocument doc = (PlainDocument) jtf.getDocument();
			doc.setDocumentFilter(new MyIntFilter());
			
	
			//popup takes priority
			frame.setModal(true);
			frame.setSize(350,125);
			frame.setLocationRelativeTo(null);
			frame.setUndecorated(false);
			frame.setLayout(new GridBagLayout());

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			//constraints.gridy = 0;
			constraints.weightx = 1.0f;
			constraints.weighty = 1.0f;
			constraints.insets = new Insets(5, 5, 5, 5);
			constraints.fill = GridBagConstraints.VERTICAL;
	
			frame.add(jtf, constraints);
			JLabel headingLabel = new JLabel(header);
			headingLabel.setHorizontalAlignment(JLabel.CENTER);
			headingLabel.setVerticalAlignment(JLabel.CENTER);
			headingLabel.setOpaque(false);
			frame.add(headingLabel, constraints);
			constraints.gridx++;
			constraints.weightx = 0f;
			constraints.weighty = 0f;
			constraints.fill = GridBagConstraints.VERTICAL;
			constraints.anchor = GridBagConstraints.NORTH;
			constraints.gridx = 0;
			//constraints.gridy++;
			constraints.weightx = 0.5f;
			constraints.weighty = 0.5f;
			constraints.insets = new Insets(5, 5, 5, 5);
			constraints.fill = GridBagConstraints.NONE;
			
			JLabel messageLabel = new JLabel(msg);
			messageLabel.setHorizontalAlignment(JLabel.CENTER);
			messageLabel.setVerticalAlignment(JLabel.CENTER);
			frame.add(messageLabel, constraints);
			frame.add(jtf, constraints);
			frame.add(button1, constraints);
			frame.pack();
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			
		}
		
}
