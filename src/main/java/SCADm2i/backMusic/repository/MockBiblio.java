package SCADm2i.backMusic.repository;

import org.springframework.stereotype.Component;

import SCADm2i.backMusic.biblio.Music;
import SCADm2i.backMusic.biblio.Playlist;



//Mocks is used prior proper connection to the database
//Useful in first instance in order to check the controller

@Component
public class MockBiblio {
	
	// Obsolete code, mismatch MyList and Playlist classes
	
/*
	Playlist playlist01 = new Playlist();
	Music music = new Music();
	Music[]  musicTab= new Music[1];
	
	
	public MockBiblio() {		
		playlist01.id = 1;
		//playlist01.nom = "maPlaylist";
		
		music.id = 1;
		music.titre = "9th Symphony";
		music.interprete = "Beethoven";
		music.lien_audio = "none";
		music.lien_img = "none";
		music.genre = "classic";
		
		playlist01.playlist.add(music);
}
	
	
	public Playlist get() {
		return playlist01;
	}
	public Music[] getMusic() {
		musicTab[0] = music;
		return musicTab;
		}
*/	
}
