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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.sqlite.SQLiteConnection;


class TabPan1 extends JPanel 
{
	JTabbedPane jtp1=null;
	Appt a=null;
	Patient p=null;
	Doctor d=null;
	Pharmacy pa=null;
	Invoice i=null;
	
	TabPan1()
	{
		setLayout(null);
		jtp1=new JTabbedPane();
		a=new Appt();
		p=new Patient();
		d=new Doctor();
		pa=new Pharmacy();
		i=new Invoice();
		
		
		jtp1.setBounds(0,0,1500,1000);
		a.setBounds(0,0,1500,1000);
		p.setBounds(0,0,1500,1000);
		pa.setBounds(0,0,1500,1000);
		i.setBounds(0,0,1500,1000);
		jtp1.addTab("SCHEDULE APPOINTMENT",a);
		jtp1.addTab("PATIENT INFO",p);
		jtp1.addTab("DOCTOR APPOINTMENTS",d);
		jtp1.addTab("PHARMACY",pa);
		jtp1.addTab("INVOICE",i);
		add(jtp1);
		
		//gets executed when tab is switched
				jtp1.addChangeListener(new ChangeListener() {
			        public void stateChanged(ChangeEvent e) {

			        	//gets executed when pharmacy tab is selected
			        	if(jtp1.getTitleAt(jtp1.getSelectedIndex()).equals("PHARMACY")) {
			        		pa.resupplyWindow();
			        	}
			        }
			    });
	}
	
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
            System.exit(0);
		
	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}