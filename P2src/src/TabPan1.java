package javamyproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class TabPan1 extends JPanel implements ActionListener,KeyListener 
{
	
	private static final long serialVersionUID = 1L;
	JTabbedPane jtp1 = null;
	Appt a = null;
	Patient p = null;
	Doctor d = null;
	//Pharmacy pharmacy = null;
	Pharmacy pharmacy = null;
	Invoice invoice = null;
	TabPan1() 
	{
		setLayout(null);
		jtp1 = new JTabbedPane();
		a = new Appt();
		p = new Patient();
		d = new Doctor();
		//pharmacy = new Pharmacy();
		pharmacy = new Pharmacy();
		invoice = new Invoice();
		jtp1.setBounds(0,0,1500,1000);
		a.setBounds(0,0,1500,1000);
		p.setBounds(0,0,1500,1000);
		jtp1.addTab("SCHEDULE APPOINTMENT",a);
		jtp1.addTab("PATIENT INFO",p);
		jtp1.addTab("DOCTOR APPOINTMENTS",d);
		//jtp1.addTab("PHARMACY", pharmacy);
		jtp1.addTab("PHARMACY", pharmacy);
		jtp1.addTab("INVOICE", invoice);
		add(jtp1);
		
		//gets executed when tab is switched
		jtp1.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {

	        	//gets executed when pharmacy tab is selected
	        	if(jtp1.getTitleAt(jtp1.getSelectedIndex()).equals("PHARMACY")) {
	        		//pharmacy.resupplyWindow();
	        		pharmacy.resupplyWindow();
	        	}
	        }
	    });
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