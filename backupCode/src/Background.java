import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		final String im[] = {"i1","i2","i3"};
		
		width = a;
		height = b;
		setLayout(null);
		
		jl = new JLabel();
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
	
						jl.setIcon(new ImageIcon("E:\\Users\\Vikki\\Pictures\\Hospital Management\\" + im[i] + ".jpg"));
						i++;
						if((i == im.length))
						{
							i = 0;
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