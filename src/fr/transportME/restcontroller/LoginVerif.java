package fr.transportME.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		Utilisateur user=null;
		try {
			System.out.println("dans verifloginclient, loginUtil= "+loginUtil+" mdp= "+mdpUtil);
			user = this.utilisateurDAO.auth(loginUtil, mdpUtil);
			
			if ( user instanceof Client) {
				System.out.println("instance client qghqfdh");
				return new ResponseEntity<Utilisateur>(user,	HttpStatus.OK);
			}
			else 
				{System.out.println("dans else");
				user.setLoginUtil("suite");
				return new ResponseEntity<Utilisateur>(HttpStatus.OK);
				}
		} catch (WrongUsernameOrPasswordException e) {
			// si pbe select dans la methode auth OU utilisateur non trouv� dans la base
			System.out.println("dans exception modifi�e, e="+e);
			return new ResponseEntity<Utilisateur>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/verifLoginConducteur", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Utilisateur> getConducteur(HttpSession session,
			@RequestParam(value = "user", required = false) String loginUtil,
			@RequestParam(value = "mdp", required = false) String mdpUtil) {
		Utilisateur user=null;
		try {
			user = this.utilisateurDAO.auth(loginUtil, mdpUtil);
			if ( user instanceof Conducteur) {
				System.out.println("instance conducteur");
				return new ResponseEntity<Utilisateur>(user,	HttpStatus.OK);
			}
			else
			{
				System.out.println("user autre que conducteur");
				return new ResponseEntity<Utilisateur>(HttpStatus.OK);
			}
		} catch (WrongUsernameOrPasswordException e) {
				System.out.println("dans exception conducteur, e="+e);
			return new ResponseEntity<Utilisateur>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
