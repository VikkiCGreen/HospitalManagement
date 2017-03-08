import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class TabPan1 extends JPanel implements ActionListener,KeyListener 
{
	JTabbedPane jtp1 = null;
	Appt a = null;
	Patient p = null;
	Doctor d = null;
	Pharmacy pharmacy = null;
	
	TabPan1() 
	{
		setLayout(null);
		jtp1 = new JTabbedPane();
		a = new Appt();
		p = new Patient();
		d = new Doctor();
		pharmacy = new Pharmacy();
		jtp1.setBounds(0,0,1500,1000);
		a.setBounds(0,0,1500,1000);
		p.setBounds(0,0,1500,1000);
		jtp1.addTab("SCHEDULE APPOINTMENT",a);
		jtp1.addTab("PATIENT INFO",p);
		jtp1.addTab("DOCTOR APPOINTMENTS",d);
		jtp1.addTab("PHARMACY", pharmacy);
		add(jtp1);
	}
	
	private void setDefaultCloseOperation(int exitOnClose) 
	{
		// TODO Auto-generated method stub
            System.exit(0);
	}
	private void setTitle(String string) 
	{
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
}