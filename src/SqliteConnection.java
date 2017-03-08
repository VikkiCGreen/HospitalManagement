import java.sql.*;
import javax.swing.*;


public class SqliteConnection 
{
	Connection conn = null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:SEPROJECT.sqlite");
			System.out.println("Connected to Database Successfully");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		return null;
		}
	}
}