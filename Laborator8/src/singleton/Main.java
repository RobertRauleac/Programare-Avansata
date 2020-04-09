package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Database conn = new Database();
		conn.getCon();
		
		ArtistController artist = new ArtistController();
		artist.create("Stefan Banica Jr.", "Romania");
		artist.create("Jan de la Hunedoara", "Romania");
		artist.create("Chris Lane", "USA");
		artist.create("Harry Styles", "UK");
		
		AlbumController album = new AlbumController();
		album.create("Fine line", 4, 2019);
		album.create("Summer", 3, 2016);
		album.create("Tralalala", 2, 2020);
		album.create("Din inima", 1, 2004);
		
		artist.findByName("Harry Styles");
		artist.findByName("Jan de la Hunedoara");
		
		album.findByArtist(1);
		album.findByArtist(2);
	}

}
