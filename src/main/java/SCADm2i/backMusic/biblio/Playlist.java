package SCADm2i.backMusic.biblio;

import java.util.ArrayList;

// Class intended for instances of playlists
public class Playlist {

	public int id;
	public ArrayList<Music> myMusic = new ArrayList<>();

	// This method returns a specific music from the List of music (namely playlist)
	// Else returns null
	public Music getMusic(int musicId) {
		for (Music music : myMusic) {
			if (music.id == musicId) {
				return music;
			}
		}
		return null;
	}

	// Returns the list of music object from a (specific) playlist
	public ArrayList<Music> getAll() {
		return myMusic;
	}

	
	// Overrides interface methods of List... Auto Generated... for the good
	// practice but don't ask questions please
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
