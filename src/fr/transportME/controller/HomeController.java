package fr.transportME.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.transportME.DAO.DAO;
import fr.transportME.model.Utilisateur;
import fr.transportME.validation.WrongUsernameOrPasswordException;

@Controller
public class HomeController {	

	private Boolean errorLogin = false;
	
	
	private Utilisateur utilisateur;
	
	@Autowired
	DAO<Utilisateur> utilisateurDao;

	// acc�s page Accueil
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String accGet() {
		return "accueil";	
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String loginGet(Model model, HttpSession session) {
		model.addAttribute("formLogin", new Utilisateur());
		model.addAttribute("utilisateur", null);
		
		if (session.getAttribute("user") == null && errorLogin == false) {
			model.addAttribute("errormessage", null);
			return "login";
		}
		else if (session.getAttribute("user") == null && errorLogin == true) {
			model.addAttribute("errormessage", "Le login et/ou le mot de passe est incorrect !");
			return "login";
		}
		else {
			errorLogin = false;
			return "choix";
		}		
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginPost(Model model, HttpSession session,
			@RequestParam(value = "loginUtil", required = false) String loginUtil,
			@RequestParam(value = "mdpUtil", required = false) String mdpUtil,
			@RequestParam(value = "typeUtilisateur") String typeUtilisateur
			) {
		
			System.out.println("connection type utilisateur "+typeUtilisateur);
			try {
				utilisateurDao.auth(loginUtil, mdpUtil);
			} catch (WrongUsernameOrPasswordException e) {
				model.addAttribute("errormessage", "utilisateur non trouv�");
				return "login";
			}
			model.addAttribute("utilisateur", loginUtil);
			if (typeUtilisateur.equals("Client"))  {
				return "profilClient";	
			}
			else
				return "profilConducteur";	
				
		}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscGet(Model model, HttpSession session) {
		
			System.out.println("inscriptionnnn");
			return "inscription";
			

		}
}
