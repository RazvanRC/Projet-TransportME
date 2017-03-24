package fr.transportME.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.transportME.DAO.UtilisateurDAO;
import fr.transportME.model.Client;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Utilisateur;
import fr.transportME.validation.WrongUsernameOrPasswordException;

@RestController
public class LoginVerif {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@RequestMapping(value="/verifLoginClient", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Utilisateur> getClient(HttpSession session,
			@RequestParam(value = "user", required = false) String loginUtil,
			@RequestParam(value = "mdp", required = false) String mdpUtil) {
		
		try {
			System.out.println("dans verifloginclient, loginUtil= "+loginUtil+" mdp= "+mdpUtil);
			Utilisateur user = this.utilisateurDAO.auth(loginUtil, mdpUtil);
			
			if ( user instanceof Client) {
				System.out.println("instance client");
				return new ResponseEntity<Utilisateur>(user,	HttpStatus.OK);
			}
			else 
				{System.out.println("dans else");
				return new ResponseEntity<Utilisateur>(HttpStatus.OK);
				}
		} catch (WrongUsernameOrPasswordException e) {
			System.out.println("dans exception, e="+e);
			return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/verifLoginConducteur", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Utilisateur> getConducteur(HttpSession session,
			@RequestParam(value = "user", required = false) String loginUtil,
			@RequestParam(value = "mdp", required = false) String mdpUtil) {
		
		try {
			Utilisateur user = this.utilisateurDAO.auth(loginUtil, mdpUtil);
			if ( user instanceof Conducteur) {
				return new ResponseEntity<Utilisateur>(user,	HttpStatus.OK);
			}
			else
				return new ResponseEntity<Utilisateur>(HttpStatus.OK);
		} catch (WrongUsernameOrPasswordException e) {
			return new ResponseEntity<Utilisateur>(HttpStatus.BAD_REQUEST);
		}
	}

}
