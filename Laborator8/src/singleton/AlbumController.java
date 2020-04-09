package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController extends Database {
	
	public void create(String name, int artistId, int releaseYear)
	{
		if(strcmp(conn,"Connected")==true)
		{
			Statement st = conn.createStatement();

	        String stmt = "insert into albums values(" + name + ", " + artistId + ", " + releaseYear +");";
	        st.execute(stmt);
		}
	}
	
	public void findByArtist(int artistId)
	{
		if(strcmp(conn,"Connected")==true)
		{
			Statement st = conn.createStatement();

	        String stmt = "select * from albums where artist_id = '" + artistId + "';" ;
	        st.execute(stmt);
		}
	}
	
}
