package fr.transportME.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.transportME.DAO.DAO;
import fr.transportME.model.Client;
import fr.transportME.model.Utilisateur;
import fr.transportME.validation.WrongUsernameOrPasswordException;

@Controller
public class HomeController {	

	private Boolean errorLogin = false;
	
	
	private Utilisateur utilisateur;
	
	@Autowired
	DAO<Utilisateur> utilisateurDao;

	// accès page Accueil
	@RequestMapping(value = {"/","/accueil"}, method = RequestMethod.GET)
	public String accGet(Model model) {
		model.addAttribute("page", "accueil");
		return "accueil";	
	}
	
	// affichage formulaire de connection
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String loginGet(Model model, HttpSession session) {
		model.addAttribute("formLogin", new Utilisateur());
		model.addAttribute("utilisateur", null);
		model.addAttribute("page", "login");
		model.addAttribute("errormessage", null);
		
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
	
	// recupération données de connection et vérification existance dans la BDD
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginPost(Model model, HttpSession session,
			@RequestParam(value = "loginUtil", required = false) String loginUtil,
			@RequestParam(value = "mdpUtil", required = false) String mdpUtil
			) {
		
			System.out.println("connection");
			Utilisateur user;
			try {
				user = utilisateurDao.auth(loginUtil, mdpUtil);
			} catch (WrongUsernameOrPasswordException e) {
				model.addAttribute("errormessage", "utilisateur non trouvé");
				return "login";
			}
			model.addAttribute("utilisateur", loginUtil);
			if (user instanceof Client)  {
				System.out.println("vers profil client");
				return "profilClient";	
			}
			else
				System.out.println("vers profil conducteur");
				return "profilConducteur";	
				
		}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscGet(Model model, HttpSession session) {
			model.addAttribute("page", "inscription");
			
			System.out.println("inscriptionnnn");
			return "inscription";
			

		}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logoutGet(Model model, HttpSession session) {
		System.out.println("déconnexion");
		session.invalidate();
		return "redirect:login";
	}
}
