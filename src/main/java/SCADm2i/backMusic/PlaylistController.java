package SCADm2i.backMusic;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import SCADm2i.backMusic.biblio.Music;
import SCADm2i.backMusic.repository.Biblio;

//Listens to ng serve port
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	Biblio biblio;

	@GetMapping(value = "/{id}")
	public String getPlaylist(@PathVariable int id) throws SQLException {

		System.out.println("cated to :" + id);

		biblio.getConnection();
		ArrayList<Music> listMusic = biblio.getPlaylist(id);

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode rootNode = mapper.createArrayNode();

		for (Music maMusic : listMusic) {
			ObjectNode objectnode = rootNode.addObject();
			// TODO to be implemented
			objectnode.put("id", maMusic.id);
			objectnode.put("titre", maMusic.titre);
			objectnode.put("interprete", maMusic.interprete);
			objectnode.put("lien_audio", maMusic.lien_audio);
			objectnode.put("lien_img", maMusic.lien_img);
			objectnode.put("genre", maMusic.genre);
		}
		System.out.println("List json was returned from getList() of ListController");
		System.out.println("Root node looks like " + rootNode);

		return ("[{'id': " + id + ", 'playlist: '" + rootNode);

	}

}
