package SCADm2i.backMusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import SCADm2i.backMusic.biblio.Music;
import SCADm2i.backMusic.repository.Biblio;
//Import for testing using MockBiblio
//import SCADm2i.backMusic.repository.MockBiblio;

// Listens to Angular port
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/biblio")
public class MusicController {

	@Autowired
	Biblio biblio;

	@GetMapping(value = "")
	public JsonNode getBiblio() throws SQLException {

		// Connects and collects the "biblio" database
		biblio.getConnection();
		ArrayList<Music> list = biblio.getBiblio();

		// Turning the array list of musics into json object via jackson API
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode rootNode = mapper.createArrayNode();

		for (Music music : list) {
			// System.out.println(music.titre);
			ObjectNode objectnode = rootNode.addObject();

			objectnode.put("id", music.id);
			objectnode.put("titre", music.titre);
			objectnode.put("interprete", music.interprete);
			objectnode.put("lien_audio", music.lien_audio);
			objectnode.put("lien_img", music.lien_img);
			objectnode.put("genre", music.genre);
		}
		System.out.println("rootNode json was returned from getBiblio() musicController");
		return rootNode;
	}

	// Intended for tests using mock
	/*
	 * @Autowired MockBiblio mb;
	 * 
	 * // This method allows testing using the MockBiblio
	 * 
	 * @GetMapping("/mock") public Music[] getAll() { return mb.getMusic(); }
	 */

}