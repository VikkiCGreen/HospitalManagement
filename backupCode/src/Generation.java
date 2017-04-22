import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Generation extends JPanel
{
	JLabel username,hlabel;
	JLabel password;
	JLabel username1;
	JLabel password1;
	Register reg1;
	JButton jb1;
	Font f,f1;
	private BufferedImage image,image1;

	 Generation(String s)
	 {
		 reg1 = new Register("");
		 this.setTitle("Username-Password Generation");
		 setLayout(null);
		 
		 f = new Font("Arial",Font.PLAIN,18);
		 f1 = new Font("Arial",Font.BOLD,30);
		 setFont(f);
		 setFont(f1);
		 
		hlabel = new JLabel("CONGRATULATIONS!");
		 hlabel.setBounds(480,0,450,50);
			hlabel.setFont(f1);
			hlabel.setForeground(Color.BLUE);
			add(hlabel);
		// reg1.password();
		 username = new JLabel("User Name:");
		 username.setBounds(50, 20, 150, 50);
		 username.setFont(f);
		 
		 username1 = new JLabel();
		// username1.setText("c_"+reg1.msg1);
		 username1.setBounds(175, 20, 150, 50);
		 username1.setFont(f);
		 jb1 = new JButton("OK");
		 jb1.setBounds(200,200,70,30);
		 jb1.setFont(f);
		 
		 add(jb1);
		
		 password1 = new JLabel();
		 password = new JLabel("Password:");
		 password.setBounds(50, 80, 150, 50);
		 password.setFont(f);
		

		 password1.setBounds(175, 80, 150, 50);
		 password1.setFont(f);
		 
		 
		 add(username); 
		 add(password); 
		 add(username1); 
		 add(password1);
		 
		 try 
		 {     
			 image = ImageIO.read(new File("E:\\Users\\Vikki\\Pictures\\Hospital Management\\i5.jpg"));
		 } 
		 catch (IOException ex) 
		 {       
			 //stuff
		 }
		
	}
	private void setTitle(String string) 
	{
			// TODO Auto-generated method stub
			
	}
	protected void paintComponent(Graphics g) 
	{
		   super.paintComponent(g);
		   g.drawImage(image,650,100,650,375,null);
		   
	}

}