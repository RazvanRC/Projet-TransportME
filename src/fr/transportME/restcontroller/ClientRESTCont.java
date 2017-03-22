package fr.transportME.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.transportME.DAO.ClientDAO;
import fr.transportME.model.Client;

@RestController
@RequestMapping("/client")
public class ClientRESTCont {
	
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(value="/profil", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Client> getClient(HttpSession session) {
		
		return new ResponseEntity<Client>(this.clientDAO.find(((Client) session.getAttribute("utilisateur")).getIdUtil()),	HttpStatus.OK);
	}
	
	@RequestMapping(value="", method= RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Client> putClient(@RequestBody Client client) {
//		fournisseur = this.fournisseurDAO.save(fournisseur);
		return new ResponseEntity<Client>(clientDAO.save(client), HttpStatus.OK);
	}

}
