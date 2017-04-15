package javamyproject;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		JLabel name,quantity,supplier,title,price,pid,qerr,
		mname,mquantity,msupplier,mprice,mid,
		qtypurchase, pname, mpname;
		Choice cid, cpid;
		JTextField tf;
		JButton purchase;
		
		HashMap<String, JTextField> fields;
		
		Connection connection = null;
		Statement stmt = null, stmt1 = null, stmt2 = null, getquantity = null;
		
		Font f,f1,f2;
		BufferedImage image,image1;
		
	
		{
			setLayout(null);
			this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
			f = new Font("Arial",Font.PLAIN,28);
			f1 = new Font("Arial",Font.PLAIN,25);
			f2 = new Font("Arial",Font.PLAIN,18);
			connection= SqliteConnection.dbConnector();
			
			fields = new HashMap<String, JTextField>();
			
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
			price.setBounds(450, 105, 100, 40);
			price.setFont(f1);
			add(price);
			
			mprice = new JLabel("Price:");
			mprice.setBounds(555, 105, 100, 40);
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
			
			pname = new JLabel("Patient Name:");
			pname.setBounds(50,300,200,50); 
			pname.setFont(f1);
			add(pname);
			
			mquantity = new JLabel("Quantity:");
			mquantity.setBounds(50,350,300,50);
			mquantity.setFont(f1);
			add(mquantity);
			
			cid = new Choice();
			cid.setBounds(300,55,150,40);
			cid.setFont(f1);
			add(cid);
			
			cpid = new Choice();
			cpid.setBounds(300,250,150,40);
			cpid.setFont(f1);
			add(cpid);
			
			mname = new JLabel("Name");
			mname.setBounds(300,105,200,40);
			mname.setFont(f1);
			add(mname);
			
			mpname = new JLabel("Patient Name");
			mpname.setBounds(300,305,200,40);
			mpname.setFont(f1);
			add(mpname);
			
			mquantity = new JLabel("Quantity");
			mquantity.setBounds(300,155,200,40);
			mquantity.setFont(f1);
			add(mquantity);
			
			qerr=new JLabel("Not enough Quantity available");
			qerr.setBounds(550,155,400,40);
			qerr.setFont(f1);
			qerr.setForeground(Color.RED);
			add(qerr);
			qerr.setVisible(false);
			
			msupplier = new JLabel("Supplier");
			msupplier.setBounds(300,205,200,40);
			msupplier.setFont(f1);
			add(msupplier);
			
			//purchase
			tf = new JTextField("");
			tf.setBounds(300,355,100,30);
			tf.setFont(f1);
			add(tf);
			
			purchase = new JButton("Buy");
			purchase.setBounds(300,400,100,50);
			purchase.setFont(f1);
			add(purchase);
			
			purchase.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(Integer.parseInt(mquantity.getText()) <= 300)
					{
						resupplyWindow();
					}
				}
			});

			try
			{
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				ResultSet rs = stmt.executeQuery("Select MID from PHARMACY;");
				ResultSet rs1 = stmt1.executeQuery("SELECT PID from PATIENT;");
				
				while(rs.next())
				{
					int mid = rs.getInt("MID");
					cid.add("" + mid);
				}
				stmt.close();
				
				while(rs1.next())
				{
					int pid = rs1.getInt("PID");
					cpid.add("" + pid );
				}
				
				rs.close();
				stmt1.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			cid.select(0);
			cpid.select(0);
			
			
			try
			{
				int mid=Integer.parseInt(cid.getSelectedItem());
				int pid = Integer.parseInt(cpid.getSelectedItem());
				
				stmt1 = connection.createStatement();
				stmt2 = connection.createStatement();
				
				ResultSet rs1 = stmt2.executeQuery("SELECT PNAME from PATIENT where PID='" + cpid.getSelectedItem() + "'");
				ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PRICE from PHARMACY where MID='"+cid.getSelectedItem()+"'");
				
				while(rs2.next())
				{
					String name = rs2.getString(1);
			        String quantity = rs2.getString(2);
			        String supplier = rs2.getString(3);
			        String price = rs2.getString(4);
	
			        mname.setText(name);
			        mquantity.setText("" + quantity);
			        msupplier.setText("" + supplier);
			        mprice.setText("$" + price);
		         
				}
				
		        rs2.close();
		        stmt1.close();
				//rs1
				while(rs1.next())
				{
					String pname = rs1.getString(1);
					mpname.setText(pname);
				}
				rs1.close();
				stmt2.close();
				

					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	cpid.addItemListener(new ItemListener() 
	{
		public void itemStateChanged(ItemEvent arg0) 
		{
			
			try
			{
				
				int pid = Integer.parseInt(cpid.getSelectedItem());
				stmt2 = connection.createStatement();
				ResultSet rs1 = stmt2.executeQuery("SELECT PNAME from PATIENT where PID='" + cpid.getSelectedItem() + "'");
				
		        
				//rs1
				while(rs1.next())
				{
					String pname = rs1.getString(1);
					mpname.setText("" + pname);
				}
				rs1.close();
				stmt2.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		
	});
			
	cid.addItemListener(new ItemListener() 
	{
				
				public void itemStateChanged(ItemEvent arg0) 
				{
					try
					{
						int mid = Integer.parseInt(cid.getSelectedItem());
						stmt1 = connection.createStatement();
						ResultSet rs2 = stmt1.executeQuery("select MNAME,QUANTITY,SUPPLIER,PRICE from PHARMACY where MID='"+cid.getSelectedItem()+"'");
						
						//rs2
						while(rs2.next())
						{
							String name = rs2.getString(1);
					        String quantity = rs2.getString(2);
					        String supplier = rs2.getString(3);
					        String price = rs2.getString(4);
					         
					        mname.setText(name);
					        mquantity.setText("" + quantity);
					        msupplier.setText("" + supplier);
					        mprice.setText("$" + price);
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
				ResultSet rsquantity = getquantity.executeQuery("select MNAME,QUANTITY from PHARMACY where QUANTITY <= 300;");
				
				while(rsquantity.next())
				{
					String name = rsquantity.getString(1);
					String quan  = rsquantity.getString(2);
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
		
		public void makeWindow(String name, String quan) 
		{
			//notification for low quantity
			String msg = "<html>" + name + " needs resupply! <br>Current quantity: " + quan + 
					"<br><font color=\"red\">Please enter a number to reorder. </font></html>";
			String header = "<html><font color=\"red\">LOW QUANTITY ALERT</font></html>";
			JTextField jtf = new JTextField(10);
			JDialog frame = new JDialog();
			JButton button1 = new JButton();
			button1.setText("Submit");
			
			button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int oldValue = 0;
					for(String medName : fields.keySet())
					{
						if(medName.equals(name))
						{
							
							String strValue = fields.get(medName).getText();
							
							int value = Integer.parseInt(strValue);
							
							//TODO maybe make it from MID
							try {
								ResultSet rsquantity = getquantity.executeQuery("SELECT QUANTITY from PHARMACY where MNAME='" + name + "'");
								while(rsquantity.next())
								{
									oldValue = rsquantity.getInt(1);
								}
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
							int newValue = oldValue + value;
							
							if(mname.getText().equals(name))
							{
								mquantity.setText(String.valueOf(newValue));
							}
							
							String query = "UPDATE PHARMACY SET QUANTITY=" + newValue + " where MNAME='" + name + "'";
							try {
								PreparedStatement pst1 = connection.prepareStatement(query);
								pst1.execute();
								pst1.close();
							} catch (SQLException e1) {
								
								e1.printStackTrace();
							}
							//closes window after
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
					}
				}
			});
			
			PlainDocument doc = (PlainDocument) jtf.getDocument();
			doc.setDocumentFilter(new MyIntFilter());
			
			fields.put(name, jtf);
//			
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
