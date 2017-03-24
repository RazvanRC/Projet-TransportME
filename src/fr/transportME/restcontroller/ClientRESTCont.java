package fr.transportME.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.jdbc2.optional.MysqlXid;

import fr.transportME.DAO.ClientDAO;
import fr.transportME.model.Client;
import fr.transportME.model.Comment;
import fr.transportME.model.Course;

@RestController
@RequestMapping("/clients")
public class ClientRESTCont {
	
	@Autowired
	private ClientDAO clientDAO;
	
	/**
	 * methode pour la recherche d'un client
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Client> getClient(@PathVariable("id") int idClient, HttpSession session) {
		
//		return new ResponseEntity<Client>(this.clientDAO.find(((Client) session.getAttribute("utilisateur")).getIdUtil()),	HttpStatus.OK);
		return new ResponseEntity<Client>(this.clientDAO.find(idClient),	HttpStatus.OK);
	}
	
	/**
	 * methode pour l'inscription d'un client
	 * @param client
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/{id}", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Client> putClient(@RequestBody Client client, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
				return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Client>(clientDAO.save(client), HttpStatus.OK);
	}
	
	/**
	 * methode pour modification d'un client
	 * @param idClient
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Client> modifClient(@PathVariable(value = "id", required = false) int idClient, 
											@RequestBody Client client, BindingResult bindingResult) {

		// TODO securite de la modif
//		System.out.println(myClient.getNomUtil());
		client.setIdUtil(idClient);
		client = this.clientDAO.save(client);
//		System.out.println(myClient.getNomUtil());
		if (client == null)
			return new ResponseEntity<Client>( HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);

	}
	
	/**
	 * methode pour recuperer les commentaires pour un client
	 * @param idClient
	 * @return
	 */
	@RequestMapping(value="/{id}/comments", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Comment>> getCommentsHistory(@PathVariable(value="id", required=false) String idClient) {
		Client myClient = this.clientDAO.find(Integer.parseInt(idClient));
		return new ResponseEntity<List<Comment>>(myClient.getComments(), HttpStatus.OK);
	}
	
	/**
	 * methode pour recupere les trajets pour un client
	 * @param idClient
	 * @return
	 */
	@RequestMapping(value="/{id}/courses", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> getCoursesHistory(@PathVariable(value="id", required=false) String idClient) {
		Client myClient = this.clientDAO.find(Integer.parseInt(idClient));
		return new ResponseEntity<List<Course>>(myClient.getCourses(), HttpStatus.OK);
	}

}
