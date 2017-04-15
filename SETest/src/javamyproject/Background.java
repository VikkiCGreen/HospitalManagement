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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.sqlite.SQLiteConnection;


class Background extends JPanel
{
	double width,height;
	JLabel jl;
	int i;
	Background()
	{
		setLayout(null);
	setWidthHeight(100,200);
	
	}
	void setWidthHeight(double a,double b)
	{
		
		
		final String im[]={"i1","i2","i3"};
		
		width=a;
		height=b;
		setLayout(null);
		
		jl=new JLabel();
		jl.setBounds(0,0,1500,800);
		add(jl);
		//System.out.println("k2");
		
		
		
		new Thread(new Runnable()
		{
			public void run()
			{
				while(true)
				{
		//	System.out.println("k1");
					try
					{
					Thread.sleep(1000);				
					}
					catch(Exception e)
					{
						
					}
	
						jl.setIcon(new ImageIcon("E://images//"+im[i]+".jpg"));
						i++;
						if((i==im.length))
						{
							i=0;
						}
				
						
						try
						{
						Thread.sleep(2000);				
						}
						catch(Exception e)
						{
							
						}
						
						
						
				}
			}
		}).start();
		
		
	}
	
	
	
}