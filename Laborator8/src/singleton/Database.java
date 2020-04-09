package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	
	public static Connection conn;

	static 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbums", "dba", "sql");
			
			System.out.println("Connected");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getCon() 
	{
		return conn;
	}
	
}
