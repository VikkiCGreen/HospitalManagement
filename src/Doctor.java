import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Doctor extends JPanel implements ItemListener
{
	JLabel dname,cno,dcno,title;
	Font f,f1,f2;
	Choice c1;
	Connection connection=null;
	Statement stmt=null;
	Doctor()
	{
		setLayout(null);
		this.setTitle("HOSPITAL MANAGEMENT SYSTEM");
		connection= SqliteConnection.dbConnector();
		f = new Font("Arial",Font.PLAIN,28);
		f1 = new Font("Arial",Font.PLAIN,25);
		f2 = new Font("Arial",Font.PLAIN,18);
		title = new JLabel("DOCTOR APPOINTMENTS");
		title.setBounds(540, 5, 400, 40);
		title.setFont(f);
		title.setForeground(Color.BLUE);
		add(title);
		
		dname = new JLabel("Doctor:");
		dname.setBounds(50,50,200,50);
		dname.setFont(f1);
		add(dname);
		
		c1 = new Choice();
		c1.setBounds(260,50,200,50);
		c1.setFont(f1);
		add(c1);
		
		cno = new JLabel("Contact Number:");
		cno.setBounds(50,100,200,50);
		cno.setFont(f1);
		add(cno);
		
		dcno = new JLabel("Contact");
		dcno.setBounds(260,100,200,50);
		dcno.setFont(f1);
		add(dcno);
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