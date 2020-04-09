package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController extends Database {

	public void create(String name, String country) 
	{
		if(strcmp(conn,"Connected")==true)
		{
			Statement st = conn.createStatement();

	        String stmt = "insert into artists values(" + name + ", " + country + ");";
	        st.execute(stmt);
		}
		
	}
	
	public void findByName(String name)
	{
		if(strcmp(conn,"Connected")==true)
		{
			Statement st = conn.createStatement();

	        String stmt = "select * from artist where name = '" + name + "';" ;
	        st.execute(stmt);
		}
	}
}
