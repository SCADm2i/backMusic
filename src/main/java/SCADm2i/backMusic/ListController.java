package SCADm2i.backMusic;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import SCADm2i.backMusic.biblio.MyList;

import SCADm2i.backMusic.repository.Biblio;

//Listens to ng serve port
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/list")
public class ListController {

	@Autowired
	Biblio biblio;

	@GetMapping(value = "")
	public JsonNode getList() throws SQLException {
		// Connects and collects the "biblio" database
		biblio.getConnection();
		ArrayList<MyList> mylist = biblio.getList();

		// Turning the array list of playlist into json object via jackson API
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode rootNode = mapper.createArrayNode();

		for (MyList malist : mylist) {
			ObjectNode objectnode = rootNode.addObject();

			objectnode.put("id", malist.id);
			objectnode.put("nom", malist.nom);

		}
		System.out.println("List json was returned from getList() of ListController");

		return rootNode;
	}

}
