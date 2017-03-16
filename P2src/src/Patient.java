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

class Patient extends JPanel implements ItemListener
{
	JLabel id,name,age,cno,title,pname,page,doctor,doa,toa,rov,pdoctor,pdoa,ptoa,prov,pcno,upa;
	Choice cid;
	
	 Connection connection = null;
	 Statement stmt = null, stmt1 = null;
	
	Font f,f1,f2;
	BufferedImage image,image1;
	
	Patient()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		f = new Font("Arial",Font.PLAIN,28);
		f1 = new Font("Arial",Font.PLAIN,25);
		f2 = new Font("Arial",Font.PLAIN,18);
		connection = SqliteConnection.dbConnector();
		
		
		title = new JLabel("PATIENT HISTORY");
		title.setBounds(540, 5, 400, 40);
		title.setFont(f);
		title.setForeground(Color.BLUE);
		add(title);
		
		id = new JLabel("Patient Id:");
		id.setBounds(50,50,200,50);
		id.setFont(f1);
		add(id);
		
		name = new JLabel("Patient Name:");
		name.setBounds(50,100,200,50);
		name.setFont(f1);
		add(name);
		
		age = new JLabel("Patient Age:");
		age.setBounds(50,150,200,50);
		age.setFont(f1);
		add(age);
		
		cno = new JLabel("Contact No:");
		cno.setBounds(50,200,200,50); 
		cno.setFont(f1);
		add(cno);
		
		upa = new JLabel("Upcoming Appointment");
		upa.setBounds(50,250,300,50); 
		upa.setFont(f1);
		add(upa);
		
		doctor = new JLabel("Doctor:");
		doctor.setBounds(50,300,200,50); 
		doctor.setFont(f1);
		add(doctor);
		
		doa = new JLabel("Date:");
		doa.setBounds(50,350,200,50); 
		doa.setFont(f1);
		add(doa);
		
		toa = new JLabel("Time:");
		toa.setBounds(50,400,100,50); 
		toa.setFont(f1);
		add(toa);
		
		rov = new JLabel("Reason of Visit:");
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
		cid = new Choice();
		cid.setBounds(300,55,150,40);
		cid.setFont(f1);
		add(cid);
		
		pname = new JLabel("Name");
		pname.setBounds(300,105,200,40);
		pname.setFont(f1);
		add(pname);
		
		page = new JLabel("Age");
		page.setBounds(300,155,200,40);
		page.setFont(f1);
		add(page);
		
		pcno = new JLabel("Patient Contact");
		pcno.setBounds(300,205,300,40);
		pcno.setFont(f1);
		add(pcno);
		
	    pdoctor = new JLabel("Doctor Name:");
		pdoctor.setBounds(300,300,200,50); 
		pdoctor.setFont(f1);
		add(pdoctor);
		
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
			int pid=Integer.parseInt(cid.getSelectedItem());
			//System.out.println(""+pid);
			stmt1 = connection.createStatement();
			ResultSet rs2 = stmt1.executeQuery("select PNAME,PAGE,CNO,DOCTOR,DATE,TIME,REASON from PATIENT where PID='"+cid.getSelectedItem()+"'");
			//System.out.println(""+pid);
			while(rs2.next())
			{
			String  name = rs2.getString(1);
			//System.out.println(name);
	         String age = rs2.getString(2);
	         //System.out.println(""+age);
	         String cno = rs2.getString(3);
	         //System.out.println(""+cno);
	         
	         String doctor = rs2.getString(4);
	         String date = rs2.getString(5);
	         String time = rs2.getString(6);
	         String reason = rs2.getString(7);
	         
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

		cid.addItemListener(new ItemListener() 
		{
			
			public void itemStateChanged(ItemEvent arg0) 
			{
				try
				{
					int pid = Integer.parseInt(cid.getSelectedItem());
					stmt1 = connection.createStatement();
					ResultSet rs2 = stmt1.executeQuery("select PNAME,PAGE,CNO,DOCTOR,DATE,TIME,REASON from PATIENT where PID='"+cid.getSelectedItem()+"'");
					System.out.println(""+pid);
					while(rs2.next())
					{
					String  name = rs2.getString(1);
					System.out.println(name);
			         String age  = rs2.getString(2);
			         System.out.println(""+age);
			         String cno = rs2.getString(3);
			         String doctor = rs2.getString(4);
			         String date = rs2.getString(5);
			         String time = rs2.getString(6);
			         String reason = rs2.getString(7);
			         
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
	private void setTitle(String string) 
	{
		// TODO Auto-generated method stub
		
	}
	public void itemStateChanged(ItemEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}