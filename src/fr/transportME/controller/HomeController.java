package fr.transportME.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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
			
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/TransportME/api/verifLoginClient?user={loginUtil}&mdp={mdpUtil}"; 
			System.out.println("appel service url= "+url);
			ResponseEntity<Utilisateur> response = restTemplate.getForEntity(url, Utilisateur.class, loginUtil, mdpUtil );
			System.out.println("sortie appel service");
			boolean client = false; 
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				if (response.getBody()==null)
					// verif si login conducteur existe
				{
					restTemplate = new RestTemplate();
					url = "http://localhost:8080/TransportME/api/verifLoginConducteur?user={loginUtil}&mdp={mdpUtil}"; 
					System.out.println("appel service url= "+url);
					response = restTemplate.getForEntity(url, Utilisateur.class, loginUtil, mdpUtil );
					if (response.getStatusCode().equals(HttpStatus.OK))
					{
						if (response.getBody()==null)
						{
							model.addAttribute("errormessage", "utilisateur non trouvé");
							return "login";
						}
						else
						{
							client = false;
						}
					}
					else 
					{
						System.out.println("statut non ok");
						model.addAttribute("errormessage", "probleme survenu dans le service WEB de vérification de login");
						return "login";
					}
				}
				else
				{
					client = true;
				}
				
				System.out.println("statut ok "+response.getBody().getIdUtil());				
				session.setAttribute("idUtil", response.getBody().getIdUtil());
				
			}
			else
			{
				System.out.println("statut non ok");
				model.addAttribute("errormessage", "probleme survenu dans le service WEB de vérification de login");
				return "login";
			}
			
			System.out.println("aiguillage vers profil client ou conducteur suivant user");
			if (client)  {
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
	
	@RequestMapping(value = "/inscription/client", method = RequestMethod.POST)
	// dans inscription, mettre form:form modelAttribute="client"
	// et modifier html pour 
	// <input id="candidat_nom" type="text" class="validate" name="nom" value="${ candidat.nom }" />
	// <label for="candidat_nom">Nom</label>
	// <form:errors path="nom" />
	public String inscPost(@Valid @ModelAttribute("client") Client client, 
			BindingResult result, HttpSession session) {
			
			System.out.println("validation inscription");
			if (result.hasErrors()) {
				return "inscription";
			}
			
			System.out.println("appel service ecriture inscription");
			
			
			return "profilClient"; // ou profilConducteur
		}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logoutGet(Model model, HttpSession session) {
		System.out.println("déconnexion");
		session.invalidate();
		return "redirect:login";
	}
}
