package SCADm2i.backMusic.repository;

import org.springframework.stereotype.Component;

import SCADm2i.backMusic.biblio.Music;
import SCADm2i.backMusic.biblio.MyList;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

// This class communicates through Postgres database and returns objects to controllers when applicable
// Manages both music and list controllers 

// TODO : implement get post delete methods
@Component
public class Biblio {

	private Connection c = null;
	private Statement st = null;

	// Connectivity
	public void getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			// Use your own identifier and password
			// IP address points to localhost (common for all computers)

			c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/SCADmusic", "postgres", "FORMATION");
			st = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Requesting for the "biblio" database
	public ArrayList<Music> getBiblio() throws SQLException {

		// Returns the ArrayList to be parsed to json via musicController

		ArrayList<Music> biblio = new ArrayList<>();

		ResultSet rs = st.executeQuery(String.format("SELECT * FROM music"));

		while (rs.next()) {
			// Declares music object to be fetched back from postgres database
			Music music = new Music();
			// System.out.println(rs.getObject("titre"));
			music.id = (int) rs.getInt("id");
			music.titre = (String) rs.getString("titre");
			music.interprete = (String) rs.getString("interprete");
			music.lien_audio = (String) rs.getString("lien_audio");
			music.lien_img = (String) rs.getString("lien_img");
			music.genre = (String) rs.getString("genre");

			biblio.add(music);
		}
		return biblio;
	}

	// Gets the list of lists
	public ArrayList<MyList> getList() throws SQLException {

		ArrayList<MyList> list = new ArrayList<>();
		ResultSet rs = st.executeQuery(String.format("SELECT * FROM list"));

		while (rs.next()) {
			MyList malist = new MyList();
			// System.out.println(rs.getString("nom"));
			malist.id = (int) rs.getInt("id");
			malist.nom = (String) rs.getString("nom");

			list.add(malist);
		}
		return list;
	}

	// Request list of music of one playlist (id)
	public ArrayList<Music> getPlaylist(int id) throws SQLException {
		
		ArrayList<Music> playlist = new ArrayList<>();
		ResultSet rs = st.executeQuery(String.format("SELECT music.id, music.titre, music.interprete, music.lien_audio, music.lien_img, music.genre  FROM list \r\n" + 
				"\r\n" + 
				"RIGHT JOIN playlist ON list.id = playlist.id_list \r\n" + 
				"\r\n" + 
				"RIGHT JOIN music ON playlist.id_music = music.id\r\n" + 
				"\r\n" + 
				"WHERE list.id=" + id));

		while (rs.next()) {
			// Declares music object to be fetched back from postgres database
			Music music = new Music();
			// System.out.println(rs.getObject("titre"));
			
			music.id = (int) rs.getInt("id");
			music.titre = (String) rs.getString("titre");
			music.interprete = (String) rs.getString("interprete");
			music.lien_audio = (String) rs.getString("lien_audio");
			music.lien_img = (String) rs.getString("lien_img");
			music.genre = (String) rs.getString("genre");

			playlist.add(music);
		}
		return playlist;
	}

	// Modify/execute
//	    public void getAll(String message) throws SQLException {
//
//	    	
//	        st.execute(String.format(message));
//
//	    }
//	

}
